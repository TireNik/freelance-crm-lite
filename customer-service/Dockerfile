FROM amazoncorretto:17-alpine
WORKDIR /app
WORKDIR /app
COPY target/*.jar app.jar
RUN apk add --no-cache curl
ENTRYPOINT ["java", "-jar", "app.jar"]


#FROM openjdk:17-jdk-slim as builder
#
#WORKDIR /app
#COPY . .
#RUN ./mvnw clean package -DskipTests
#
#FROM openjdk:17-jre-slim
#WORKDIR /app
#COPY --from=builder /app/target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]