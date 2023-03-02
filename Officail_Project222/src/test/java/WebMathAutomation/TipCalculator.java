package WebMathAutomation;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TipCalculator {
	
	WebDriver driver;
	Properties prop = new Properties();
	
  @Test
  public void tipCalculator() throws InterruptedException {
	  
	  try {
	  
	  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
	  mathForEveryone.click();
	  
	  WebElement tip = driver.findElement(By.xpath(prop.getProperty("tip")));
	  tip.click();
	  
	  WebElement percent = driver.findElement(By.xpath(prop.getProperty("percent")));
	  String value = percent.getAttribute("value");
	  if(value!=null) {
		  int len = value.length();
		  for(int i=0 ;i<len;i++) {
			  percent.sendKeys(Keys.BACK_SPACE);
		  }
	  }
	  percent.sendKeys("10");
	  
	  WebElement cost = driver.findElement(By.xpath(prop.getProperty("cost")));
	  cost.sendKeys(prop.getProperty("sendCost"));
	  
	  WebElement figureTip = driver.findElement(By.xpath(prop.getProperty("figureTip")));
	  figureTip.click();
	  
	  
	  //Verifying the result
	  driver.switchTo().frame(prop.getProperty("iFrame"));
	  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
	  String resultText = result.getText();
	  if(resultText.contains(prop.getProperty("sendText"))) {
		  System.out.println("Correct answer is visible");
	  }else {
		  System.out.println("Correct answer is not visible");
	  }
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\TipCalculatorData.properties");
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
