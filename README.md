# HngProject-1
## About HNG

This project was developed as part of the HNG Internship program. For more information about hiring talented
Java developers like myself, please visit [HNG Java Developers](https://hng.tech/hire/java-developers).

## Number Classification API

A RESTful API that analyzes numbers and returns their mathematical properties along with interesting facts.

## Features

- Prime number detection
- Perfect number verification
- Armstrong number identification
- Digit sum calculation
- Number properties (odd/even)
- Integration with Numbers API for fun facts
- CORS support
- Error handling

## Tech Stack

- Java 17
- Spring Boot
- Spring WebFlux (WebClient)
- Maven

## API Specification

### Endpoint

```
GET /api/classify-number?number={number}
```

### Success Response (200 OK)

```json
{
    "number": 371,
    "is_prime": false,
    "is_perfect": false,
    "properties": ["armstrong", "odd"],
    "digit_sum": 11,
    "fun_fact": "371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371"
}
```

### Error Response (400 Bad Request)

```json
{
    "number": "{alphabet}",
    "error": true
}
```

## Setup & Installation

1. Clone the repository:
```bash
git clone [your-repo-url]
```

2. Navigate to project directory:
```bash
cd [project-directory]
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`


## API Usage Examples

1. Get properties of number 23:
```bash
curl http://localhost:8080/api/classify-number?number=23
```

2. Invalid input:
```bash
curl http://localhost:8080/api/classify-number?number=abc
```

## Error Handling

- Invalid input types return 400 Bad Request
- Number format exceptions are handled automatically
- Cross-origin requests are properly managed through CORS configuration


