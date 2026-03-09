@booking
Feature: Booking API

  # ─── Create Booking ───────────────────────────────────────────────────────────

  @smoke @create
  Scenario: Successfully create a booking with valid data
    When I create a booking with valid details
    Then the response status should be 201
    And the response should contain a booking id
    And the response should contain the booking details
    And the response should match the booking schema

  @smoke @create @datatable
  Scenario: Successfully create a booking using data table
    When I create a booking with the following details:
      | firstname | John          |
      | lastname  | Doe           |
      | email     | john@test.com |
      | phone     | 07123456789   |
    Then the response status should be 201
    And the response should contain a booking id
    And the response should contain the booking details
    And the response should match the booking schema


  # ─── Get Booking ─────────────────────────────────────────────────────────────

  @smoke @read
  Scenario: Retrieve a booking by ID with valid authentication
    Given a valid booking exists
    When I retrieve the booking with a valid token
    Then the response status should be 200
    And the response should contain field "firstname" with value "John"
    And the response should contain field "lastname" with value "Doe"

  # ─── Update Booking ──────────────────────────────────────────────────────────

  @wip @update
  Scenario: Update a booking with valid authentication
    Given a valid booking exists
    When I update the booking with valid details
    Then the response status should be 200
    And the response should contain field "firstname" with value "UpdatedName"
    And the response should contain field "lastname" with value "UpdatedLastname"

  # ─── Delete Booking ──────────────────────────────────────────────────────────

  @smoke @delete
  Scenario: Delete a booking with valid authentication
    Given a valid booking exists
    When I delete the booking with a valid token
    Then the response status should be 200

  # ─── Security ────────────────────────────────────────────────────────────────

  @security
  Scenario: Retrieve a booking without authentication
    Given a valid booking exists
    When I retrieve the booking without a token
    Then the response status should be 401

  @security
  Scenario: Delete a booking without authentication
    Given a valid booking exists
    When I delete the booking without a token
    Then the response status should be 401

  # ─── Negative Tests ──────────────────────────────────────────────────────────

  @create @negative
  Scenario: Create a booking with short firstname and lastname
    When I create a booking with firstname "Jo" and lastname "Do"
    Then the response status should be 400
    And the response should contain error message

  @create @negative
  Scenario: Create a booking with invalid dates
    When I create a booking with checkin "2026-00-10" and checkout "2026-00-01"
    Then the response status should be 400
    And the response should contain error message

  @create @negative
  Scenario Outline: Create a booking with an invalid email returns 400
    When I create a booking with an invalid email "<email>"
    Then the response status should be 400
    And the response should contain error message

    Examples:
      | email       |
      | invalid.com |
      | @test.com   |
      | plaintext   |
      | john@       |

  @create @negative
  Scenario: Create a booking with a phone number that is too short returns 400
    When I create a booking with a phone number that is too short "9125"
    Then the response status should be 400
    And the response should contain error message
