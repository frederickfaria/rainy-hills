#!/usr/bin/env bash

mvn clean install -DskipTests=true -f ../../pom.xml

cp ../../target/rainy-hills.war rainy-hills.war

docker build -t frederickfaria/rainy-hills .

#docker push frederickfaria/rainy-hills

rm rainy-hills.war