package test1;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class LoginPom {
 
    WebDriver driver;
    WebDriverWait wait;
 
    By uname;
    By pword;
    By loginbutton;
 
    public LoginPom(WebDriver driver2) throws IOException {
 
        this.driver = driver2;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 
        String projectpath = System.getProperty("user.dir");
 
        Properties prob = new Properties();
 
        FileInputStream fis =
                new FileInputStream(projectpath + "\\data.properties");
 
        prob.load(fis);
 
        String usernameLocator = prob.getProperty("username");
        String passwordLocator = prob.getProperty("password");
        String loginButtonLocator = prob.getProperty("login_button");
 
        uname = By.name(
                usernameLocator.substring(usernameLocator.indexOf("=") + 1)
        );
 
        pword = By.name(
                passwordLocator.substring(passwordLocator.indexOf("=") + 1)
        );
 
        loginbutton = By.xpath(
                loginButtonLocator.substring(loginButtonLocator.indexOf("=") + 1)
        );
 
        fis.close();
    }
 
    public void enterusername(String username) {
 
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(uname)
        ).sendKeys(username);
    }
 
    public void enterpassword(String password) {
 
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pword)
        ).sendKeys(password);
    }
 
    public void clicklogin() {
 
        wait.until(
                ExpectedConditions.elementToBeClickable(loginbutton)
        ).click();
    }
}
 