package test1;
 
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class TC009_TestNG4_Properties {
 
    WebDriver driver;
    String projectpath;
 
    @Test
    public void loginTest() throws
    IOException {
 
        LoginPom obj = new LoginPom(driver);
 
        obj.enterusername("Admin");
        obj.enterpassword("admin123");
        obj.clicklogin();
    }
 
    @BeforeMethod
    public void beforeMethod() throws IOException {
 
        Properties prob = new Properties();
 
        projectpath = System.getProperty("user.dir");
 
        FileInputStream fis =
                new FileInputStream(projectpath + "\\data.properties");
 
        prob.load(fis);
 
        String url = prob.getProperty("url");
 
        WebDriverManager.edgedriver().setup();
 
        driver = new EdgeDriver();
 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        driver.get(url);
    }
 
    @AfterMethod
    public void afterMethod() {
 
        driver.quit();
    }
}
 