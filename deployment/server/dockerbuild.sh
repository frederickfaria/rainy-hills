#!/usr/bin/env bash

mvn clean install -DskipTests=true -f ../../pom.xml

cp ../../target/rainy-hills.war rainy-hills.war

docker build -t frederickfaria/rainy-hills:1.2 .
docker push frederickfaria/rainy-hills:1.2

docker tag frederickfaria/rainy-hills:1.2 frederickfaria/rainy-hills:latest
docker push frederickfaria/rainy-hills:latest

rm rainy-hills.war