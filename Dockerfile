FROM openjdk:8
MAINTAINER Saiakash Konidena saiakash.konidena@gmail.com
COPY ./target/calc-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "calc-1.0-SNAPSHOT-jar-with-dependencies.jar"]