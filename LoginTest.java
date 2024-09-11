package AutomatedTestingofLoginScreen.AutomatedTestingofLoginScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver_win32>chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://app.germanyiscalling.com/common/login/"); //  login page URL
    }
    @Test
    public void testSuccessfulLogin() {
        // Locate and interact with the login elements
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-danger mt-3']"));

        // Input valid credentials
        emailField.sendKeys("rotodid213@coloruz.com");
        passwordField.sendKeys("#a2kj1080p");
        loginButton.click();

        // Assert the redirection to the landing page
        String expectedUrl = "https://app.germanyiscalling.com/common/login/"; // landing page
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the dashboard after login.");
    }
    @Test
    public void testUnsuccessfulLogin() {
        // Locate and interact with the login elements
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-danger mt-3']"));

        // Invalid credentials
        emailField.sendKeys("invalidemail.com");
        passwordField.sendKeys("dummy");
        loginButton.click();

        // Locate the error message and assert its presence
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message was not displayed after an unsuccessful login.");
        Assert.assertEquals(errorMessage.getText(), "Invalid username or password.", "Error message text is incorrect.");
    }
    @Test
    public void testEmptyFieldsLogin() {
        // Click login without entering any credentials
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        loginButton.click();

        // Assert that appropriate error messages are displayed for empty fields
        WebElement emailError = driver.findElement(By.id("emailError"));
        WebElement passwordError = driver.findElement(By.id("passwordError"));
        
        Assert.assertTrue(emailError.isDisplayed(), "Email field error message is not displayed.");
        Assert.assertTrue(passwordError.isDisplayed(), "Password field error message is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
