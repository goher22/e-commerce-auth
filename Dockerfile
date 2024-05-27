FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mkdir /opt/app
COPY ./target/*.jar /opt/app
CMD ["java","-jar","/opt/app/mic-e-commerce-auth-1.0.0.jar"]