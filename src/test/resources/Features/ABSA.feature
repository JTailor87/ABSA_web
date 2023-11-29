Feature: CIB DIGITAL TECH – QA AUTOMATION ASSESSMENT
  This demo feature file is about UI Automation of adding two users, one by one and at a time.

  @ABSAWeb_1 @ABSA
  Scenario Outline: Add user one by one
    Given User navigate to a URL "https://www.way2automation.com/angularjs-protractor/webtables/"
    When User open the url validate that you are on User List Table with page tile "Protractor practice website - WebTables"
    And User click the Add User button
    And User add the user with "<FirstName>" "<LastName>" "<UserName>" "<Password>" "<Customer>" "<Role>" "<Email>" "<Cell>"
    Then validate the user is added to the list "<FirstName>"
    Examples:
      | FirstName | LastName | UserName | Password | Customer | Role | Email | Cell |
      |FName1 | LName1 | User1 | Pass1 | CompanyAAA | Admin | admin@mail.com | 082555 |
      |FName2 | LName2 | User2 | Pass2 | CompanyBBB | Customer | customer@mail.com | 083444 |

  @ABSAWeb_2 @ABSA
  Scenario: Add both users at a time
    Given User navigate to a URL "https://www.way2automation.com/angularjs-protractor/webtables/"
    When User open the url validate that you are on User List Table with page tile "Protractor practice website - WebTables"
    And User click the Add User button
    And User add the users
      | FirstName | LastName | UserName | Password | Customer | Role | Email | Cell |
      |FName1 | LName1 | User1 | Pass1 | CompanyAAA | Admin | admin@mail.com | 082555 |
      |FName2 | LName2 | User2 | Pass2 | CompanyBBB | Customer | customer@mail.com | 083444 |
    Then validate the users are added to the list