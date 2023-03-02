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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class VisitBack {
	WebDriver driver ;
	Properties prop = new Properties();
  @Test
  public void visitBack() {
	  
	  try {
	  
	  
	  WebElement math = driver.findElement(By.xpath(prop.getProperty("math")));
	  Select drop = new Select(math);
	  drop.selectByValue(prop.getProperty("value"));
	  
	  WebElement kilometerInput =driver.findElement(By.xpath(prop.getProperty("kilometerInput")));
	  kilometerInput.sendKeys(prop.getProperty("sendKilometerInput"));
	  
	  WebElement convert =driver.findElement(By.xpath(prop.getProperty("convert")));
	  convert.click();
	  
	  WebElement back = driver.findElement(By.xpath(prop.getProperty("back")));
	  back.click();
	  
	  //verifying Speed page is visited back
	  String expectedTitle = prop.getProperty("expectedTitle");
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(expectedTitle, actualTitle);
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\VisitBackData.properties");
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
