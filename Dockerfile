FROM hirokimatsumoto/alpine-openjdk-11
COPY ./target/*.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "coffee-service-0.0.1-SNAPSHOT.jar"]