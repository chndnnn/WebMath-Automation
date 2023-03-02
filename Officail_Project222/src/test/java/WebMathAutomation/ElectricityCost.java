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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ElectricityCost {
	
	WebDriver driver ;
	Properties prop = new Properties();
  @Test
  public void electricyCost(){
	  
	  try {
	  
	  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
	  mathForEveryone.click();
	  
	  
	  WebElement electricity = driver.findElement(By.xpath(prop.getProperty("electricity")));
	  electricity.click();
	  
	  WebElement device = driver.findElement(By.xpath(prop.getProperty("device")));
	  device.sendKeys(prop.getProperty("sendDevice"));
	  
	  WebElement hours = driver.findElement(By.xpath(prop.getProperty("hours")));
	  hours.sendKeys(prop.getProperty("sendHours"));
	  
	  WebElement costPerWatt = driver.findElement(By.xpath(prop.getProperty("costPerWatt")));
	  String value = costPerWatt.getAttribute("value");
	  if(value!=null) {
		  int len = value.length();
		  for(int i=0 ;i<len ;i++) {
			  costPerWatt.sendKeys(Keys.BACK_SPACE);
		  }
	  }
	  costPerWatt.sendKeys(prop.getProperty("sendCostPerWatt"));
	  
	  WebElement howMuch = driver.findElement(By.xpath(prop.getProperty("howMuch")));
	  howMuch.click();
	  
	  //Verify that the given value is correct
	  driver.switchTo().frame(prop.getProperty("iFrame"));
	  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
	  String resultText = result.getText();
	  if(resultText.contains(prop.getProperty("sendResultText"))) {
		  System.out.println("Successfully calculated electricity cost");
	  }
	  else {
		  System.out.println("Unable to calculated electricity cost");
	  }
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\ElectricityCostData.properties");
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
