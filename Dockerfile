FROM openjdk:17
EXPOSE 8080
ADD target/docker-image-demoApp.jar springboot-image-demoApp.jar
ENTRYPOINT ["java","-jar","/springboot-image-demoApp.jar"]
