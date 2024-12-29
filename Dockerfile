FROM openjdk:21-jdk-slim
ARG JAR_FILE=build/libs/tailor-management-system-0.0.1-SNAPSHOT.jar.
COPY build/libs/tailor-management-system-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]