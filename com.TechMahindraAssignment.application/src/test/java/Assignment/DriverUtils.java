package Assignment;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtils {

	public static AndroidDriver<MobileElement> driver = null;
	public static DesiredCapabilities SetDriverCapabilities(Assignment.Enums.DEVICE_TYPE eDeviceType)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (eDeviceType) {
		case REAL:
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "9");
			capabilities.setCapability("deviceName", "ZY3228ZJ9N");
			capabilities.setCapability("appPackage", "com.ebay.mobile");
			capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
			//capabilities.setCapability("unicodeKeyboard", true);
			//capabilities.setCapability("resetKeyboard", true);
			return capabilities;
		case EMULATOR:
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "9");
			capabilities.setCapability("deviceName", "192.168.1.5:5555");
			capabilities.setCapability("appPackage", "com.ebay.mobile");
			capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
			//capabilities.setCapability("unicodeKeyboard", true);
			//capabilities.setCapability("resetKeyboard", true);
			return capabilities;
		default:
			System.out.println("UNIDENTIFIED DEVICE DETECTED");
			return null;

		}
	}
	
	public static AndroidDriver<MobileElement> GetAndroidDriverInstance(Assignment.Enums.DEVICE_TYPE eDeviceType) throws Exception
	{
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), SetDriverCapabilities(eDeviceType));
		return driver;
	}
	
	
	public static void RotateScreen(org.openqa.selenium.ScreenOrientation rotateValue)
	{
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}
	
	public static void ImplicitWait(int seconds) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static AndroidDriver<MobileElement> GetDriverInstance()
	{
		return driver;
	}
	
	public static void KillDriverInstance(AndroidDriver<MobileElement> driver)
	{
		driver.close();
		driver.quit();
	}
}
