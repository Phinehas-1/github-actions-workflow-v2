FROM openjdk:11
RUN mkdir /app
COPY ./target/ /app
WORKDIR /app
CMD ["java","-jar", "*.jar"]