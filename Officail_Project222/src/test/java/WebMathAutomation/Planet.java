package WebMathAutomation;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Planet {
	
	WebDriver driver ;
	Properties prop = new Properties();
	
  @Test
  public void planet() {
	  
	  try {
		  
		  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
		  mathForEveryone.click();
		  
		  WebElement weightOnAnotherPlanet = driver.findElement(By.xpath(prop.getProperty("weightOnAnotherPlanet")));
		  weightOnAnotherPlanet.click();
		  
		  WebElement myWeight = driver.findElement(By.xpath(prop.getProperty("myWeight")));
		  myWeight.sendKeys(prop.getProperty("sendMyWeight"));
		  
		  WebElement planet = driver.findElement(By.xpath(prop.getProperty("planet")));
		  Select drop = new Select(planet);
		  drop.selectByVisibleText(prop.getProperty("dropValue"));
		  
		  WebElement convert = driver.findElement(By.xpath(prop.getProperty("convert")));
		  convert.click();
		  
		  //Verify that the result is correct
		  driver.switchTo().frame(prop.getProperty("iFrame"));
		  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
		  String resultText = result.getText();
		  if(resultText.contains(prop.getProperty("sendResultText"))) {
			  System.out.println("Sucessfully displayed correct result");
		  }
		  else {
			  System.out.println("Result are not correct");
		  }
		  
	  }catch(Exception e) {
		  
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  

	  try {
		  
		  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\PlanetData.properties");
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
