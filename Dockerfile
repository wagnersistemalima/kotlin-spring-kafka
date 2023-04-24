FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 8080
ADD ./build/libs/kafkaDemo-0.0.1-SNAPSHOT.jar kafkaDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kafkaDemo-0.0.1-SNAPSHOT.jar"]