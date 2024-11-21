# Ecommerce Assignment

## Demo Video Link
Part 1: [https://drive.google.com/file/d/1h5kBud3UXMalPAtwr30qfGoaG0HC21sH/view](https://drive.google.com/file/d/11KFk0udYltmRigNX3BuaXE-5NlFhaXw-/view?usp=drive_link)

Part 2: [ https://drive.google.com/file/d/1k5D2hdsik0lwqaAfl4EOVjPlnDVJDRZS/view](https://drive.google.com/file/d/1k5D2hdsik0lwqaAfl4EOVjPlnDVJDRZS/view?usp=drive_link)


## Tech stack used


<img class="icon" height="100" src="https://github.com/anantha-krish/lingo-tutor-backend/assets/22259160/2902a21f-656a-4ec8-b35c-16ef34cd8efa" /> &nbsp;  &nbsp; 
<img height="100" src="https://github.com/anantha-krish/lingo-tutor-backend/assets/22259160/ab6c2f99-20b5-4b27-8299-c10f48a2304c" />
<img height="100" src="https://github.com/anantha-krish/lingo-tutor-backend/assets/22259160/2faf4a8f-bc47-454e-a6f5-c0121005c05c" />
<img height="100" src="https://github.com/anantha-krish/lingo-tutor-backend/assets/22259160/9523db48-cd99-420b-a534-99af91c7f4c1" />

<ul>
  <li><b>Backend</b>: Java 21, Spring Boot 3, Gradle, Spring Cloud Gateway, Spring Cloud Netflix  Eureka Server, Spring Security, JWT, Spring Web, Spring Data JPA (Hibernate),  OpenFeign </li>
  <li><b>Database</b>: 4 Free-tier Postgres Databases hosted in Cloud Platform (https://neon.tech/)</li>
</ul>

## How to run app ?

1. Prerequisite: System should have `Java 21` and `Gradle 8.7` installed.

1. Checkout the project.
   
3. Execute `gradle --refresh-dependencies` on each gradle project folders to download the dependancies.

4. Execute `gradle bootrun` to run the project. 
   
Further refernce: https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-running-your-application.html

## Architecture Design

![Scalable Assignment drawio](https://github.com/user-attachments/assets/d6d05e86-a36a-44c1-9fe3-fa6e512edfe8)



| Service   | Port |
|-----------|------|
| Gateway   | 8765 |
| Eureka    | 8761 |
| Products     | 8082 |
| Orders | 8084 |
| Users | 8083 |
| Shipping | 8085 |

Swagger URL `http://localhost:{port}/swagger-ui/index.html`

## API Routes
- http://localhost:8765/orders
- http://localhost:8765/products
- http://localhost:8765/shipments
- http://localhost:8765/users

