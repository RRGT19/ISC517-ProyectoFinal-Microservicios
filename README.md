# Spring Boot - Estructura de microservicios

Este proyecto ha sido realizado utilizando Spring Boot con un estilo de microservicios.

## Tecnologías utilizadas
- Spring Boot
- Spring Boot Cloud Eureka
- Spring Boot Cloud Hystrix
- Spring Boot Cloud Zuul
- H2

## Servicios

| Nombre del servicio | URL en Spring Initializr                                                                                                                                                                                                                                                                                                          |
|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Usuarios            | https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.microservice&artifactId=users&name=users&description=Microservice%20of%20users&packageName=com.microservice.users&dependencies=web,data-jpa,h2,lombok,security                                 |
| Eventos             | https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.microservice&artifactId=events&name=events&description=Microservice%20of%20events&packageName=com.microservice.events&dependencies=web,data-jpa,h2,lombok,security                             |
| Notificaciones      | https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.microservice&artifactId=notifications&name=notifications&description=Microservice%20of%20notifications&packageName=com.microservice.notifications&dependencies=web,data-jpa,h2,lombok,security |
| Eureka Discovery    | https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.eureka&artifactId=discovery&name=discovery&description=Eureka%20Discovery%20Service&packageName=com.eureka.discovery&dependencies=cloud-eureka-server                                          |
| API Gateway         | https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.api&artifactId=gateway&name=gateway&description=API%20Gateway&packageName=com.api.gateway&dependencies=cloud-eureka,cloud-feign,data-rest,web,cloud-hystrix                                    |

| Nombre del servicio | Objetivo                                                                                       |
|---------------------|------------------------------------------------------------------------------------------------|
| Usuarios            | Encargado de llevar el registro y CRUD de la información de los usuarios.                      |
| Eventos             | Encargado de llevar el registro y CRUD de los eventos/servicios del negocio.                   |
| Notificaciones      | Encargado de enviar correos electrónicos.                                                      |
| Eureka Discovery    | Descubridor de servicio automático el cuál hace a cualquier microservicio nuevo disponible.    |
| API Gateway         | Sirve como el entry point de nuestro sistema/controladores para tener un solo punto de acceso. |