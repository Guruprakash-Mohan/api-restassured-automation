# Booking API Test Automation

Automated API tests for the Restful Booker platform.

## Tools Used

- Java 17
- REST Assured
- Cucumber
- JUnit 5
- Maven

## How to Run
```bash
git clone https://github.com/Guruprakash-Mohan/api-restassured-automation.git
cd api-restassured-automation
mvn test
```

## Run by tag
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
target/cucumber-reports/cucumber.html

## Notes

- Tests run against https://automationintesting.online
- Retry logic handles conflicts in the shared environment