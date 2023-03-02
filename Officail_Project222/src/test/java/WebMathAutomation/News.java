package WebMathAutomation;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class News {
	
	WebDriver driver ;
	Properties prop = new Properties();
  @Test
  public void news() throws InterruptedException {
	  
	  try {
	  
	  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
	  mathForEveryone.click();
	  
	  WebElement privacyPolicy = driver.findElement(By.xpath(prop.getProperty("privacyPolicy")));
	  privacyPolicy.click();
	  
	  Thread.sleep(3000);
	  
	  WebElement news = driver.findElement(By.xpath(prop.getProperty("news")));
	  news.click();
	  
	 
	  
	
	  //Verify that the news page is visible
	  
	  String actualTitle = prop.getProperty("actualTitle");
	  String expectedTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\NewsData.properties");
	  prop.load(input);
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  driver.get(prop.getProperty("url"));
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
