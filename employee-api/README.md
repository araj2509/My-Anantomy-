<<<<<<< HEAD
# Employee API – Swagger + Bean Validation (Spring Boot)

A beginner-friendly Spring Boot REST API demonstrating **Swagger UI (Springdoc OpenAPI)** and **Java Bean Validation**.

> Learning example: data is not saved to a database; `POST /employees` validates and echoes the employee back.

## Endpoints
| Method | Path | Description |
| --- | --- | --- |
| GET | `/employees` | Returns two sample employees (HTTP 200) |
| POST | `/employees` | Validates and echoes an employee (201 on success, 400 on invalid data) |

## Validation rules
- `name` – `@NotBlank`
- `email` – `@NotBlank` + `@Email`
- `age` – `@Min(18)`

## Requirements
- JDK 17+
- Maven 3.9+ (or open the project in IntelliJ / Eclipse / VS Code)

## Run
```bash
mvn spring-boot:run
```
Then open:
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## Test
```bash
mvn test
```

## Sample requests
Valid (201):
```json
{ "name": "Rahul", "email": "rahul@example.com", "age": 25 }
```
Invalid (400):
```json
{ "name": "   ", "email": "wrong-email", "age": 15 }
```

## Practice exercises
1. Add `@Size(min = 2)` to `name`.
2. Add a required `department` field.
3. Change the minimum age to 21 and test 20 and 21.
=======
# My-Anantomy-
>>>>>>> origin/main
