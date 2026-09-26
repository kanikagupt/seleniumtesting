package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		WebElement search = driver.findElement(By.id("ti6dpd"));
		
		search.sendKeys("Testing Methods");
		
		search.submit();
		
		String title ;
		
		title = driver.getTitle();
		
		System.out.println("Title of the page : " + title);

	}

}
