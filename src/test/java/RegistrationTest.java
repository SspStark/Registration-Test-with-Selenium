import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTest{
    public static void main(String[] args){

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\sspto\\Downloads1\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

        // Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open the NxtTrendz registration page
        driver.get("https://rahulnxttrends.ccbp.tech/");

        // Find the username input element
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("rahul");

        // Find the email input element
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("rahul@example.com");
        // Find the password input element
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("rahul@2021");

        // Find the male radio button
        WebElement genderField = driver.findElement(By.id("male"));
        genderField.click();

        // Find the country dropdown element
        WebElement countryDropdown = driver.findElement(By.id("country"));

        // we can also use tagName()
        //WebElement countryDropdown = driver.findElement(By.tagName("select"));
        Select countrySelect = new Select(countryDropdown);

        // Select an option by visible text, we can also use selectByValue() and selectByIndex()
        // based on requirements
        countrySelect.selectByVisibleText("India");

        // Select the checkbox
        WebElement termsAndConditions = driver.findElement(By.id("terms"));
        termsAndConditions.click();

        // Submit the registration form
        WebElement registerButton = driver.findElement(By.id("submitBtn") );
        registerButton.submit();

        // Navigate to Login Page
        WebElement loginPageEl = driver.findElement(By.linkText("Log in"));

        // we can also use partialLinkText()
        // WebElement loginPageEl = driver.findElement(By.partialLinkText("Log"));
        loginPageEl.click();

        // Define the expected URL
        String loginPageUrl = "https://rahulnxttrendz.ccbp.tech/login";

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Verify the successful navigation

        if(currentUrl.equals(loginPageUrl)){
            System.out.println("Navigated to Login Page");
        }else{
            System.out.println("Failed to open Login Page");
        }

        driver.quit();
    }
}