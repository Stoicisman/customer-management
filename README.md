# Customer Management System

This project is a Spring Boot-based REST API for managing customer data. It includes functionality to create, read, update, and delete customer records, with security features implemented using Spring Security.

## Getting Started

These instructions will help you set up the project on your local machine for development and testing purposes.

### Prerequisites

You need to have the following installed on your machine:
- Java 17
- Maven 3.6+
- MySQL (or Docker for containerized MySQL)
- Git

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/customer-management.git
    cd customer-management
    ```

2. Set up MySQL database:
    - Create a database named `customer_management` in your MySQL instance.
    - Update your MySQL credentials in the `application.properties` file:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/customer_management
      spring.datasource.username=your_mysql_username
      spring.datasource.password=your_mysql_password
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      ```

3. Run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```

### Running the Tests

This project uses JUnit and Testcontainers for testing. The tests include both unit and integration tests.

To run the tests, execute the following command:
```bash
mvn test


API Endpoints
The following REST API endpoints are available:

GET /customers: Retrieve all customers.
GET /customers/{id}: Retrieve a customer by ID.
POST /customers: Create a new customer.
PUT /customers/{id}: Update an existing customer.
DELETE /customers/{id}: Delete a customer.



Security
Basic authentication is used to secure POST, PUT, and DELETE endpoints.
The default username and password for the API are admin and password.
GET requests do not require authentication


Technologies Used
Spring Boot
Spring Data JPA
Spring Security
MySQL
JUnit and Testcontainers
Maven
