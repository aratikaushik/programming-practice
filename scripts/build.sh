#!/bin/bash

rm -rf bin
mkdir -p bin

javac -d bin src/euler/*.java
javac -d bin src/leetCode/*.java
