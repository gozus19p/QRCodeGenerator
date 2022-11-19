#!/bin/bash

# Checking Java installation
java_dir=$(whereis java)
if [ "$java_dir" == "java:" ]; then

  echo "You need to install Java first!"
  exit 1
fi

# Checking for non-null data input
if [ -z "$1" ]; then

  echo "No data provided"
  exit 1
fi

# Checking for non-null output path input
if [ -z "$2" ]; then

  echo "No output path provided"
  exit 1
fi

# Updating application...
echo -n "Building application... "
./gradlew clean jar >/dev/null

# Renaming fat-jar
mv ./build/libs/*.jar ./build/libs/App.jar
echo "Done"

# Running fat-jar
java -jar ./build/libs/App.jar $1 $2
