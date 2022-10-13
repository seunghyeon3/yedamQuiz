FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY wallet_quiz/* wallet_quiz
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]
