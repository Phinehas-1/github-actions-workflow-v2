FROM eclipse-temurin:11-jdk-alpine
RUN mkdir /app
RUN ls -a
COPY ./target/ /app
WORKDIR /app
RUN ls
CMD ["java","-jar", "dockerizedspringboot-0.0.1.jar"]