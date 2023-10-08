# Test API mobile.de

This project is an example of testing the mobile.de API using the [REST Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured) framework with [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api).

## Dependencies

To start this project you will need:

- [Java](https://www.java.com/)
- [Maven](https://maven.apache.org/)
- [REST Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [Apache HTTPClient](https://hc.apache.org/httpcomponents-client-5.2.x/) (Only for Statuse Code)
- [JUnit Jupiter API](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)

## Description of tests

### Task 1
Checking  GET request. Open Home page. Check Status Code 200.

### Task 2
Checking POST request. Add to basket. Check Status Code 201 and response for presence selected car id.

### Task 3
Checking POST request. Registration with existing email. Check Status Code 400 and  all fields for matching values.

### Task 4
Checking POST request. Registration without email. Check Status Code 400 and all fields for matching values.

### Task 5
Checking POST request. Registration without password. Check Status Code 400 and all fields for matching values.