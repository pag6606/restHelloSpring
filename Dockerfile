FROM openjdk:8
ADD target/hello-demo.jar hello-demo.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "hello-demo.jar"]
