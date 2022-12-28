FROM openjdk:11
RUN mkdir /app
COPY ./target/ /app
WORKDIR /app
RUN ls
CMD ["java","-jar", "dockerizedspringboot-0.0.1.jar"]