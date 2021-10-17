FROM adoptopenjdk:8-jre
WORKDIR /app
COPY ./target/analise-lotofacil-0.0.1-SNAPSHOT.war analise.war
ENTRYPOINT  ["java", "-jar", "-Dspring.datasource.url=jdbc:postgresql://${DNS}:5432/loteria_api", "analise.war"]
EXPOSE 8081