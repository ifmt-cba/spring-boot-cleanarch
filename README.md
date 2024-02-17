<h1 align="center">
  Spring Boot Clean Architecture
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Youtube&message=@jppreti&color=8257E5&labelColor=000000" alt="@jppreti" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Demo&color=8257E5&labelColor=000000" alt="Demo" />
</p>

Demo para ilustrar como implementar Clean Architecture utilizando Spring Boot.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
- [H2](https://www.h2database.com)

## Como Executar

- Clonar repositório git:
```
git clone https://github.com/ifmt-cba/spring-boot-cleanarch.git
```
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar ./target/spring-boot-cleanarch-v1.0.jar
```
- Testar ( com [httppie](https://httpie.io) ):
```
http POST :8080/users username=username password=password email=email
```