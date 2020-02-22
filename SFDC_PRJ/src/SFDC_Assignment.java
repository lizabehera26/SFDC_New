import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDC_Assignment extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		
		InitializeDriver();
		CreateReport();

		LoginErrormessage();
		
	}
	
	public static void LoginErrormessage() throws InterruptedException {	
	 System.out.println("LoginErrorMessage");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://login.salesforce.com/");
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

	public static void  LoginToSalesForce() {
		System.out.println("LoginToSalesForce");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebElement un = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		un.sendKeys("liza@archtek.com");
		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		pwd.sendKeys("Aarvi121");
		WebElement loginbtn = driver.findElement(By.xpath("/html/body/header/div[2]/div[2]/div/div/nav/div[1]/div/div[3]/div[1]/div[6]/div/a"));
		loginbtn.click();
		WebElement homebtn = driver.findElement(By.xpath("//*[@id=\"oneHeader\"]/div[3]/div/div[2]/div/div/ul[2]/li[2]/a/span"));
		homebtn.click();
		
		
		
	}

}
