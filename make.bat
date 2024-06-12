
call gradle assemblerelease 
rem -warning-mode all

copy /y app\build\outputs\apk\release\app-release.apk demo.apk
 
