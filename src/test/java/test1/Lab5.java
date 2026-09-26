package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab5 {
 
    public static void main(String[] args) {
 
        WebDriverManager.chromedriver().setup();
 
        WebDriver driver = new ChromeDriver();
 
        driver.get("https://tutorialsninja.com/demo/");
 
        String title = driver.getTitle();
 
        if (title.equals("Your Store")) {
            System.out.println("Title is matching");
        } else {
            System.out.println("Title is not matching");
        }
 
        driver.findElement(By.linkText("My Account")).click();
 
        driver.findElement(By.linkText("Register")).click();
 
        if (driver.findElement(By.xpath("//h1[text() = 'Register Account']")).isDisplayed()) {
            System.out.println("Register Account heading is displaying");
        } else {
            System.out.println("Register Account Heading is not displayed");
        }
 
        driver.findElement(By.xpath("//input[@type='submit']")).click();
 
        String warningMessage = driver.findElement(
                By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")
        ).getText();
 
        if (warningMessage.equals("Warning: You must agree to the Privacy Policy")) {
            System.out.println("Warning is displayed");
        } else {
            System.out.println("Warning message not displayed as expected");
        }
 
        driver.quit();
    }
}
 