package Selenium_Screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


 public class ExtentReport_Scrnshot {
 public WebDriver driver;
 public ExtentReports extent;
 public ExtentTest logger;
 
 
 @BeforeTest
 public void setReport() 
 {
	 extent = new ExtentReports(System.getProperty("C:\\SFDC_New\\TestNG_Project")+"/test-output/ExtentReport.html",true);
	 extent.addSystemInfo("Host Name","SANYO-PC");
	 extent.addSystemInfo("User name","SANYO");
	 extent.addSystemInfo("Environment","QA");
	 
 }
 @AfterTest
 public void endReport() 
 {
	 extent.flush();
	 extent.close();
 }
 
 public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException 
 {
   String dateName = new SimpleDateFormat("yyyyMMddhhmmss")	.format(new Date()); 
   TakesScreenshot ts = (TakesScreenshot)driver;
   File source = ts.getScreenshotAs(OutputType.FILE);
   String destination = System.getProperty("C:\\SFDC_New\\\\TestNG_Project")+"/FailedTestscreenshot/" + screenshotName + dateName + ".png";
   File finalDestination = new File(destination);
   FileUtils.copyFile(source ,finalDestination); 
   return destination;
 }
	
 @BeforeMethod(alwaysRun=true)
 public void setUp()
   { 
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get(" https://qa01-tekarch-accmanager.web.app/");
	
   }
 

 @Test
 public void TitleTest()
	{
	 
	 logger = extent.startTest("TitleTest");
	 String title = driver.getTitle();
	 System.out.println(title);
     Assert.assertEquals(title, "Apitesting");
    }
 
 
 @Test
 public void Login() {
	 logger = extent.startTest("Login");
	WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
	username.sendKeys("swagatika@ta.com");
	System.out.println("This is user name box");
	WebElement pwd = driver.findElement(By.xpath("//input[@type='password']"));
	pwd.sendKeys("swagatika");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebElement Login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	Login.click(); 
	Assert.assertEquals("Apitesting", "home");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	
 }
 
 @AfterMethod(alwaysRun=true)
 public void complete(ITestResult result) throws IOException {
	 if(result.getStatus()==ITestResult.FAILURE) 
	 {
	 logger.log(LogStatus.FAIL, "TEST CASE FAILED IS" +result.getName());
	 logger.log(LogStatus.FAIL, "TEST CASE FAILED IS" +result.getThrowable());
     
	 String screenshotPath = ExtentReport_Scrnshot.getScreenshot(driver, result.getName());
	 logger.log(LogStatus.FAIL,logger.addScreenCapture(screenshotPath));
     //logger.log(LogStatus.FAIL,logger.addScreencast(screenshotPath));
     
}
	 else if (result.getStatus()==ITestResult.SKIP) 
	 {
		 logger.log(LogStatus.SKIP,"Test case SKIPPED is" +result.getName());
	 }
	 else if(result.getStatus()==ITestResult.SUCCESS) 
	 {
		logger.log(LogStatus.PASS, "Test case passed is"+ result.getName()); 
	 }
	 
	 extent.endTest(logger);
	 driver.quit();
}
 }
