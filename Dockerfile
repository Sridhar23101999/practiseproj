FROM debian:trixie-slim

COPY jdk-8u202-linux-x64.tar.gz /tmp/

RUN apt-get update && \
    apt-get install -y --no-install-recommends tar && \
    mkdir -p /opt/java && \
    tar -xvf /tmp/jdk-8u202-linux-x64.tar.gz -C /opt/java --strip-components=1 && \
    rm /tmp/jdk-8u202-linux-x64.tar.gz && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/opt/java
ENV PATH=$JAVA_HOME/bin:$PATH

LABEL org.opencontainers.image.authors="reveng"

COPY target/practiseproj-1.0.0.jar /app/practiseproj.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "practiseproj.jar"]