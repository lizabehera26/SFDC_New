import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tekarch_Testing {
    WebDriver driver;
	@BeforeTest
	public  void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void LoginTo_Tekarch() {
		
		driver.get(" https://qa01-tekarch-accmanager.web.app/");
		driver.manage().window().maximize();
		String expectedTitle= "";
		String actualTitle ="";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		WebElement username = driver.findElement((By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")));
		username.sendKeys("swagatika@ta.com");
		
	}
}
