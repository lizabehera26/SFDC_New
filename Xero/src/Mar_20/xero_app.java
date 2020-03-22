package Mar_20;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class xero_app extends Reusable_xero {
	
    @BeforeMethod
    @Test
    public static void startup() throws Exception {
       CreateReport();
  	   DriverInitialization("chrome");
  	   OpenUrl("https://www.xero.com/us/");
  	   logger = report.startTest("startup");
  	   String actualTitle = driver.getTitle();
  	   String expectedTitle="Accounting Software - Do Beautiful Business | Xero US";
  	 
  	   if(actualTitle.equalsIgnoreCase(expectedTitle))
  	   System.out.println("Title Matched,Xero application page is displayed");
  	   else
  	   System.out.println("Title didn't match,Xero application page is not displayed");
  	   
    	
    	
    }
	@Test
	public static void TC1_login() throws Exception  {
		//Front page to Login
		logger = report.startTest("TC1_login");
		WebElement loginlink =driver.findElement(By.linkText("Login"));
		loginlink.click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	    Assert.assertEquals(pageTitle, "Login | Xero Accounting Software");
	    
       //Actual Login
	   WebElement UN = driver.findElement(By.id("email"));
	   VisibleSelected(UN,"UserName");
	   EnterText(UN,"lizabehera26@@gmail.com","UserName");
	   
	   
	   WebElement PWD = driver.findElement(By.id("password"));
	   VisibleSelected(PWD,"Password");
	   EnterText(PWD,"jaan121$$","Password");
	   
	   WebElement Login = driver.findElement(By.id("logger = report.startTest("));
	   Click(Login,"submitbtn");
	   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
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
	   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	   
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
 	  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
 	   
 	   
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
	    	   System.out.println("Forgotten password page is displayed ");
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
    //Sign up to Free Trial Account
    @Test 
    public static void TC2_SignUptoXDC() {
    	
    	logger = report.startTest("TC2_SignUptoXDC");
    	WebElement Freetrial = driver.findElement(By.linkText("Free trial")) ;
    	Freetrial.click();
    	String actualTitle3 = driver.getTitle();
	     String expectedTitle3 = "Accounting Software - Do Beautiful Business | Xero US";
	     if(actualTitle3.equalsIgnoreCase(expectedTitle3))
	     {
	    	   System.out.println("Free trial page is displayed ");
	     }
		   else
		   {
		   System.out.println("Free trial page is not displayed");
		   }
	     
	     WebElement Name = driver.findElement(By.name("FirstName"));
	     EnterText(Name,"Swagatika","FirstName");
	     WebElement LName = driver.findElement(By.name("LastName"));
	     EnterText(LName,"Joshi","Lastname");
	     
	     
    }
    	
    	
    	
    }
	

