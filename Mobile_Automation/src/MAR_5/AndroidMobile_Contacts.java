package MAR_5;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidMobile_Contacts {

	public static void main(String[] args) throws Exception {
		 AndroidDriver<MobileElement> drivermob ;
		   DesiredCapabilities cap =new DesiredCapabilities();
		   cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		   cap.setCapability(MobileCapabilityType.DEVICE_NAME, "9999a89");
		   cap.setCapability("appPackage","com.android.contacts");
		   //splash screen code
		   cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		   //default port of an appium 4723
		   
		   //cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		   drivermob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		  // System.out.println("Contacts app opened");	
		   //drivermob.switchTo().frame(1);
		   
		   String nameList = "android:id/list";
		   String nameContains = "Home";
		   MobileElement scroll = drivermob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+nameList+"\")).scrollIntoView(new UiSelector().text(\""+nameContains+"\"))");
		   scroll.click();
		   Thread.sleep(7000);
		   
		   TouchAction swp = new TouchAction (drivermob);
		   swp.press(PointOption.point(395,1048))
		   .waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
		   .moveTo(PointOption.point(421,1025)).release().perform();
		   //drivermob.closeApp();
		   
		   
		   
		   
	}

}
