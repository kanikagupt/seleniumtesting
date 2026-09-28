package test1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Lab9 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Starting browser", true);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Reporter.log("OrangeHRM application opened", true);
    }
    @Test(dataProvider = "dp")
    public void loginTest(String username, String password) {
        Reporter.log("Entering username: " + username, true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Username']")
        )).sendKeys(username);
        Reporter.log("Entering password", true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Password']")
        )).sendKeys(password);
        Reporter.log("Clicking Login button", true);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']")
        )).click();
        Reporter.log("Checking dashboard", true);
        boolean dashboardDisplayed = wait.until(
                ExpectedConditions.urlContains("/dashboard")
        );
        Assert.assertTrue(
                dashboardDisplayed,
                "Dashboard was not opened after login"
        );
        Reporter.log("Login verification successful - Dashboard opened", true);
    }
    @DataProvider(name = "dp")
    public Object[][] dp() {
        return new Object[][] {
            {"Admin", "admin123"}
        };
    }
    @AfterMethod
    public void afterMethod() {
        Reporter.log("Closing browser", true);
        if (driver != null) {
            driver.quit();
        }
    }
}