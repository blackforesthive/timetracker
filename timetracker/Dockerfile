FROM openjdk:11.0.4-jdk
ENV APP_FILE timetracker-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 8088
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]