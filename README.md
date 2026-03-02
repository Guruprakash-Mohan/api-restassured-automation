# Booking API Test Automation

Automated API tests for the Restful Booker platform.

## Tools Used

- Java 17
- REST Assured
- Cucumber
- JUnit 5
- Maven

## Prerequisites

- Java 17+
- Maven 3.6+ **or** use the included Maven Wrapper (no Maven installation required)

## How to Run

**Using Maven (if installed):**
```bash
git clone https://github.com/Guruprakash-Mohan/api-restassured-automation.git
cd api-restassured-automation
mvn test
```

**Using Maven Wrapper (no Maven installation needed):**
```bash
git clone https://github.com/Guruprakash-Mohan/api-restassured-automation.git
cd api-restassured-automation

# Windows
mvnw.cmd test

# Mac/Linux
./mvnw test
```

## Run by Tag
```bash
mvn test -Dcucumber.filter.tags="@smoke"
mvn test -Dcucumber.filter.tags="@negative"
mvn test -Dcucumber.filter.tags="@security"
```

## Test Scenarios

**Smoke Tests**
- Create booking with valid data
- Get booking by ID
- Delete booking

**Security Tests**
- Get booking without authentication
- Delete booking without authentication

**Negative Tests**
- Create booking with short firstname and lastname
- Create booking with invalid dates
- Create booking with invalid email
- Create booking with short phone number

**Work In Progress**
- Update booking (marked @wip)

## Test Report

After running, HTML report is available at:
```
target/cucumber-reports/cucumber.html
```

## Notes

- Tests run against https://automationintesting.online
- Retry logic handles conflicts in the shared environment
- Maven Wrapper downloads Maven 3.9.9 automatically if not installed