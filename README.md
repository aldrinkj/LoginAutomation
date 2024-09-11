# LoginAutomation
This project automates the login functionality tests for the "Germany is Calling" web application using Selenium and TestNG.

## Test Execution Steps

1. Clone the repository.
2. Install [Maven](https://maven.apache.org/install.html) on your system.
3. Ensure you have the correct browser driver installed (e.g., [ChromeDriver](https://chromedriver.chromium.org/)).
4

## Assumptions

- The login page URL is `https://germanyiscalling.com/login`.
- Valid credentials for testing are:
- Email: `validuser@example.com`
- Password: `validpassword`
- The landing page URL after successful login is `https://germanyiscalling.com/dashboard`.
- Error message text for invalid login is `Invalid username or password.`

## Additional Information

- Additional test cases can be added, such as testing empty fields or handling special characters.
- The tests are designed to run on Chrome but can be modified to support other browsers by changing the WebDriver setup.
- Potential improvements include data-driven testing with different sets of credentials using TestNG’s `@DataProvider`.
