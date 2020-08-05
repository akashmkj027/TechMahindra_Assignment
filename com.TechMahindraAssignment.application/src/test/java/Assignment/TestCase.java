package Assignment;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class TestCase {

	public static AndroidDriver<MobileElement> driver = null;

	@BeforeMethod
	public void InitiateDriver() throws Exception
	{
		driver = DriverUtils.GetAndroidDriverInstance(Assignment.Enums.DEVICE_TYPE.EMULATOR);
		DriverUtils.RotateScreen(ScreenOrientation.PORTRAIT);
	}

	@Test(testName ="Assertion-1", description="Validate Search Page and Buying Page Data")
	public void Assertion1()
	{
		try {
			BusinessFlow.BuyProduct();
			Assertions.AssertSearchAndCheckoutScreenDetails(BusinessFlow.GetProductDetailsSearchPage(), BusinessFlow.GetProductDetailsBuyNowPage());
		}
		catch(Exception ex)
		{
			System.out.println("Exception Caused due to: "+ ex.getMessage());
			ex.printStackTrace();
			Assertions.AssertFail("Assertion failed due to exception: " + ex.getStackTrace());
		}
	}
	
	@AfterMethod
	public void TearDown()
	{
		DriverUtils.KillDriverInstance(driver);
	}
	
}
