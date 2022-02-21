Selinum_Automation

# Automation Test Exam
Description on the exam/brief.

## Note on deployment
Chose to just use the JVM to run tests on any OS as setting up docker for one specific browser would eventually be deprecated for a multi-browser solution such as BrowserStack.


## To run tests
Install Java and verify JAVA_HOME variable is set
Download Maven from (https://maven.apache.org/) and verify the contained "bin" folder is in your user or system PATH variable
Chrome version 98.0 is currently used. For later or other versions of chrome the chromedriver.exe must be replaced with the matching version from chromium.org (https://chromedriver.chromium.org/downloads)
On Windows the tests can be launched by cmd with "mvn test" or running the bat script "Launch tests.bat"

Test report will be generated using Maven Surefire.

## Breakdown of components
TestPlan.java (The test suite)
DriverUtils.java (Helper functions for the Chrome driver)
AccountUtils.java (Helper functions for user accounts)
Models (Page object models for each page of the system under test - SUT)

## Test cases run

Submit a valid login
The Test logs in using valid credentials and validates that the page has successfully redirected the user to the account management page.

Submit an invalid email
The test attempts to login using an invalid email address and validates that the page returns an "Invalid email address." error.

Submit an invalid password
The test attempts to login using an invalid password and validates that the page returns an "Authentication failed." error.

Purchase a Blouse
The test logs the user in with valid credentials and runs through the full process of purchasing a blouse using pay by wire. It then validates the confirmation page and checks that the site has quoted the correct price total.
