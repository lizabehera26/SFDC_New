import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDC_TestCases extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();
		//TC_1_LoginErrorMessage();
		//TC_3_LoginToSalesForce2();
		
		//TC_4A_ForgotPassword();
		//TC_4B_ForgotPassword();
		LoginToSalesforce();
		//TC_5_UserNameDropdown();
		//TC_7_MySettings();
		//TC_8_DeveloperConsole();
		//TC_9_LogOut();
		//TC_10_CreateAccount() ;
		//TC_11_CreateNewView() ;
		// TC_12_EditView();
		//TC_13_Merge_Accounts();
		// TC_14_Create_Account_Report();
		 
		 //TC_16_CreateNewOpty();
		 //TC_17_PipeLineReport();
		// TC_19_Quarterly_summaryReport() ;
		 //TC_20_LeadsTab() ;
		// TC_21_Leads_SelectView();
		 //TC_22_DefaultView();
		 //TC_23_LeadLogOut();
		 //TC_24_Lead_New();
		 //TC_25_CreateNewContact();
		  //TC_26_Create_NewView();
		  //TC_27_RecentlyCheckcontact();
		  //TC_28_Check_MyContacts();
		  //TC_29_ViewContact();
		 // TC_30_CreateNewView_Cancel() ;
		 // TC_31_Check_ErrorMessage();
		  //TC_32_Check_Save_Btn();
		  TC_33_RandomScenarios_1() ;
		  //TC_34_RandomScenarios_2();
		  
		
 	   // TC_2_LoginToSalesForce();
		//TC_3_LoginToSalesForce();
		//TC_2_LoginToSalesForce();
		//TC_3_LoginToSalesForce();
		//TC_2_LoginToSalesForce();
		//TC_3_LoginToSalesForce();

		CloseBrowser();
		CloseReport();
	}
	
	public static void LoginToSalesforce() throws InterruptedException {
		//Thread.sleep(2000);
		OpenUrl("https://login.salesforce.com");
		logger = report.startTest("LoginToSalesforce");
		WebElement Uname = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		EnterText(Uname, "liza@archtek.com", "Username");
		

		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		EnterText(pwd, "Aarvi121", "Password");
		//WebElement rembox = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/label"));
		//rembox.click();
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();
		//driver.quit();
	}
	
	public static	void TC_1_LoginErrorMessage() throws InterruptedException {
		 
		 	OpenUrl("https://login.salesforce.com");
		 	//logger = report.startTest("111111TC_2_LoginToSalesForce");

			WebElement un = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			un.sendKeys("liza@archtek.com");
			WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			pwd.clear();
			WebElement login = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			login.click();
			
			
			String errormessage= driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();
			if(errormessage.equals("please enter your password")) {
				
				System.out.println("Error message is been displayed");
				}
			else {
				System.out.println("Error message is not been displayed");
			}
			Thread.sleep(3000);
			driver.quit();

	}
	public static void TC_2_LoginToSalesForce() {
		logger = report.startTest("111111TC_2_LoginToSalesForce");

		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "liza@archtek.com", "Username");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "Aarvi121", "Password");
		// pwd.sendKeys("Test4321");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		// loginBtn.click();

		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "User is on home page");
		// System.out.println("User is on home page");
		else
			logger.log(LogStatus.FAIL, "home page is not Lunched");
		// System.out.println("home page is not Lunched");
	}

	public static void TC_3_LoginToSalesForce() {
		logger = report.startTest("TC_3_LoginToSalesForce");

		OpenUrl("https://login.salesforce.com");
		logger.log(LogStatus.INFO, "222222URL opened successfully");
		// System.out.println("URL opened successfully");
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(un, "liza@archtek.com", "Username");

		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "Aarvi121", "Password");
		// pwd.sendKeys("Test4321");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		loginBtn.click();

		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "User is on home page");
		// System.out.println("User is on home page");
		else
			logger.log(LogStatus.FAIL, "home page is not Lunched");
		// System.out.println("home page is not Lunched");
	}
	public static void TC_3_LoginToSalesForce2() throws InterruptedException {
		
		OpenUrl("https://login.salesforce.com");
		WebElement Uname = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		EnterText(Uname, "liza@archtek.com", "Username");

		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "Aarvi121", "Password");
		
		WebElement rembox = driver.findElement(By.id("rememberUn"));
		rembox.click();
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		loginBtn.click();
		WebElement userbtn = driver.findElement(By.xpath("//*[@id=\"148:232;a\"]/span[1]/div/span"));
		userbtn.click();
		WebElement LogoutBtn = driver.findElement(By.xpath("//*[@id=\"content_111:3721;a\"]/div/div[2]/div/a[2]"));
		LogoutBtn.click();
			
	}
	public static void TC_4A_ForgotPassword() {
		OpenUrl("https://login.salesforce.com");
		WebElement Forgotpwd = driver.findElement(By.id("forgot_password_link"));
		Forgotpwd.click();
		
		WebElement Uname = driver.findElement(By.id("un"));
		EnterText(Uname, "liza@archtek.com", "Username");

		WebElement Cont = driver.findElement(By.id("continue"));
		Cont.click();
		
	}
	public static void TC_4B_ForgotPassword() {
		OpenUrl("https://login.salesforce.com");
		
		WebElement Uname = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		EnterText(Uname, "liz@archtek.com", "Username");

		
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "Aarv", "Password");
		WebElement rembox = driver.findElement(By.id("rememberUn"));
		rembox.click();
		
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		loginBtn.click();
		String errormessage= driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();
		if(errormessage.equals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.")) {
			
			System.out.println(" messagError is been displayed");
			}
		else {
			System.out.println("Error message is not been displayed");
		}
		
		
	}
	//Both test case 5 and 6 are executed in TC_5_UserNamedropdown
		public static void TC_5_UserNameDropdown() throws InterruptedException {
		OpenUrl("https://login.salesforce.com");
		logger = report.startTest("TC_5_UserNameDropdown");
		WebElement Uname = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		EnterText(Uname, "liza@archtek.com", "Username");
		

		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		EnterText(pwd, "Aarvi121", "Password");
		WebElement rembox = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/label"));
		rembox.click();
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();
		Thread.sleep(3000);
		;
		WebElement Userdropdown= driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		Userdropdown.click();
		
		WebElement myprofilebtn = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		myprofilebtn.click();
		
		WebElement EditBtn = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		EditBtn.click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contactInfoContentId']")));

        WebElement aboutTab = driver.findElement(By.xpath("//*[@id='aboutTab']/a"));
        Click(aboutTab, "aboutTab");
        
        WebElement LstNmBtn = driver.findElement(By.id("lastName"));
		EnterText(LstNmBtn,"Joshi","lastName");
		
		
		WebElement SaveAllBtn = driver.findElement(By.xpath("//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
		
		Click(SaveAllBtn,"TabPanel");
		
		WebElement PostBtn = driver.findElement(By.xpath("//*[@id='publisherAttachTextPost']/span[1]"));
		PostBtn .click();
		
		WebElement postIframe=driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		
		
		WebElement TxtBox = driver.findElement(By.xpath("//*[@id='publisherAttachTextPost']/span[1]"));
		Click(TxtBox,"publisherAttachTextPost");
		EnterText(TxtBox,"Hello","publisherattachtext");
		
		SwitchFrame();
		WebElement ShareButton = driver.findElement(By.xpath("//input[@id='publishersharebutton']")); 
		Click(ShareButton, "ShareButton");
		System.out.println("Text Posted is shared");
		
		Thread.sleep(3000);
		WebElement FileLink = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
		Click(FileLink, "FileLink");
		WebElement UploadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		Click(UploadFile, "UploadFile");
		
		Thread.sleep(3000);
		WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		
		EnterText(choosefile, "C:\\test", "choosefile");
		WebElement Share = driver.findElement(By.id("publishersharebutton"));
		Click(Share, "ShareButton");
		
		Thread.sleep(10000);
		
		//Uploading photo
				Thread.sleep(3000);
				WebElement moderator = driver.findElement(By.id("displayBadge"));
				//clickObj(AddPhoto, "AddPhoto");
				MouseOver(driver, moderator);
				WebElement AddPhotolink = driver.findElement(By.xpath("//a[@id='uploadLink']"));
				Click(AddPhotolink, "AddPhotolink");
				SwitchFrame("uploadPhotoContentId");
				Thread.sleep(3000);
				WebElement choosefileoption = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
				EnterText(choosefileoption, "C:\\Users\\Public\\Pictures\\Sample Pictures","choosefileoption");
				WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
				Click(save, "save");
				System.out.println("TC06_MyProfile completed successfully");
				Thread.sleep(3000);
				WebElement save2 = driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
				Click(save2,"Save Crop");
				
				Thread.sleep(15000);
				driver.close();
				
	
	}
		public static void TC_7_MySettings() throws InterruptedException {
			
			WebElement Userdropdown= driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
			Userdropdown.click();
			WebElement mysetting = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
			//mysetting.click();
			Click(mysetting,"menuItems");
			WebElement Personal = driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/a"));
			Click(Personal,"PersonalInfo");
			
			//WebElement LoginHistory =driver.findElement(By.id("LoginHistory_font"));
			//Click(LoginHistory, "LoginHistory_font");
			
			WebElement Display =driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_font\"]"));
			Click(Display,"DisplayAndLayout_font");
			WebElement Customizetab =driver.findElement(By.xpath(""));
			Click(Customizetab,"CustomizeTabs_font");
			WebElement Customapp = driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[2]/table/tbody/tr[1]/td/label"));
			Select select =new Select(Customapp);
			select.selectByVisibleText("Salesforce Chatter");
			
			WebElement AvailableTabs = driver.findElement(By.xpath("//*[@id=\"duel\"]/table/tbody/tr/td[1]/div/label"));
			Select select1 = new Select(AvailableTabs);
			select1.selectByVisibleText("Reports");
			WebElement Addbtn = driver.findElement(By.xpath("//*[@id=\"duel\"]/table/tbody/tr/td[2]/div[1]"));
			Click(Addbtn,"CustomizeTabs_font");
			
			
			WebElement Email =driver.findElement(By.id("EmailSetup_font"));
			Click(Email,"EmailSetup_font");
			WebElement Emailstng = driver.findElement(By.xpath("EmailSettings_font"));
			Click(Emailstng,"EmailSettings_font");
			WebElement EmailName = driver.findElement(By.id("sender_name"));
			EnterText(EmailName,"liza joshi","sender_name");
			WebElement EmailAddress = driver.findElement(By.id("sender_email"));
			EnterText(EmailAddress,"lizabehera26@gmail.com","sender_email");
			
			WebElement radio_button = driver.findElement(By.name("auto_bcc"));
			radio_button.click();
			WebElement save_btn = driver.findElement(By.name("save"));
			Click(save_btn, "save");
			
			WebElement calender_rmndr = driver.findElement(By.id("CalendarAndReminders_font"));
			Click(calender_rmndr,"CalendarAndReminders_font");
			WebElement activity_rmndr = driver.findElement(By.id("Reminders_font"));
			Click(activity_rmndr,"Reminders_font");
			
			
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1")));

            WebElement testrmnder_tab = driver.findElement(By.xpath("//*[@id=\"testbtn\"]"));

            Click(testrmnder_tab, "testbtn");


	}
		public static void TC_8_DeveloperConsole() {
			logger = report.startTest("TC_8_DeveloperConsole");
			WebElement Userdropdown= driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
			Userdropdown.click();
			
			WebElement Devcon = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
			Devcon.click();
			driver.close();
		
		}
		
	public static void TC_9_LogOut() {
		logger = report.startTest("TC_9_LogOut");

		WebElement Userdropdown= driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		
		Click(Userdropdown,"userNavLabel");
		WebElement LogOut= driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		Click(LogOut,"userNav-menuItems");
		
		}
	public static void TC_10_CreateAccount() throws InterruptedException {
		logger = report.startTest("TC_10_CreateAccount");
		WebElement Account = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		Click(Account,"Account_Tab");
		Thread.sleep(2000);
		driver.getWindowHandles();
		
		WebElement CreateNew = driver.findElement(By.xpath("//*[@id=\"createNewButton\"]"));
		Click(CreateNew,"createNewButton");
		Thread.sleep(3000);
		driver.getWindowHandles();
			
		WebElement AccountName = driver.findElement(By.id("acc2"));
		EnterText(AccountName,"lizajoshi","acc2");
		Thread.sleep(5000);
		
		WebElement AccountType = driver.findElement(By.id("acc6"));
		Select select = new Select(AccountType);
		select.selectByVisibleText("Technology Partner");
		
		Thread.sleep(3000);
		WebElement CustomerPriority = driver.findElement(By.id("00N2w0000054U7l"));
		Select select1 = new Select(CustomerPriority);
		select1.selectByVisibleText("High");

		}
	public static void TC_11_CreateNewView() throws InterruptedException {
		logger = report.startTest("TC_10_CreateNewView");
		WebElement Account = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		Click(Account,"Account_Tab");
		Thread.sleep(2000);
		WebElement Newview = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		Click(Newview,"filter_element");
		Thread.sleep(3000);
		WebElement ViewName = driver.findElement(By.xpath("///*[@id=\"fname\"]"));
		EnterText(ViewName,"swagatika","fname");
		
		WebElement UniqueName = driver.findElement(By.xpath("//*[@id=\"devname\"]"));
		EnterText(UniqueName,"White","devname");
		WebElement Save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		Click(Save,"editPage");
		
		
	}
	public static void TC_12_EditView() throws InterruptedException {
		logger = report.startTest("TC_12_EditView");
		WebElement Account = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		Click(Account,"Account_Tab");
		Thread.sleep(2000);
		WebElement view = driver.findElement(By.id("fcf"));
		Select select3 = new Select(view);
		select3.selectByVisibleText("New Last Week");
		Thread.sleep(3000);
			
	}
    public static void TC_13_Merge_Accounts() throws InterruptedException {
    	logger = report.startTest("TC_13_Merge_Accounts");
    	WebElement Account = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		Click(Account,"Account_Tab");
		Thread.sleep(2000);
		
		WebElement Merge_Account= driver.findElement(By.xpath("//*[@id='toolsContent']/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		Click(Merge_Account,"toolsContent");
		Thread.sleep(3000);
		
		WebElement TxtBox = driver.findElement(By.xpath("//*[@id=\"srch\"]"));
		EnterText(TxtBox,"United","srch");
		Thread.sleep(2000);
		WebElement FindBtn= driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		Click(FindBtn,"stageForm");
		Thread.sleep(3000);
		
		List <WebElement> checkBoxes =driver.findElements(By.xpath("//*[@id=\"cid0\"]"));
		   for(int i=0; i<2; i++){
		    checkBoxes.get(i).click();
		    }
		   Thread.sleep(3000);
    }
    public static void TC_14_Create_Account_Report() throws InterruptedException {
    	logger = report.startTest("TC_Create_Account_Report");
    	WebElement Account = driver.findElement(By.xpath("//*[@id='Account_Tab']/a"));
		Click(Account,"Account_Tab");
		Thread.sleep(2000);
		
		WebElement LastActivity= driver.findElement(By.xpath("//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		Click(LastActivity,"toolsContent");
		Thread.sleep(3000);
		
		WebElement createdate = driver .findElement(By.xpath("/div[@class='x-combo-list-item x-combo-selected']"));
		Click(createdate,"created date");
		//WebElement Daterange = driver.findElement(By.xpath("//*[@id='ext-gen']"));
		//EnterText(Daterange,"Today","duration-ext-gen17");
		//Thread.sleep(3000);
       List<WebElement> fromDate=driver.findElements(By.className("x-form-trigger x-form-date-trigger"));
		
		for(WebElement ele:fromDate)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("19"))
			{
				ele.click();
				break;
			}
			
		}
List<WebElement> toDate=driver.findElements(By.className("x-form-trigger x-form-date-trigger"));
		
		for(WebElement ele:toDate)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("19"))
			{
				ele.click();
				break;
			}
			
		}
		
		
		
		WebElement SaveBtn = driver.findElement(By.id("ext-gen49"));
		Click(SaveBtn,"ext-gen49");
		WebElement Reportname = driver.findElement(By.id("saveReportDlg_reportNameField"));
		EnterText(Reportname,"Tc13","saveReportDlg_reportNameField");
		
		WebElement Report_uniname = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		EnterText(Report_uniname,"Tc13report","saveReportDlg_DeveloperName");
		Thread.sleep(2000);
		WebElement SaverunBtn = driver.findElement(By.id("ext-gen341"));
		Click(SaverunBtn,"ext-gen341");
		Thread.sleep(3000);
  }
    public static void TC_15_Opportunitiesdropdown() throws InterruptedException {
    	logger = report.startTest("TC_15_Opportunitiesdropdown");
    	WebElement Opp = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')"));
    	Click(Opp,"Opportunity_Tab");
    	Thread.sleep(5000);
    	
    	WebElement Odropdown = driver.findElement(By.id(" /html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[1]/select[1]"));  
    	Select select = new Select(Odropdown);  
    	List<WebElement> options = select.getOptions();  
    	for(WebElement we:options)  
    	{  
    	 System.out.println(we.getText());  
    	}  
   Thread.sleep(3000);
     }
 public static void TC_16_CreateNewOpty() throws InterruptedException {
	 logger = report.startTest("TC_16_CreateNewOpty");
	 WebElement Opp = driver.findElement(By.xpath("//*[@id='Opportunity_Tab']/a"));
 	 Click(Opp,"Opportunity_Tab");
 	 Thread.sleep(5000);
 	 
 	 WebElement NewBtn = driver.findElement(By.xpath("//input[@name='new']"));
 	 Click(NewBtn,"new");
 	 WebElement OppName =driver.findElement(By.id("opp3"));
 	 EnterText(OppName,"Alpha","opp3");
 	Thread.sleep(3000);
 	 WebElement AccountName =driver.findElement(By.id("opp4"));
	 EnterText(AccountName,"Beta","opp4");
	 Thread.sleep(3000);
	 WebElement closedateBox=driver.findElement(By.id("opp9"));
	 EnterText(closedateBox,"02/18/2020","opp9");
	 
	 Thread.sleep(3000);
	 
	 Select s1 = new Select(driver.findElement(By.xpath("//*[@id='opp11']")));
 	 s1.selectByVisibleText("Need Analysis");
 	Thread.sleep(3000);
 	
 	
    }
 
 public static void TC_17_PipeLineReport() throws InterruptedException {
	 logger=report.startTest("TC_17_PipeLineReport");
	 WebElement Opp = driver.findElement(By.xpath("//*[@id='Opportunity_Tab']/a"));
 	 Click(Opp,"Opportunity_Tab");
 	 Thread.sleep(5000);
 	 WebElement OppPipeLine= driver.findElement(By.xpath("//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
 	 Click(OppPipeLine,"toolsContent");
 	 Thread.sleep(3000);
 }
 public static void TC_18_StuckOpportunity_report() throws InterruptedException {
	 logger=report.startTest("TC_18_StuckOpportunity_report"); 
	 WebElement Opp = driver.findElement(By.xpath("//*[@id='Opportunity_Tab']/a"));
 	 Click(Opp,"Opportunity_Tab");
 	 Thread.sleep(5000);
 	 
 	 WebElement stuckOpp= driver.findElement(By.xpath("//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
	 Click(stuckOpp,"toolsContent");
	 Thread.sleep(2000);
 }
 public static void TC_19_Quarterly_summaryReport() throws InterruptedException {
	 logger=report.startTest("TC_19_Quarterly_summaryReport");
	 WebElement Opp = driver.findElement(By.xpath("//*[@id='Opportunity_Tab']/a"));
 	 Click(Opp,"Opportunity_Tab");
 	 Thread.sleep(5000);
 	 WebElement dropdown = driver.findElement(By.id("quarter_q"));
 	 Select select = new Select(dropdown);
     select.getOptions();
 	 Thread.sleep(5000);
 	 
 	WebElement dropdown2 = driver.findElement(By.id("open"));
 	Select s2 = new Select(dropdown2);
 	s2.selectByVisibleText("All Opportunity");
 	 Thread.sleep(5000);
 	  }
 public static void TC_20_LeadsTab() throws InterruptedException {
	 logger=report.startTest("TC_20_LeadsTab");
	 WebElement Leadtab = driver.findElement(By.xpath("//*[@id='Lead_Tab']/a"));
	 Click(Leadtab,"Lead_Tab");
	 Thread.sleep(3000);
	 driver.close();
	 
 }
 public static void TC_21_Leads_SelectView() throws InterruptedException {
	 logger=report.startTest("TC_21_Leads_SelectView");
	 WebElement Leadtab = driver.findElement(By.xpath("//*[@id='Lead_Tab']/a"));
	 Click(Leadtab,"Lead_Tab");
	 Thread.sleep(3000);
	 
	 String[] exp = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View-Cutom 1","View-Custom 2"};
	 WebElement dropdown = driver.findElement(By.xpath("//*[@id='fcf']"));  
	 Select select = new Select(dropdown);  

	 List<WebElement> options = select.getOptions();  
	 for(WebElement we:options)  
	 {  
	  boolean match = false;
	  for (int i=0; i<exp.length; i++){
	      if (we.getText().equals(exp[i])){
	        match = true;
	      }
	    }
	  Assert.assertTrue(match);
	 }  
	 Thread.sleep(3000);
 }
 public static void TC_22_DefaultView() throws InterruptedException {
	 logger=report.startTest("TC_22_DefaultView");
	 WebElement Leadtab = driver.findElement(By.xpath("//*[@id='Lead_Tab']/a"));
	 Click(Leadtab,"Lead_Tab");
	 Thread.sleep(3000);
	 
	 String[] exp = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View-Cutom 1","View-Custom 2"};
	 WebElement dropdown = driver.findElement(By.xpath("//*[@id='fcf']"));  
	 Select select = new Select(dropdown);  
	 select.selectByIndex(3);
	 Thread.sleep(3000);
	 WebElement GoBtn = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[1]/input"));
	 Click(GoBtn,"filter_element");
	 Thread.sleep(3000);
	 
	 }
 public static void TC_23_LeadLogOut() throws InterruptedException {
	 logger=report.startTest("TC_23_LeadLogOut");
	 WebElement Leadtab = driver.findElement(By.xpath("//*[@id='Lead_Tab']/a"));
	 Click(Leadtab,"Lead_Tab");
	 Thread.sleep(3000);
	 
	 String[] exp = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View-Cutom 1","View-Custom 2"};
	 WebElement dropdown = driver.findElement(By.xpath("//*[@id='fcf']"));  
	 Select select = new Select(dropdown);  
	 select.selectByIndex(3);
	 Thread.sleep(3000);
	 WebElement GoBtn = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[1]/input"));
	 Click(GoBtn,"filter_element");
	 Thread.sleep(3000); 
	 
	 WebElement LogoutBtn = driver.findElement(By.xpath("//*[@id=\'content_111:3721;a\']/div/div[2]/div/a[2]"));
	 LogoutBtn.click();
	 
	 
 }
 public static void TC_24_Lead_New() throws InterruptedException {
	 logger=report.startTest("TC_24_Lead_New");
	 WebElement Leadtab = driver.findElement(By.xpath("//*[@id='Lead_Tab']/a"));
	 Click(Leadtab,"Lead_Tab");
	 Thread.sleep(3000);
	 
	 WebElement NewBtn = driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
	 Click(NewBtn,"hotlist");
	 Thread.sleep(3000);
	
	 WebElement lastnamebox = driver.findElement(By.id("name_lastlea2"));
	 EnterText(lastnamebox,"My Last Name","name_firstlea2");

	 WebElement companynamebox = driver.findElement(By.id("lea3"));
	 EnterText(companynamebox,"My Company Name","lea3");
	 Thread.sleep(2000);

	 WebElement SaveBtn = driver.findElement(By.xpath("//*[@id=\'topButtonRow\']/input[1]"));
	 Click(SaveBtn,"topButtonRow");
	 Thread.sleep(5000);
	 
	  }
 public static void TC_25_CreateNewContact() throws InterruptedException {
	 logger=report.startTest("TC_25_CreateNewContact");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 WebElement NewTab = driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
	 Click(NewTab,"hotlist");
	 WebElement lastnamebox = driver.findElement(By.id("name_lastcon2"));
	 EnterText(lastnamebox,"My Contact Last Name","lastnamebox");
	 Thread.sleep(2000);
	 
	 WebElement accountnamebox = driver.findElement(By.xpath("//*[@id=\'con4\']"));
	 EnterText(accountnamebox,"Test Account","accountnamebox");
	 Thread.sleep(3000);
	 
	 WebElement SaveBtn = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]"));
	 Click(SaveBtn,"topButtonRow");
	 Thread.sleep(5000);
	 
	}
 public static void TC_26_Create_NewView() throws InterruptedException {
	 logger=report.startTest("TC_26_Create_NewView");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 WebElement CreateNewViewBtn = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[2]"));
	 Click(CreateNewViewBtn,"filter_element");
	 Thread.sleep(5000);
	 WebElement ViewNamebox =driver.findElement(By.id("fname"));
     EnterText(ViewNamebox,"swagatika","fname");
     
     WebElement Unique= driver.findElement(By.id("devname"));
     Click(Unique,"devname");
     
     WebElement SaveBtn = driver.findElement(By.xpath("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]"));
	 Click(SaveBtn,"editPage");
	 Thread.sleep(5000);
	 
    }
 public static void TC_27_RecentlyCheckcontact() throws InterruptedException {
	 logger=report.startTest("TC_27_RecentlyCheckcontact");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 
	 WebElement Dropdown = driver.findElement(By.id("hotlist_mode"));
	 Select Item = new Select(Dropdown);
	 Item.selectByVisibleText("Recently Created");
	 Thread.sleep(5000);
	 
	}
 public static void TC_28_Check_MyContacts() throws InterruptedException {
	 logger=report.startTest("TC_28_Check_MyContacts");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 
	 
	 WebElement Dropdown = driver.findElement(By.id("fcf"));
	 Select Item = new Select(Dropdown);
	 Item.selectByVisibleText("My Contacts");
	 Thread.sleep(5000);
	 }
 public static void TC_29_ViewContact() throws InterruptedException {
	 logger=report.startTest("TC_29_ViewContact");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 
	 WebElement Name =driver.findElement(By.xpath("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[6]/th/a"));
	 Click(Name,"bodyCell");
	 Thread.sleep(5000);
	 }
 public static void TC_30_CreateNewView_Cancel() throws InterruptedException {
	 logger=report.startTest("TC_30_CreateNewView_Cancel");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 
	 WebElement CreateNewViewBtn = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[2]"));
	 Click(CreateNewViewBtn,"filter_element");
	 Thread.sleep(5000);
	 
	 WebElement ViewNamebox =driver.findElement(By.id("fname"));
     EnterText(ViewNamebox,"abcd","fname");
     
     WebElement Unique= driver.findElement(By.id("devname"));
     EnterText(Unique,"efgh","fname");
     Thread.sleep(3000);
     WebElement Cancel =driver.findElement(By.xpath("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[2]"));
     Click(Cancel,"editpage");
     Thread.sleep(3000);
     
	 }
 public static void TC_31_Check_ErrorMessage() throws InterruptedException {
	 logger=report.startTest("TC_31_Check_ErrorMessage");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 
	 WebElement CreateNewViewBtn = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[2]"));
	 Click(CreateNewViewBtn,"filter_element");
	 Thread.sleep(5000);
	 
	 WebElement Unique= driver.findElement(By.id("devname"));
     EnterText(Unique,"efgh","fname");
     Thread.sleep(3000);
     
     WebElement SaveBtn = driver.findElement(By.xpath("//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]"));
	 Click(SaveBtn,"editPage");
	 Thread.sleep(5000);
	 
	 
	 
	 Thread.sleep(4000);
	 
	 }
 public static void TC_32_Check_Save_Btn() throws InterruptedException {
	 logger=report.startTest("TC_32_Check_Save_Btn");
	 WebElement ContactTab = driver.findElement(By.xpath("//*[@id='Contact_Tab']/a"));
	 Click(ContactTab,"Contact_Tab");
	 Thread.sleep(3000);
	 
	 WebElement NewBtn= driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
	 Click(NewBtn,"hotlist");
	 WebElement Lastnamebox = driver.findElement(By.id("name_lastcon2"));
	 EnterText(Lastnamebox,"Indian","name_lastcon2");
	 WebElement AccountName = driver.findElement(By.id("con4"));
	 EnterText(AccountName,"GlobalMedia","con4");
	 Thread.sleep(5000);
	 WebElement SaveBtn = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[2]"));
	 Click(SaveBtn,"editPage");
	 Thread.sleep(5000);
	 
 }
 public static void TC_33_RandomScenarios_1() throws InterruptedException {
	 logger=report.startTest("TC_33_RandomScenarios_1");
	 WebElement HomeBtn = driver.findElement(By.linkText("Home"));
	 Click(HomeBtn,"home");
	 Thread.sleep(3000);
	 String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "User is on home page");
		// System.out.println("User is on home page");
		else
			logger.log(LogStatus.FAIL, "home page is not Lunched");
	 
	 WebElement FullName = driver.findElement(By.xpath("//h1[@class='currentStatusUserName'])"));
	 Click(FullName,"name");
	 Thread.sleep(5000);
	 if (FullName.isDisplayed()) {
			System.out.println("Pass: " + FullName + " is  selected");
			FullName.click();
		} else {

			System.out.println("Fail:" + FullName + " is not present.Please chk application");
		}
	 Thread.sleep(3000);
	 String expectedTitle2 = "My Profile ~Salesforce - Developer Edition";
	 String actualTitle2 =driver.getTitle();
	 if (actualTitle2.equalsIgnoreCase(expectedTitle2))
			logger.log(LogStatus.PASS, "User is on myprofile page");
		// System.out.println("User is on home page");
		else
			logger.log(LogStatus.FAIL, "myprofile is not Lunched");
 }
 public static void TC_34_RandomScenarios_2() throws InterruptedException {
	 logger=report.startTest("TC_34_RandomScenarios_2");
	 WebElement HomeBtn = driver.findElement(By.linkText("Home"));
	 Click(HomeBtn,"home");
	 Thread.sleep(3000);
	                                                                                                  
	 String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "User is on home page");
		// System.out.println("User is on home page");
		else
			logger.log(LogStatus.FAIL, "home page is not Lunched");
		// System.out.println("home page is not Lunched");
		
	 
	 WebElement FullName = driver.findElement(By.xpath("//*[@id='mru0052w000001UTkq']/a/img"));
	 Actions action = new Actions(driver);
	 action.moveToElement(FullName).build().perform();
	 Thread.sleep(5000);
	 
	 if (FullName.isDisplayed()) {
			System.out.println("Pass: " + FullName + " is  selected");
			FullName.click();
		} else {

			System.out.println("Fail:" + FullName + " is not present.Please chk application");
		}
	 
	 
	 WebElement Name = driver.findElement(By.xpath("//a[@class='name']"));
	 Click(Name,"name");
	 
    WebElement EditBtn = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
	EditBtn.click();
	Thread.sleep(3000);
	WebElement Contact =driver.findElement(By.xpath("//*[@id='contactTab']/a"));
	VisibleSelected(Contact,"con");
	
	
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contactInfoContentId']")));

    WebElement aboutTab = driver.findElement(By.xpath("//*[@id='aboutTab']/a"));
    Click(aboutTab, "aboutTab");
    WebElement firstName = driver.findElement(By.id("firstName"));
    VisibleSelected(firstName,"con");
	
    SwitchFrame("lastName");
    WebElement Lastnametab =driver.findElement(By.id("lastName"));
    EnterText(Lastnametab,"ABCD","lastName");
    WebElement EditedLastname = driver.findElement(By.id("tailBreadcrumbNode"));
    VisibleSelected(EditedLastname,"tailbread");
    
    WebElement SaveAlltab =driver.findElement(By.id("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
    Click(SaveAlltab,"saveall");
    
    }
public static void TC_35_RandomScenarios_3() throws InterruptedException{
	 logger=report.startTest("TC_35_RandomScenarios_3"); 
	 WebElement Alltab = driver.findElement(By.xpath("//*[@id='AllTab_Tab']/a/img"));
	 Alltab.click();
	 String expectedTitle = "All Tabs ~ Salesforce - Developer Edition";
	 String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "User is on AllTab page");
		// System.out.println("User is on home page");
		else
			logger.log(LogStatus.FAIL, "AllTab  is not Launched");
		
		Thread.sleep(3000);
		
		 WebElement CustomizeMyTabs = driver.findElement(By.xpath("//*[@id='AllTab_Tab']/a/img"));
		 Click(CustomizeMyTabs,"AllTab");
	
		
 }

}