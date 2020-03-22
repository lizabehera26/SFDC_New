import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

  
  public class Test_Cases extends ReusableMethods1 
  {

	@BeforeTest
	public  void Initialize() 
	{
		InitializeDriver(); 
		CreateReport();
	}
	

	@Test
	public static void LoginToSalesforce() throws InterruptedException {
		//Thread.sleep(2000);
		logger = report.startTest("LoginToSalesForce");

		OpenUrl("https://login.salesforce.com");
		
		String expectedTitle="Login | Salesforce";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		WebElement Uname = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		EnterText(Uname, "liza@archtek.com", "Username");
		

		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		EnterText(pwd, "Aarvi121", "Password");
			
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();
		
		
	}
	
	//public static void UserMenu
	
	@Test
	public static void closeTest() 
	{
		CloseBrowser();	
		CloseReport();
	}
	
}
