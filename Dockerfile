FROM java:8

MAINTAINER rmeloca@gmail.com

WORKDIR /app

ADD ./target/Passenger.jar /app/

EXPOSE 8080

CMD ["java", "-Xmx200m", "-jar", "/app/Passenger.jar"]