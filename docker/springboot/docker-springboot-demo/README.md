1.创建Dockerfile文件
FROM java:8
MAINTAINER bingjjfly<bingjjfly@docker.org>
COPY docker-springboot-demo-0.0.1-SNAPSHOT.jar /docker-springboot-demo-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/docker-springboot-demo-0.0.1-SNAPSHOT.jar"]

2.复制jar包和Dockerfile文件到服务器
ls /mydocker/docker-springboot-demo
Dockerfile  docker-springboot-demo-0.0.1-SNAPSHOT.jar

3.创建镜像
docker build -t docker-spring-demo:1.0 .

4.创建容器
docker run -d --name docker-spring-demo-1.0 docker-spring-demo:1.0

5.进入容器内访问项目
docker exec -it docker-spring-demo-1.0 /bin/bash
root@85ffe938867f:/# curl 127.0.0.1:9000/index