package test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {
	
	    public static void main(String[] args) {
	 
	        
	        String email = "kanikagupta4245@gmail.com";
	        String password = "KNS@11";
	 
	        WebDriverManager.chromedriver().setup();
	 
	        WebDriver driver = new ChromeDriver();
	 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
	        try {
	 
	            driver.manage().window().maximize();
	 
	            
	            driver.get("https://tutorialsninja.com/demo/");
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("My Account"))).click();
	 
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Login"))).click();
	 
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.id("input-email"))).sendKeys(email);
	 
	            driver.findElement(By.id("input-password")).sendKeys(password);
	 
	            driver.findElement(By.cssSelector(
	                    "input[type='submit']")).click();
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Components"))).click();
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Monitors (2)"))).click();
	 
	 
	            
	            WebElement showDropdown = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.id("input-limit")));
	 
	            Select select = new Select(showDropdown);
	 
	            select.selectByVisibleText("25");
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Apple Cinema 30\""))).click();
	 
	 
	            
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//h1[contains(text(),'Apple Cinema 30')]")));
	 
	            System.out.println("Apple Cinema 30\" page opened");
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Specification"))).click();
	 
	 
	            
	            WebElement specification = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//h2[contains(text(),'Technical Specifications')]")));
	 
	            if (specification.isDisplayed()) {
	                System.out.println("Specification details are displayed");
	            }
	 
	 
	           
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.cssSelector(".btn > .fa-heart"))).click();
	 
	 
	            
	            WebElement wishlistMessage = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.cssSelector(".alert.alert-success")));
	 
	            if (wishlistMessage.getText().contains(
	                    "Apple Cinema 30\"")) {
	 
	                System.out.println("Apple Cinema 30\" added to Wish List");
	            }
	 
	 
	           
	            WebElement searchBox = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.name("search")));
	 
	            searchBox.clear();
	            searchBox.sendKeys("Mobile");
	 
	 
	            
	            driver.findElement(By.cssSelector(
	                    ".input-group-btn > .btn-lg")).click();
	 
	 
	            
	            WebElement descriptionCheckbox = wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            By.id("description")));
	 
	            if (!descriptionCheckbox.isSelected()) {
	                descriptionCheckbox.click();
	            }
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.id("button-search"))).click();
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("HTC Touch HD"))).click();
	 
	 
	            
	            WebElement quantity = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.id("input-quantity")));
	 
	            quantity.clear();
	            quantity.sendKeys("3");
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.id("button-cart"))).click();
	 
	 
	            
	            WebElement cartMessage = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.cssSelector(".alert.alert-success")));
	 
	            if (cartMessage.getText().contains(
	                    "HTC Touch HD")) {
	 
	                System.out.println("HTC Touch HD added to cart");
	            }
	 
	 
	           
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.cssSelector("a[href*='checkout/cart']"))).click();
	 
	 
	            
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//h1[contains(text(),'Shopping Cart')]")));
	 
	            System.out.println("Shopping Cart page opened");
	 
	 
	           
	            WebElement htcProduct = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//a[contains(text(),'HTC Touch HD')]")));
	 
	            if (htcProduct.isDisplayed()) {
	                System.out.println("HTC Touch HD is present in cart");
	            }
	 
	 
	           
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Checkout"))).click();
	 
	 
	           
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("My Account"))).click();
	 
	 
	            
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Logout"))).click();
	 
	 
	           
	            WebElement logoutHeading = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//h1[contains(text(),'Account Logout')]")));
	 
	            if (logoutHeading.isDisplayed()) {
	                System.out.println("Account Logout heading is displayed");
	            }
	 
	 
	           
	            wait.until(ExpectedConditions.elementToBeClickable(
	                    By.linkText("Continue"))).click();
	 
	            System.out.println("Test Executed Successfully");
	 
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	 
	        } finally {
	 
	            driver.quit();
	        }
	    }
	}
	 