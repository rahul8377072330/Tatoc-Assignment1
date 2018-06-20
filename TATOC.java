package assignment_1;
import java.util.*;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



import org.openqa.selenium.chrome.ChromeDriver;
class TATOC {
	public static void main(String args[]) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		boolean b= true;
		driver.switchTo().frame("main");
		
		String AA = driver.findElement(By.id("answer")).getAttribute("class");
		
		while(b){
			driver.findElement(By.linkText("Repaint Box 2")).click();
		       WebElement child = driver.findElement(By.id("child"));
		       driver.switchTo().frame(child);
		       String EA = driver.findElement(By.id("answer")).getAttribute("class");
		       driver.switchTo().parentFrame();
		       if(AA.equals(EA)) {
			b = false;
			}
		    }
		driver.findElement(By.linkText("Proceed")).click();
		driver.switchTo().defaultContent();
			        Actions act=new Actions(driver);
					WebElement dg=driver.findElement(By.id("dragbox"));
					WebElement dp=driver.findElement(By.id("dropbox"));
				        act.dragAndDrop(dg, dp).build().perform();
				        driver.findElement(By.linkText("Proceed")).click();
				        driver.findElement(By.linkText("Launch Popup Window")).click();
		                    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		                    driver.switchTo().window(tabs2.get(1));
		                    driver.findElement(By.cssSelector("#name")).sendKeys("hello world");
		                    driver.findElement(By.cssSelector("#submit")).click();
		                    driver.switchTo().window(tabs2.get(0));
		                    driver.findElement(By.linkText("Proceed")).click();
		                    driver.findElement(By.linkText("Generate Token")).click();
		                 String Token = driver.findElement(By.id("token")).getText();
		                 String[] splited = Token.split("\\s+"); 
		                 Cookie token1 = new Cookie("Token", splited[1]);
		                 driver.manage().addCookie(token1);
		                 driver.findElement(By.linkText("Proceed")).click();
		                 Thread.sleep(1000);
		                 
		                 driver.close();	
		
	}
}