FROM openjdk:11.0.4-jdk
RUN apt-get install -y curl
ENV APP_FILE uiserver-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 8764
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]