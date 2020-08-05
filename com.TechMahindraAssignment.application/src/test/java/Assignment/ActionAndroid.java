package Assignment;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ActionAndroid {
	
AndroidDriver<MobileElement> driver;
	
	public ActionAndroid(AndroidDriver<MobileElement> Idriver)
	{
			this.driver=Idriver;
	}
	
	public void WaitForElementToBeClickable(MobileElement element, int seconds) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void TouchOnElement(MobileElement element) throws Exception
	{
		if(element.isDisplayed())
			element.click();
		else
		{
			WaitForElementToBeClickable(element, 5);
			element.click();
		}
	}
	
	public Point GetElementLocation(MobileElement element) throws Exception
	{
		Point point = element.getLocation();
		return point;
	}
	
	public void TouchElement(MobileElement element) throws Exception
	{
		AndroidTouchAction touch=new AndroidTouchAction(driver);
		touch.tap(PointOption.point(GetElementLocation(element).getX(), GetElementLocation(element).getY())).perform();
	}
	
	public void ScrollToElementByText(String sText) throws Exception
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + sText + "\"));"));
	}
//	
//	public void ScrollToElement(MobileElement element)
//	{
//		TouchAction action = new TouchAction(driver);
//		action.(element, 10, 100);
//		action.perform();
//	}
	
	public void PressElement(MobileElement element) throws Exception
	{
		AndroidTouchAction touch=new AndroidTouchAction(driver);
		touch.press(PointOption.point(GetElementLocation(element).getX(), GetElementLocation(element).getY())).perform();
	}
	
	public void TapElement(MobileElement element) throws Exception
	{
		AndroidTouchAction touch=new AndroidTouchAction(driver);
		touch.tap(PointOption.point(GetElementLocation(element).getX(), GetElementLocation(element).getY())).perform();
	}
	
	public void LongPressElement(MobileElement element) throws Exception
	{
		AndroidTouchAction touch=new AndroidTouchAction(driver);
		touch.longPress(PointOption.point(GetElementLocation(element).getX(), GetElementLocation(element).getY())).perform();
	}
	
	public String GetTextOfElement(MobileElement element) throws Exception
	{
		if(element.isDisplayed())
			return element.getText();
		else
		{
			WaitForElementVisible(element, 8);
			return element.getText();
		}
	}
	
	public String GetAttributeValueOfElement(MobileElement element, String attributeName) throws Exception
	{
		if(element.isDisplayed())
			 return element.getAttribute(attributeName);
		else
		{
			WaitForElementVisible(element, 8);
			return element.getAttribute(attributeName);
		}
	}
	
	public void WaitForElementVisible(MobileElement element, int seconds) throws Exception
	{
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	
	public String Get64BaseEncodedStringOfImage(String sFilePath) throws Exception
	{
		File file = new File(sFilePath);
		return Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath())); 
	}
	
	public MobileElement FindElementByImage(String s64BaseEncodedString) throws Exception
	{
		return driver.findElement(MobileBy.image(s64BaseEncodedString));
	}
	
	public String GetTextElement(MobileElement element) throws Exception
	{
		return element.getText();
	}
	
	public String GetElementAttributeValue(MobileElement element, String sAttributeName) throws Exception
	{
		return element.getAttribute(sAttributeName);
	}
	
	public void SetValueTextBox(MobileElement element, String sSetValue) throws Exception
	{
		element.sendKeys(sSetValue);
	}

	public void WaitForElementVisible(AndroidElement element, int iSeconds) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, iSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
