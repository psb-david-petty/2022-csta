:codecheck .BAT file

set zip=tar
set args=-zcvf
set src=-Tzipfiles.txt

if [%1]==[] goto args
set zip=%1

:args
if [%2]==[] goto src
set args=%~2

:src
if [%3]==[] goto zip
set src=%~3

:zip
del /F "codecheck.zip"
%zip% %args% codecheck.zip %src%
