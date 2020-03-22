import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_Excel {
WebDriver driver;
 @BeforeMethod
 public void setUp(){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(" https://qa01-tekarch-accmanager.web.app/");
	
 }
 @DataProvider
 public Object[][] credential()
 {
	 
	Object data [][]= getExcelData.getCredentialData("Sheet2");
	return data;

 }
	 @Test(dataProvider = "credential")
	 public void login(String username,String password) 
	 {
		  driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		  WebElement Login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			Login.click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
	 }
	 @AfterMethod
	 public void complete() 
	 {
		driver.quit() ;
	 }
}
