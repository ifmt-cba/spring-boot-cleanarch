<h1 align="center">
  Spring Boot Clean Architecture
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Youtube&message=@jppreti&color=8257E5&labelColor=000000" alt="@jppreti" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Demo&color=8257E5&labelColor=000000" alt="Demo" />
</p>

Demo para ilustrar como implementar Clean Architecture utilizando Spring Boot.

# 1. Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
- [H2](https://www.h2database.com)

# 2. Como Executar

- Clonar repositório git:
```shell
git clone https://github.com/ifmt-cba/spring-boot-cleanarch.git
```

## 2.1. Sem o uso de contêiner

- Construir o projeto:
```shell
./mvnw clean package
```
- Executar:
```shell
java -jar ./target/spring-boot-cleanarch-v1.0.jar
```
- Testar ( com [httppie](https://httpie.io) ):
```shell
http POST :7070/users username=username password=password email=email
```

## 2.2. Com Docker

- Construir os projetos:
```shell
./build.sh
./spring-boot-cleanarch-client-cli/build.sh
```
- Executar:
```shell
docker compose up -d
```
- Testar ( com [httppie](https://httpie.io) ):
```shell
http POST :7070/users username=username password=password email=email
```
ou
- Testar com CLI:
```shell
docker attach cleanarch-cli
```

## 2.3. Com Kubernetes (Minikube)

- Construir os projetos:
```shell
minikube start
minikube docker-env
eval $(minikube -p minikube docker-env)
./build.sh
./spring-boot-cleanarch-client-cli/build.sh
```
- Executar:
```shell
kubectl apply -f cleanarch.yml
```
- Testar ( com [httppie](https://httpie.io) ):
```shell
minikube service cleanarch-service
http POST <IP publicado pelo minikube>:30000/users username=username password=password email=email
```