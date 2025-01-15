FROM maven:3.8.4-openjdk-11 as builder
WORKDIR /app
COPY . .
RUN mvn clean package

FROM tomcat:9.0
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]