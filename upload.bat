@echo off
echo =-------------------
echo git add -A
echo -------------------=
git add -A
echo =-------------------
echo git commit -m "committed by Farkhod"
echo -------------------=
git commit -m "committed by Farkhod"
echo =-------------------
echo git pull origin master
echo -------------------=
git pull origin master
echo =-------------------
echo git push origin master
echo -------------------=
git push origin master

set sec=3
echo =-------------------
echo Window will be closed in %sec% seconds
echo -------------------=
:symbol
set /a sec=sec-1
ping -n 2 -w 100 127.1>nul
if %sec%==0 (exit) else (goto symbol)
