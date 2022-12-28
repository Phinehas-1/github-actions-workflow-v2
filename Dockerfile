FROM openjdk:11
RUN mkdir /app
RUN ls -a
COPY ./target/ /app
WORKDIR /app
RUN ls
CMD ["java","-jar", "*.jar"]