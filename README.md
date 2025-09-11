# Warehouse Application

This project is a small Java Spring REST API. The service features basic functionality of REST API with CRUD operations on Good and Category entities.

## Requirements

- Java 21
- Maven

### Setup Instructions

1.  Clone the repository:

    ```bash
    git clone https://github.com/d-stoianov/warehouse-application.git
    cd warehouse-application
    ```

2.  Install dependencies:

    ```
    mvn package
    ```

4.  Start the development server:

    ```
    mvn spring-boot:run
    ```

5.  Navigate to API's docs on `http://localhost:8080/docs`

App uses H2 for in-memory database, you can access the console by going to `http://localhost:8080/h2-console`
