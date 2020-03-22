import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tekarch_Testing<Depends> 
{
    WebDriver driver;
    
	@BeforeTest
	public  void InitializeDriver() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	

	@Test(priority =1)
	public void LoginTo_Tekarch() throws InterruptedException 
	{
		driver.get(" https://qa01-tekarch-accmanager.web.app/");
		driver.manage().window().maximize();
		/*String expectedTitle= "";
		String actualTitle ="";
		Assert.assertEquals(actualTitle, expectedTitle);*/
		
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("swagatika@ta.com");
		System.out.println("This is user name box");
		Thread.sleep(5000);
		WebElement pwd = driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys("swagatika");
		WebElement Login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		Login.click();
		
	}
	/*@Test(priority = 2)
	public void  Adduser() throws InterruptedException {
		//InitializeDriver();
		//LoginTo_Tekarch();
    WebElement Addusertab = driver.findElement(By.xpath(" //span[contains(text(),'addUsers')]"));
	Addusertab.click();
	WebElement Accountnumber = driver.findElement(By.xpath("//input[@placeholder='Required 8 characters']"));
	Accountnumber.sendKeys("12345589");
	Thread.sleep(5000);
	WebElement Depatnumbox = driver.findElement(By.xpath("//input[@placeholder='Required 1 characters']"));
	Depatnumbox.sendKeys("2");
	WebElement Salarybox = driver.findElement(By.xpath("//input[@placeholder='Required']"));
	Salarybox.sendKeys("20000");
	WebElement Pincode = driver.findElement(By.xpath("//input[@placeholder='Required 8 characters']"));
	Pincode.sendKeys("123011");
	Thread.sleep(5000);
	WebElement submitbtn = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
	submitbtn.click();
	String successMsg = driver.getTitle();
	System.out.println(" success message is" +successMsg);
	String expectedMsg ="Success message-User added Successfully";
	Assert.assertEquals(successMsg, expectedMsg);
	Thread.sleep(7000);
	
	}*/
	@Test
	public void Pagination() throws InterruptedException {
		
		List<WebElement> Accountnames = driver.findElements(By.cssSelector("body > app-root > div > div:nth-child(2) > app-dashboard > div > div:nth-child(3) > p-table > div > div.ui-table-wrapper.ng-star-inserted > table > tbody"));
		List<String> Slno = new ArrayList<String>();
		for(WebElement Accountname : Accountnames) {
			Slno.add(Accountname.getText());
			}
	
        String Nextbtn = driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-dashboard/div/div[2]/p-table/div/p-paginator/div/span/a[1]")).getAttribute("class");
        while(!Nextbtn.contains("disabled")) {
        	driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > app-dashboard > div > div:nth-child(3) > p-table > div > p-paginator > div > span > a.ui-paginator-page.ui-paginator-element.ui-state-default.ui-corner-all.ui-state-active.ng-star-inserted")).click();
        	for(WebElement Accountname : Accountnames) {
    			Slno.add(Accountname.getText());
    			}
        	Nextbtn= driver.findElement(By.xpath("/html/body/app-root/div/div[2]/app-dashboard/div/div[2]/p-table/div/p-paginator/div/span/a[1]")).getAttribute("class");
        	
        }
        for(String data : Slno) {
        	System.out.println("Total number of account "+data);
        }
        Thread.sleep(7000);
        driver.quit();
	}
	
	
	
}
