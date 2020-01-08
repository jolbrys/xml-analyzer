FROM openjdk:8
ADD target/xml-analyzer.jar xml-analyzer.jar
EXPOSE 9393
ENTRYPOINT ["java", "-jar", "xml-analyzer.jar"]