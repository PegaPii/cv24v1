FROM maven:3.6.3-openjdk-17 as build
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn -f /app clean package
CMD ["mvn", "spring-boot:run"]