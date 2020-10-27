
FROM openjdk:8-jre-alpine
MAINTAINER allen.jin <allen.jin@chinascope.com>

ARG VERSION
ENV VERSION $VERSION

RUN echo "http://mirrors.aliyun.com/alpine/v3.8/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.8/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache ttf-dejavu procps unzip curl bash tzdata vim \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ADD target/java/dist-${VERSION}*.tar.gz /app/services/
RUN  ln -s /app/services/java/dist-${VERSION} /app/services/java/dist \
  && chmod +x /app/services/java/dist/bin/*.sh

EXPOSE 8080

ENTRYPOINT ["/app/services/java/dist/bin/start_inside.sh"]
CMD []
