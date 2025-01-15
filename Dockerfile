FROM maven:3.8.4-openjdk-8 as builder
COPY . .
RUN mvn clean package

FROM tomcat:9.0
COPY --from=builder target/*.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]