:codecheck .BAT file

set zip=winrar
set args=a -afzip

if [%1]==[] goto args
set zip=%1

:args
if [%2]==[] goto zip
set args=%~2

:zip
del /F "codecheck.zip"
%zip% %args% codecheck @zipfiles.txt