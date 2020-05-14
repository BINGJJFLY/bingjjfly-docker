1.创建Dockerfile文件
FROM java:8
MAINTAINER bingjjfly<bingjjfly@docker.org>
COPY docker-springboot-compose-0.0.1-SNAPSHOT.jar /docker-springboot-compose-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/docker-springboot-compose-0.0.1-SNAPSHOT.jar"]

2.创建docker-compose.yml文件
version: '3'
services:
  web:
    build: .
    ports:
      - "9000:9000"
  redis-6379:
    image: "redis:alpine"

3.复制jar包到服务器
ls /myCompose
docker-compose.yml  Dockerfile  docker-springboot-compose-0.0.1-SNAPSHOT.jar

3.构建并运行项目
docker-compose up -d

4.访问项目
curl 127.0.0.1:9000/index

5.查看容器、镜像、网络、数据卷
docker-compose ps
docker image ls
docker network ls
docker volume ls

6.运行一次行命令
docker-compose run redis-6379 env

7.停止容器
docker-compose stop

8.删除容器、网络
docker-compose down