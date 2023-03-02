package WebMathAutomation;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class SalesPrice {
	
	WebDriver driver ;
	Properties prop = new Properties();
	
  @Test
  public void salesPrice() {
	  
	  try {
	  
	  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
	  mathForEveryone.click();
	  
	  WebElement sales = driver.findElement(By.xpath(prop.getProperty("sales")));
	  sales.click();
	  
	  WebElement value = driver.findElement(By.xpath(prop.getProperty("value")));
	  value.sendKeys(prop.getProperty("sendValue"));
	  
	  WebElement percent = driver.findElement(By.xpath(prop.getProperty("percent")));
	  percent.sendKeys(prop.getProperty("sendPercent"));
	  
	  WebElement figureCost = driver.findElement(By.xpath(prop.getProperty("figureCost")));
	  figureCost.click();
	  
	  driver.switchTo().frame(prop.getProperty("iFrame"));
	  
	  //Verifying that the correct result is visible
	  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
	  String resultText = result.getText();
	  if(resultText.contains(prop.getProperty("sendResultText"))) {
		  System.out.println("Correct result is displayed");
	  }
	  else {
		  System.out.println("Correct result is not displayed");
	  }
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\SalesPriceData.properties");
	  prop.load(input);
	  WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
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
