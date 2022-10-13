FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY wallet_quiz/*.* /home/
ENTRYPOINT ["java","-jar", "/app.jar"]
