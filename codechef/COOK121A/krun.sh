#!/usr/bin/env bash

#Check for the file name
if [ -z "$1" ]
  then
    echo "Error : No file name supplied"
    exit 1
fi

FILE_NAME="$1.kt"
INPUT_FILE="$1_INPUT.txt"
CLASS_NAME="$1Kt"
CLASS_FILE="$1.class"

kotlinc $FILE_NAME -include-runtime -d out.jar
java -jar out.jar < "$INPUT_FILE"
rm out.jar