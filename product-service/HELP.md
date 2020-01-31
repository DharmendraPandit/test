# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/gradle-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### H2 Database Dashboard url:
* http://localhost:8080/products/h2
* CREATE TABLE PRODUCT_DETAILS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(250) NOT NULL,
  brand VARCHAR(250) NOT NULL,
  color VARCHAR(250) NOT NULL,
  price DOUBLE NOT NULL,
  size INT NOT NULL,
  no_of_product INT NOT NULL,
  seller VARCHAR(250) NOT NULL,
  region VARCHAR(250) DEFAULT NULL,
  description VARCHAR(250) DEFAULT NULL
);

* INSERT INTO PRODUCT_DETAILS (category, brand, color, price, size, no_of_product, seller, region, description) VALUES
  ('Shirts', 'Puma', 'Red', 110, 40, 11, 'Abc', 'Asia', null),
  ('Shirts', 'Puma', 'Red', 110, 40, 11, 'Abc', 'Asia', null),

  ('Shirts', 'Nike', 'Black', 110, 40, 11, 'Abc', 'Asia', null),

  ('Pants', 'Puma', 'Red', 110, 40, 11, 'Abc', 'Asia', null),
  ('Caps', 'Puma', 'Black', 110, 40, 11, 'Abc', 'Asia', null),

  ('Shirts', 'Adidas', 'Blue', 100, 42, 99, 'Abc', 'Asia', null),
  ('Shirts', 'Adidas', 'Blue', 100, 42, 23, 'Abc', 'Asia', null),
  ('Pants', 'Adidas', 'Blue', 100, 42, 44, 'Abc', 'Asia', null),
  ('Caps', 'Adidas', 'Blue', 100, 42, 24, 'Abc', 'Asia', null),

  ('Shirts', 'Reebok', 'Pink', 120, 44, 56, 'Abc', 'Asia', null),
  ('Shirts', 'Reebok', 'Pink', 120, 44, 78, 'Abc', 'Asia', null),

  ('Shirts', 'Test', 'Red', 110, 40, 11, 'Abc', 'Asia', null),
  ('Shirts', 'Nike', 'Red', 110, 40, 11, 'Abc', 'Asia', null),

  ('Pants', 'Reebok', 'Pink', 120, 44, 121, 'Abc', 'Asia', null),
  ('Caps', 'Reebok', 'Pink', 120, 44, 45, 'Abc', 'Asia', null),
  ('Shirts', 'Test', 'Pink', 110, 40, 11, 'Abc', 'Asia', null);

### Service Details:
* POST: http://localhost:8080/products/search
* Sample payload:
{
	"category": "Shirts",
	"region": "asia",
	"groupBy":"color"
}

* category could be, Shirts/Pants/Caps
* brand could be, Puma/Nike/Adidas/Reebok
* groupBy could be, brand/price/color/size

### Build Steps:
* ./gradlew build
* ./gradlew clean bootRun
