FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/mic-e-commerce-auth-1.0.0.jar
COPY ${JAR_FILE} app_auth.jar
EXPOSE 8000
ENTRYPOINT [ "java", "-jar", "app_auth.jar" ]