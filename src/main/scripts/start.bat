@echo off
echo 正在启动，请稍候...
setlocal EnableDelayedExpansion
set classpath=.
for %%i in ("..\lib\*.jar") do set classpath=!classpath!;%%i
for %%j in ("..\lib_ext\*.jar") do set classpath=!classpath!;%%j
@REM launch echo %classpath%
endlocal & set classpath=%classpath%

start javaw -Xms512m -Xmx1024m bootstrap.Launcher start %1 %2
echo 启动成功！
pause
