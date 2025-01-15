FROM tomcat:9.0

COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]