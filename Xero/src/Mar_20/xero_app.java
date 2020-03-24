package Mar_20;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class xero_app extends Reusable_xero {
	
	@BeforeClass
    public static void Create_Report() throws Exception 
    {
    	CreateReport();
    }
	
    @AfterClass
    public static void Close_Report() throws Exception 
    {
    	CloseReport();
    }
	    
    @BeforeMethod
    public static void Startup() throws Exception 
    {
  	   DriverInitialization("chrome");
  	   OpenUrl("https://www.xero.com/us/");
  	   logger = report.startTest("startup");
  	   String actualTitle = driver.getTitle();
  	   String expectedTitle="Accounting Software - Do Beautiful Business | Xero US";
  	 
  	   if(actualTitle.equalsIgnoreCase(expectedTitle))
  	   {
  		   System.out.println("Title Matched,Xero application page is displayed");
  	   }
  	   else
  	   {
  		   System.out.println("Title didn't match,Xero application page is not displayed");
  	   }
    }
    
    @AfterMethod
    public static void CloseUp() throws Exception 
    {
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    	CloseBrowser();
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
	   EnterText(UN,"lizabehera26@gmail.com","UserName");
	   
	   
	   WebElement PWD = driver.findElement(By.id("password"));
	   VisibleSelected(PWD,"Password");
	   EnterText(PWD,"Aarvi121$$","Password");
	   
	   WebElement Login = driver.findElement(By.id("submitButton"));
	   Click(Login,"submitbtn");
	   
	   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	   String actualTitle1 = driver.getTitle();
	   String expectedTitle1 ="Xero | Dashboard | tekarch";
	   
	   if(actualTitle1.equalsIgnoreCase(expectedTitle1))
	   System.out.println("Title Matched,Xero application homepage is displayed");
	   else
	   System.out.println("Title didn't match,Xero application homepage is not displayed");
	   
	   //CloseBrowser();
	   
	   }
  
   /* @Test
    public static void TC1_IncorrectPwd() throws Exception {
      
  	   logger = report.startTest("TC1_IncorrectPwd");
  	   
  	   WebElement loginlink =driver.findElement(By.linkText("Login"));
		loginlink.click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	    Assert.assertEquals(pageTitle, "Login | Xero Accounting Software");
	    
  	   
  	   WebElement UN = driver.findElement(By.id("email"));
	   VisibleSelected(UN,"UserName");
	   EnterText(UN,"lizabehera26@gmail.com","UserName");
	   
	   
	   WebElement PWD = driver.findElement(By.id("password"));
	   VisibleSelected(PWD,"Password");
	   EnterText(PWD,"jaan12","Password");
	   
	   WebElement Login = driver.findElement(By.id("submitButton"));
	   Login.click();
	   String actualmsg = driver.findElement(By.tagName("li")).getText();
	   String Errormsg = "Your email or password is incorrect";
	   if(actualmsg.contains(Errormsg)) 
	   {
	       System.out.println("Error message displayed");
	   }else
	   {
	       System.out.println("Error message isnt displayed");
	   }
	   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	
	   
	   //CloseBrowser();
	 }
    
    @Test
    public static void TC1_IncorrectEmail() throws Exception {
    	
   	   logger = report.startTest("TC1_IncorrectEmail");
		WebElement loginlink =driver.findElement(By.linkText("Login"));
		loginlink.click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Login | Xero Accounting Software");

   	   
   	   WebElement UN = driver.findElement(By.id("email"));
 	   VisibleSelected(UN,"UserName");
 	  
 	   EnterText(UN,"lizabehera26@@gmail.com","UserName");
 	   
 	   
 	   WebElement PWD = driver.findElement(By.id("password"));
 	   VisibleSelected(PWD,"Password");
 	   EnterText(PWD,"jaan12","Password");
 	   
 	   WebElement Login = driver.findElement(By.id("submitButton"));
 	   Click(Login,"submitbtn");
 	   String actualmsg = driver.findElement(By.tagName("li")).getText();
 	   String Errormsg = "Your email or password is incorrect";
 	   if(actualmsg.contains(Errormsg)) 
 	   {
 	       System.out.println("Error message displayed");
 	   }else
 	   {
 	       System.out.println("Error message isnt displayed");
 	   }
 	  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
 	   
 	 //CloseBrowser();  
 	 }*/
   
    public static void TC1_ForgotPwd() {
	    logger = report.startTest("TC1_ForgotPwd");
	    WebElement loginlink =driver.findElement(By.linkText("Login"));
		loginlink.click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Login | Xero Accounting Software");
	    
	    WebElement ForgotPwd = 	driver.findElement(By.xpath("//a[@href='/ForgottenPassword']"));
	    ForgotPwd.click();
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
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
		 WebElement sendlink = driver.findElement(By.xpath("//a[@href='#']"));
		 sendlink.click();
		 
		//CloseBrowser();   
    }
   
    
    //Sign up to Free Trial Account
   
     
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
	     VisibleSelected(Name,"FirstName");
	     EnterText(Name,"Swagatika","Firstname");
	    
	     
	     WebElement LName = driver.findElement(By.name("LastName"));
	     VisibleSelected(LName,"LastName");
	     EnterText(LName,"Joshi","Lastname");
	     
	     WebElement EmailAdd = driver.findElement(By.name("EmailAddress"));
	     VisibleSelected(EmailAdd,"EmailAddress");
	     EnterText(EmailAdd,"lizabehera26@gmail.com","Emailaddress");
	     
	     WebElement PhNo = driver.findElement(By.name("PhoneNumber"));
	     VisibleSelected(PhNo,"9999999987");
	     EnterText(PhNo,"999999987","Phonenumber");
	     
	     Select dropdown = new Select(driver.findElement(By.name("LocationCode")));
	     dropdown.selectByValue("US");
	     driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	     
	     WebElement chkbox = driver.findElement(By.name("TermsAccepted"));
	     chkbox.click();
	     if(chkbox.isSelected()) {
	    	 
	    	 System.out.println("chkbox is toggled on ");
	     }else {
	    	 
	    	 System.out.println("chkbox is not toggled on");
	     }
	     
	     WebElement getstartbtn = driver.findElement(By.className("g-recaptcha-submit"));
	     getstartbtn.click();
	     driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	     
	     
	       }
     
     public static void TC2B_SignUptoXDC() {
    	logger = report.startTest("TC2B_SignUptoXDC");
    	WebElement Freetrial = driver.findElement(By.linkText("Free trial")) ;
     	Freetrial.click();
     	String actualTitle3 = driver.getTitle();
 	    String expectedTitle3 = "Signup for Xero - Free Trial | Xero US";
 	     if(actualTitle3.equalsIgnoreCase(expectedTitle3))
 	     {
 	    	   System.out.println("Free trial page is displayed ");
 	     }
 		   else
 		   {
 		   System.out.println("Free trial page is not displayed");
 		   }
 	  WebElement getstartbtn = driver.findElement(By.className("g-recaptcha-submit"));
	  getstartbtn.click();
	  String Errormsg = driver.findElement(By.id("signup-form-error-message-1")).getText();
	  Assert.assertEquals(Errormsg, "First name can't be empty");
	  String Errormsg1 = driver.findElement(By.id("signup-form-error-message-2")).getText();
	  Assert.assertEquals(Errormsg1, "Last name can't be empty");
	  String Errormsg2 = driver.findElement(By.id("signup-form-error-message-3")).getText();
	  Assert.assertEquals(Errormsg2, "Email address can't be empty");
	  String Errormsg3 = driver.findElement(By.id("signup-form-error-message-4")).getText();
	  Assert.assertEquals(Errormsg3, "Phone number can't be empty");
	  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	  
	  // verify the invalid email address message
	  
	 WebElement EmailAdd = driver.findElement(By.name("EmailAddress"));
     VisibleSelected(EmailAdd,"EmailAddress");
     EnterText(EmailAdd,"lizabehera26@gmail","Emailaddress");
	     
     String Invalidmsg = driver.findElement(By.xpath("//span[@id='signup-form-error-message-1\']")).getText();
     Assert.assertEquals(Invalidmsg, "Email address is invalid");
     driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
     
     
     WebElement getstartbtn1 = driver.findElement(By.className("g-recaptcha-submit"));
     getstartbtn1.click();
     //WebElement chkbox = driver.findElement(By.name("TermsAccepted"));
    
     //How to verify an element is highlighted or not??
     
     
  }
      
    	public static void TC2C_SignUptoXDC() {
    		
    		logger = report.startTest("TC2C_SignUptoXDC");
    		//go to free trial page
    		WebElement Freetrial = driver.findElement(By.linkText("Free trial")) ;
         	Freetrial.click();
         	String actualTitle3 = driver.getTitle();
     	    String expectedTitle3 = "Signup for Xero - Free Trial | Xero US";
     	     if(actualTitle3.equalsIgnoreCase(expectedTitle3))
     	     {
     	    	   System.out.println("Free trial page is displayed ");
     	     }
     		   else
     		   {
     		   System.out.println("Free trial page is not displayed");
     		   }
     	     //click on terms link
    		WebElement terms = driver .findElement(By.xpath("//a[@href='https://www.xero.com/us/about/terms/']"));
    		terms.click();
    		String oldwindow = driver.getWindowHandle();
    		//Set<String> getAllWindows = driver.getWindowHandles();
    		//String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
    		//driver.switchTo().window(getWindow[1]);
    		System.out.println(driver.getCurrentUrl());
    		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    		
    		//come back to free trial page and click on privacy link
    		driver.switchTo().window(oldwindow);
    		WebElement privacy = driver.findElement(By.xpath("//a[@href='https://www.xero.com/us/about/privacy/']"));
    		privacy.click();
    		String newwindow =driver.getWindowHandle();
    		driver.switchTo().window(newwindow);
    		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    		//driver.switchTo().window(getWindow[2]);
    		System.out.println(driver.getCurrentUrl());
    		
    		// Testing of offer details link(TC-2D)
    		 driver.switchTo().window(oldwindow);
    		 
    		 WebElement offers = driver.findElement(By.xpath("//a[@href='https://www.xero.com/us/signup/offer-details/']"));
	 	     offers.click();
	 	     String freshwindow = driver.getWindowHandle();
	 	     driver.switchTo().window(freshwindow);
	 	     //driver.switchTo().window(getWindow[3]);
	 	     System.out.println(driver.getCurrentUrl());
	 	     
	 	     
	 	    //Click on accountant or bookeeper link (TC-2E)
	 	     
	 	    WebElement accountant = driver.findElement(By.linkText("accountant or bookkeeper"));
	 	    accountant.click();
	 	    String realTitle = driver.getTitle();
	 	    Assert.assertEquals(realTitle,"Sign up for the Xero Partner Program | Xero US");
	 	    
	 	    
	   }
        
        @Test(dependsOnMethods= "TC1_login")
        public static void TC3_Testalltabs() throws InterruptedException{
        	
        logger = report.startTest("TC3_Testalltabs");
        //Dashboard tab testing
       /*WebElement Dashboard = driver.findElement(By.xpath("//a[@href='https://go.xero.com/Dashboard']"));
       Dashboard.click();
       Thread.sleep(4000);
       String DashboardTitle = driver.getTitle();
   	   String DashTitle="Accounting Software - Do Beautiful Business | Xero US";
   	 
   	   if(DashboardTitle.equalsIgnoreCase("Xero | Dashboard | tekarch"))
   	   {
   		   System.out.println("Title Matched,Dashboard  page is displayed");
   	   }
   	   else
   	   {
   		   System.out.println("Title didn't match,Dashboard page is not displayed");
   	   }*/
   	   
   	   //Accounting tab testing
        
   	   WebElement Accounting = driver.findElement(By.className("xrh-focusable xrh-tab--body"));
   	   Accounting.click();
   	   System.out.println("You are on Accounting dropdown page");
   	   
   	   //Contact tab testing
   	 
   	   String Arr[] = {"All contacts","Customer","Suppliers"};
   	   Select select = new Select( driver.findElement(By.xpath("//button[@name='navigation-menu/contacts']")));
   	   List <WebElement> contact = select.getOptions();
   	   System.out.println(contact.size());
   	   
   	   for(int i=0;i<contact.size();i++) {
   		   Assert.assertEquals(Arr[i], contact.get(i).getText());
   	   }
   	   Thread.sleep(5000);
   	   System.out.println("Verification successfull");
   	  
   	   //New Tab Testing
   	   WebElement newtab = driver.findElement(By.xpath("//button[@title='Quick Launch']"));
   	   newtab.click();
   	   System.out.println("you are on newtab dropdown menu");
   	   
   	   //Search tab Testing
   	   WebElement searchbtn = driver.findElement(By.xpath("//button[@title='search']"));
   	   VisibleSelected(searchbtn,"search");
   	   searchbtn.click();
   	   
   	   //Help tab
   	   WebElement helpbtn = driver.findElement(By.xpath("//button[@title='Help']"));
   	   VisibleSelected(helpbtn ,"help");
   	   helpbtn.click();
   	 
       }
        @Test(dependsOnMethods="TC1_login")
        public static void TC4_Logout() {
        	logger = report.startTest("TC4_Logout");
        	WebElement Editprofile = driver.findElement(By.xpath("//*[contains(@title,'User Info')]"));
        	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        	Select select = new Select(Editprofile);
        	select.selectByVisibleText("Log out");
        	String logoutpage = driver.getTitle();
        	Assert.assertEquals(logoutpage,"Login | Xero Accounting Software");
        	
        }
       
        public static void TC6_Profile() throws InterruptedException {
        	
        logger = report.startTest("TC6_Profile");
        WebElement Editprofile = driver.findElement(By.xpath("//*[contains(@title,'User Info')]"));
    	
    	Select select = new Select(Editprofile);
    	select.selectByVisibleText("Swagatika Joshi");
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    	String profilepage = driver.getTitle();
    	Assert.assertEquals(profilepage,"My Xero | Profile Settings");
    	
    	WebElement UploadImg = driver.findElement(By.id("button-1041-btnInnerEl"));
    	UploadImg.click();
    	WebElement frame = driver.switchTo().activeElement();
    	frame.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures");
    	WebElement Upload = driver.findElement(By.id("button-1192-btnInnerEl"));
    	Upload.click();
    	Thread.sleep(5000);
    	
    	
       
        	
        }
        
        
    	
    	
    		
    	}
    	
    	
    
	

