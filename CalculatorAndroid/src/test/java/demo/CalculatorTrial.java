package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class CalculatorTrial {
	public static void main(String[] args) throws  InterruptedException, MalformedURLException {
		
		DesiredCapabilities dsr =new DesiredCapabilities();
		dsr.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dsr.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dsr.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dsr.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		dsr.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dsr.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement>driver=new AndroidDriver<WebElement>(url,dsr);
		Thread.sleep(5000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_08")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_07")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		String result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();
	     System.out.println(result);
	     if(result.equalsIgnoreCase("15")) {
	    	 Assert.assertTrue(true);
	    	 System.out.println("Test passed");
	     }
	     else {
	    	 System.out.println("test failed");
	    	 Assert.assertTrue(false);
	     }
	}

}
