FROM openjdk:17
LABEL maintainer="com.csi"
ADD target/dockerspringboot-0.0.1-SNAPSHOT.jar dockerspringboot.jar
ENTRYPOINT ["java", "-jar", "dockerspringboot.jar"]
