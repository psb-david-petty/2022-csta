#!/bin/sh
#
# Shell script to prepare codecheck.zip
#

rm -f codecheck.zip
zip -v codecheck -@ < zipfiles.txt