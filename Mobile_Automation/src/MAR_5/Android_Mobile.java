package MAR_5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Android_Mobile {

	public static void main(String[] args) throws Exception {

   AppiumDriver<WebElement> drivermob ;
   DesiredCapabilities cap =new DesiredCapabilities();
   cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
   cap.setCapability(MobileCapabilityType.DEVICE_NAME, "9999a89");
   cap.setCapability("appPackage","com.miui.calculator");
   //splash screen code
   cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
   //default port of an appium 4723
   
   cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
   drivermob = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
   System.out.println("Calculator app opened");
   
   Thread.sleep(5000);
   
   drivermob.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
   drivermob.findElement(By.id("com.miui.calculator:id/btn_8_s")).click();
   drivermob.findElement(By.id("com.miui.calculator:id/btn_mul_s")).click();
   drivermob.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
   drivermob.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
   System.out.println(drivermob.findElement(By.id("com.miui.calculator:id/result")).getText());
   System.out.println("resut is 546 ");
   drivermob.close();
   
	}

}
