#!/bin/bash

cd server
chmod +x mvnw
./mvnw clean package -DskipTests
java -jar target/*.jar