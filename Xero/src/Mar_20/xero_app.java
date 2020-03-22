package Mar_20;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import junit.framework.Assert;

public class xero_app extends Reusable_xero {
	
    @BeforeMethod
    @Test
    public static void startup() throws Exception {
       CreateReport();
  	   DriverInitialization("chrome");
  	   OpenUrl("https://www.xero.com/us/");
  	   logger = report.startTest("startup");
  	   String actualTitle = driver.getTitle();
  	   String expectedTitle="https://www.xero.com/us/";
  	 
  	   if(actualTitle.equalsIgnoreCase(expectedTitle))
  	   System.out.println("Title Matched,Xero application page is displayed");
  	   else
  	   System.out.println("Title didn't match,Xero application page is not displayed");
  	   
    	
    	
    }
	@Test
	public static void TC1_login() throws Exception  {
		logger = report.startTest("TC1_login");

	   WebElement UN = driver.findElement(By.id("email"));
	   VisibleSelected(UN,"UserName");
	   EnterText(UN,"lizabehera26@@gmail.com","UserName");
	   
	   WebElement PWD = driver.findElement(By.id("password"));
	   VisibleSelected(PWD,"Password");
	   EnterText(PWD,"jaan121$$","Password");
	   
	   WebElement Login = driver.findElement(By.id("logger = report.startTest("));
	   Click(Login,"submitbtn");
	   String actualTitle1 = driver.getTitle();
	   String expectedTitle1 ="https://go.xero.com/Dashboard/";
	   
	   if(actualTitle1.equalsIgnoreCase(expectedTitle1))
	   System.out.println("Title Matched,Xero application homepage is displayed");
	   else
	   System.out.println("Title didn't match,Xero application homepage is not displayed");
	   
	   }
    @Test
    public static void TC1_IncorrectPwd() throws Exception {
      
  	   logger = report.startTest("TC1_IncorrectPwd");
  	   
  	   WebElement UN = driver.findElement(By.id("email"));
	   VisibleSelected(UN,"UserName");
	  
	   EnterText(UN,"lizabehera26@gmail.com","UserName");
	   
	   
	   WebElement PWD = driver.findElement(By.id("password"));
	   VisibleSelected(PWD,"Password");
	   EnterText(PWD,"jaan12","Password");
	   
	   WebElement Login = driver.findElement(By.id("logger = report.startTest("));
	   Click(Login,"submitbtn");
	   String actualmsg = driver.findElement(By.cssSelector("div.x-boxed warning error-message")).getText();
	   String Errormsg = "Your email or password is incorrect";
	   if(actualmsg.contains(Errormsg)) 
	   {
	       System.out.println("Error message displayed");
	   }else
	   {
	       System.out.println("Error message isnt displayed");
	   }
	   
	 }
    
    @Test
    public static void TC1_IncorrectEmail() throws Exception {
    	
   	   logger = report.startTest("TC1_IncorrectEmail");
   	   
   	   WebElement UN = driver.findElement(By.id("email"));
 	   VisibleSelected(UN,"UserName");
 	  
 	   EnterText(UN,"lizabehera26@@gmail.com","UserName");
 	   
 	   
 	   WebElement PWD = driver.findElement(By.id("password"));
 	   VisibleSelected(PWD,"Password");
 	   EnterText(PWD,"jaan12","Password");
 	   
 	   WebElement Login = driver.findElement(By.id("logger = report.startTest("));
 	   Click(Login,"submitbtn");
 	   String actualmsg = driver.findElement(By.cssSelector("div.x-boxed warning error-message")).getText();
 	   String Errormsg = "Your email or password is incorrect";
 	   if(actualmsg.contains(Errormsg)) 
 	   {
 	       System.out.println("Error message displayed");
 	   }else
 	   {
 	       System.out.println("Error message isnt displayed");
 	   }
 	   
 	   
 	 }
    @Test
    public static void TC1_ForgotPwd() {
	    logger = report.startTest("TC1_ForgotPwd");
	    WebElement ForgotPwd = 	driver.findElement(By.linkText("Forgot your password"));
	    ForgotPwd.click();
	     String actualTitle2 = driver.getTitle();
	     String expectedTitle2 = "Forgotten Password";
	     if(actualTitle2.equalsIgnoreCase(expectedTitle2))
	     {
	    	   System.out.println("Forgotten password page is displayed");
	     }
		   else
		   {
		   System.out.println("Forgotten password page is not displayed");
		   }
	     
	     WebElement UN = driver.findElement(By.id("email"));
		 VisibleSelected(UN,"UserName");
		 EnterText(UN,"lizabehera26@@gmail.com","UserName");
		 WebElement sendlink = driver.findElement(By.linkText("send link"));
		 sendlink.click();
 
	    	   
     
    }
    	
    	
    	
    }
	

