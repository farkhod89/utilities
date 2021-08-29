package uz.gigalab.utilities.notification;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author Farkhod Daniyarov <farkhod.daniyarov@gmail.com>
 * @since 29.08.2021
 */
@Service
public class GigalabNotificationServiceImpl implements GigalabNotificationService {

    @Override
    public void sendTelegramShutdownStatus(String botToken, Long chatId, String serviceName) {
        String message = "SERVICE SHUTDOWN: " + serviceName;
        try {
            sendMessage(botToken, chatId, message);
        } catch (Exception ignored) {
        }

    }

    @Override
    public void sendTelegramUpStatus(String botToken, Long chatId, String serviceName) {
        String message = "SERVICE UP: " + serviceName;
        try {
            sendMessage(botToken, chatId, message);
        } catch (Exception ignored) {
        }
    }

    @SneakyThrows
    private void sendMessage(String botToken, Long chatId, String message) {

        HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .version(HttpClient.Version.HTTP_2)
            .build();

        UriBuilder builder = UriComponentsBuilder
            .fromHttpUrl("https://api.telegram.org")
            .path("/{token}/sendMessage")
            .queryParam("chat_id", chatId)
            .queryParam("text", message);

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(builder.build("bot" + botToken))
            .timeout(Duration.ofSeconds(5))
            .build();

        HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
    }

}


















