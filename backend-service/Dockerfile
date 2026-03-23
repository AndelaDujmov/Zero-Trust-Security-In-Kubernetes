FROM alpine/java:21-jdk

RUN apk add --no-cache bash curl tar \
    && mkdir -p /opt/maven \
    && curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz \
       | tar -xzC /opt/maven --strip-components=1 \
    && ln -s /opt/maven/bin/mvn /usr/bin/mvn

WORKDIR /app

COPY target ./target

ENTRYPOINT [ "java", "-jar", "target/backend-service-0.0.1-SNAPSHOT.jar" ]