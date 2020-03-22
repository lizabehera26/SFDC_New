package Mar_20;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reusable_xero {

	static ExtentReports report;
	static ExtentTest logger ;
	static WebDriver driver ;
	//Properties obj = new Properties();
	//FileInputStream objfile = new FileInputStream(System.getProperty("user.dir"+"C:\\SFDC_New\\Xero\\Xero_app.properties"));
	
	public static void DriverInitialization(String browser) throws Exception {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("C:\\chromedriver.exe")+("C:\\SFDC_New\\Xero\\Xero_app.properties"));
		
		if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("iexplorer")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.ie.driver",".\\internetexplorer.exe");
			driver = new InternetExplorerDriver();
	}
		else {
			throw new Exception("no browser is set up") ;
		}
		}
	
	public static void OpenUrl(String Url) {
		driver.get(Url);
		driver.manage().window().maximize();
	}
	public static void CloseBrowser() {
		driver.quit();
	}

	public static void CloseReport() {
		report.flush();
	}
	public static void VisibleSelected(WebElement obj,String objName) {
		
		if (obj.isDisplayed()) {
			System.out.println("Pass: " + obj + " is  selected");
			obj.click();
		} else {

			System.out.println("Fail:" + obj + " is not present.Please chk application");
		}
	 
	}

		public static void CreateReport() {
			String fileName = new SimpleDateFormat("'Xero_Report_'YYYYMMddHHmm'.html'").format(new Date());
			String path = "C:\\Xero_Report\\" + fileName;
			report = new ExtentReports(path);
		}


		public static void EnterText(WebElement element, String text, String objName) {
			if (element == null || !element.isDisplayed()) {
				logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
			} else {
				logger.log(LogStatus.INFO, objName + " Textbox is found");
				element.sendKeys(text);
			}
		}
			public static void Click(WebElement element, String objName) {
				if (element == null || !element.isDisplayed()) {
					logger.log(LogStatus.ERROR, objName + " Element is not found.");
				} else {
					logger.log(LogStatus.INFO, objName + " Element is found");
					element.click();
				}
	
		

}
}
