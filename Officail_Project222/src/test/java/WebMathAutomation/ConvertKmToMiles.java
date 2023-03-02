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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class ConvertKmToMiles {
	Properties prop = new Properties();
	WebDriver driver ;
  @Test
  public void convertKmtoMiles() throws InterruptedException {
	  
	  try {
		  

	  WebElement math = driver.findElement(By.xpath(prop.getProperty("math")));
	  Select drop = new Select(math);
	  drop.selectByValue(prop.getProperty("value"));
	  
	  WebElement kilometerInput =driver.findElement(By.xpath(prop.getProperty("kilometerInput")));
	  kilometerInput.sendKeys(prop.getProperty("sendKilometerInput"));
	  
	  WebElement convert =driver.findElement(By.xpath(prop.getProperty("convert")));
	  convert.click();
	  
	  //verifying the result
	  driver.switchTo().frame(prop.getProperty("frameId"));
	  
	  
	  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
	  String resultText = result.getText();
	  if(resultText.contains(prop.getProperty("sendResultText"))) {
		  System.out.println("The correct result is visible");
	  }
	  else{
		  System.out.println("Result is not vivible");
	  }
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	 
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\CovertKmToMiles.properties");
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
