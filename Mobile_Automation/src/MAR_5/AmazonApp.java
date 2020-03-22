package MAR_5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonApp {

	public static void main(String[] args) throws Throwable {
		 AndroidDriver<MobileElement> drivermob ;
		   DesiredCapabilities cap =new DesiredCapabilities();
		   cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		   cap.setCapability(MobileCapabilityType.DEVICE_NAME, "9999a89");
		   cap.setCapability("appPackage","com.amazon.mshop.android.shopping");
		   //splash screen code
		   cap.setCapability("appActivity", "com.amazon.mShop.home.web.MShopWebGatewayActivity");
		   //default port of an appium 4723
		   
		   //cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		   drivermob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		   System.out.println("Amazon App opened");
		   MobileElement searchbtn = drivermob.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_search_icon"));
		   searchbtn.click();
		   MobileElement searchbox = drivermob.findElement(By.name("What are you looking for?"));
		   searchbox.sendKeys("books");
		   
		   searchbox.click();
		   
		   
		   
		   

	}

}
