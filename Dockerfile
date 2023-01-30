FROM alpine:3.14

# SET TIMEZONE
RUN apk --no-cache add tzdata && \
		cp /usr/share/zoneinfo/Asia/Seoul /etc/localtime && \
        echo "Asia/Seoul" > /etc/timezone

# SET UTF-8
ENV LANG ko_KR.UTF-8

# install curl, openjdk, nc
RUN apk --no-cache add curl openjdk11-jre netcat-openbsd
ADD WordPipe-1.0-SNAPSHOT.jar WordPipe-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "WordPipe-1.0-SNAPSHOT.jar"]