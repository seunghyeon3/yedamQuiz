FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
ARG WALLET=wallet_quiz
COPY ${JAR_FILE} app.jar
COPY ${WALLET} /home/wallet_quiz/
ENTRYPOINT ["java","-jar", "/app.jar"]
