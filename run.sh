#!/bin/bash

mvn clean install assembly:single -q
java -jar target/geektrust.jar sample_input/input1.txt