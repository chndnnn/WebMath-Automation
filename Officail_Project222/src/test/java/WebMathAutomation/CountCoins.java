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
import org.testng.annotations.AfterMethod;

public class CountCoins {
	
	WebDriver driver ;
	Properties prop = new Properties();
	
  @Test
  public void countCoins() {
	  
	  try {
	  
	  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
	  mathForEveryone.click();
	  
	  WebElement count = driver.findElement(By.xpath(prop.getProperty("count")));
	  count.click();
	  
	  WebElement quartar = driver.findElement(By.xpath(prop.getProperty("quartar")));
	  quartar.sendKeys(prop.getProperty("sendQuarter"));
	  
	  WebElement dimes = driver.findElement(By.xpath(prop.getProperty("dimes")));
	  dimes.sendKeys(prop.getProperty("sendDimes"));
	  
	  WebElement nickels = driver.findElement(By.xpath(prop.getProperty("nickels")));
	  nickels.sendKeys(prop.getProperty("sendNickels"));
	  
	  WebElement pennies = driver.findElement(By.xpath(prop.getProperty("pennies")));
	  pennies.sendKeys(prop.getProperty("sendPennies"));
	  
	  WebElement countIt = driver.findElement(By.xpath(prop.getProperty("countIt")));
	  countIt.click();
	  
	  // Verifying that the correct result is visible
	  
	  driver.switchTo().frame(prop.getProperty("iFrame"));
	  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
	  String resultText = result.getText();
	  if(resultText.contains(prop.getProperty("sendResultText"))) {
		  System.out.println("Sucessfully displayed correct result");
	  }else {
		  System.out.println("Unable to display correct result");
	  }
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("C:\\Users\\chndn\\eclipse-workspace6\\Officail_Project222\\src\\test\\resources\\Properties\\CountCoinsData.properties");
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
