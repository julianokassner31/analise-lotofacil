FROM tomcat:8.0-jre8-alpine
COPY ./target/analise-lotofacil-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/analise.war
COPY ./tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
CMD ["catalina.sh", "run"]