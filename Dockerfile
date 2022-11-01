FROM openjdk:11
EXPOSE 8090
ADD target/aws-app.jar aws-app.jar
ENTRYPOINT ["java","-jar","/aws-app.jar"]
