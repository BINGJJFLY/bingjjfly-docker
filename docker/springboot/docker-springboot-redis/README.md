1.创建Dockerfile文件
FROM java:8
MAINTAINER bingjjfly<bingjjfly@docker.org>
COPY docker-springboot-redis-0.0.1-SNAPSHOT.jar /docker-springboot-redis-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/docker-springboot-redis-0.0.1-SNAPSHOT.jar"]

2.复制jar包和Dockerfile文件到服务器
ls /mydocker/docker-springboot-redis
Dockerfile  docker-springboot-redis-0.0.1-SNAPSHOT.jar

3.创建镜像
docker build -t docker-spring-redis:1.0 .

4.下载Redis镜像并创建容器
docker pull redis
docker run -d --name redis-6379 redis

5.创建容器
docker run -d --link redis-6379 --name docker-spring-redis-1.0 docker-spring-redis:1.0

6.进入容器内访问项目
docker exec -it docker-spring-redis-1.0 /bin/bash
root@85ffe938867f:/# curl 127.0.0.1:9000/index