# CIB DIGITAL TECH – QA AUTOMATION ASSESSMENT

Open source UI Automation Framework.
`https://www.way2automation.com/angularjs-protractor/webtables/`

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Tests](#tests)
- [Reporting](#reporting)

## Features

1. **Selenium Integration:**
    - Built with Selenium WebDriver for powerful and scalable web automation.

2. **BDD Support with Cucumber:**
    - Follows BDD principles with Cucumber, allowing natural language test scenarios.

3. **TestNG Integration:**
    - Integrates TestNG for flexible test management, parallel execution, and reporting.

4. **Allure Reporting:**
    - Generates detailed and visually appealing Allure reports for better test insights.

5. **Extent Reporting:**
    - Generates detailed and visually appealing Extent html emailable reports for better test insights.

6. **Page Object Model (POM):**
    - Implements the Page Object Model pattern for improved code organization and maintainability.

7. **Parameterization and Configuration:**
    - Easily parameterize tests and configure the framework to suit your needs.

8. **Parallel Execution:**
    - Run tests in parallel to reduce execution time and increase efficiency.

9. **Easy Setup and Configuration:**
   - Quick and simple setup with clear configuration options.


## Prerequisites

- Java JDK (version 18)
- Maven (version 3.1.0)
- Cucumber (version 7.4.1)
- TestNG (7.7.1)
- allure-cucumber7-jvm (2.19.0)
- Extent report (5.0.4)

## Installation

1. Clone the repository:

   ```bash
   https://github.com/JTailor87/ABSA_web
2. Run below commands.

   ```shell
   cd your-testing-framework
   mvn clean install

3. Install Allure Report
   ```shell
   npm install allure-commandline --save-dev

## Tests

- Open `src/test/java/runner/testRunner.java`
- Run `testRunner` class
- If you want to run test parallely by opening browser instance at a time, change the `@DataProvider(parallel = false)` to `true` and run the `testRunner` class.

## Reporting

- After running the tests successfully, open terminal window in your IDE.
- Run below command.
   ```shell
  allure serve target/allure-results
- Cucumber html report will be found here `target/cucumber-reports.html`
- Extent report wil be found here `target/SparkReport 29-Nov-23 10-26-28/Reports/Spark.html`
  <span style="color:red; font-weight:bold">NOTE:</span> <span style="color:yellow">The date in the path will change. Always do mvn clean and then run the tests.</span>