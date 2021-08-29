package uz.gigalab.utilities.notification;

/**
 * @author Farkhod Daniyarov <farkhod.daniyarov@gmail.com>
 * @since 29.08.2021
 */
public interface GigalabNotificationService {

    /**
     * Отправка в телеграм статуса о завершения работы микро-сервиса
     *
     * @param chatId      чат id группы
     * @param serviceName название микро-сервиса
     */
    void sendTelegramShutdownStatus(String botToken, Long chatId, String serviceName);

    /**
     * Отправка в телеграм статуса о поднятия микро-сервиса
     *
     * @param chatId      чат id группы
     * @param serviceName название микро-сервиса
     */
    void sendTelegramUpStatus(String botToken, Long chatId, String serviceName);
}
