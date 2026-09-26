package test1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab7 {
	
	 
	    public static void main(String[] args) throws InterruptedException {
	 
	        WebDriverManager.chromedriver().setup();
	 
	        WebDriver browser = new ChromeDriver();
	 
	        browser.manage().window().maximize();
	 
	        
	        browser.get("https://letcode.in/alert");
	 
	 
	        
	        browser.findElement(By.id("accept")).click();
	 
	        Thread.sleep(2000);
	 
	        Alert acceptAlert = browser.switchTo().alert();
	 
	        System.out.println("Accept Alert Message: " + acceptAlert.getText());
	 
	        acceptAlert.accept();
	 
	 
	        
	        browser.findElement(By.id("confirm")).click();
	 
	        Thread.sleep(2000);
	 
	        Alert confirmationAlert = browser.switchTo().alert();
	 
	        System.out.println("Confirmation Alert Message: "
	                + confirmationAlert.getText());
	 
	        confirmationAlert.dismiss();
	 
	 
	       
	        browser.findElement(By.id("prompt")).click();
	 
	        Thread.sleep(2000);
	 
	        Alert inputAlert = browser.switchTo().alert();
	 
	        System.out.println("Input Alert Message: " + inputAlert.getText());
	 
	        inputAlert.sendKeys("Hi");
	 
	        inputAlert.accept();
	 
	 
	        System.out.println("Completed");
	 
	        browser.quit();
	    }
	}
	 