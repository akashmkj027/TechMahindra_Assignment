package Assignment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BusinessFlow {
	
	public static AndroidDriver<MobileElement> driver = DriverUtils.GetDriverInstance();
	public static void BuyProduct() throws Exception
	{
		PageClass pageClassObj = new PageClass(driver);
		pageClassObj.TapOnSearchedBox();
		DriverUtils.ImplicitWait(2);
		pageClassObj.SetValueForSearchTextBox("65-inch LCD TV");
		DriverUtils.ImplicitWait(2);
		pageClassObj.ScrollToProduct("Mobile TV Cart Floor Stand with Swivel Mount&Wheels for 32-65 inch LED LCD TVs");
		DriverUtils.ImplicitWait(2);
		pageClassObj.SelectProduct();
		DriverUtils.ImplicitWait(2);
	}
	
	public static Map<String,String> GetProductDetailsSearchPage() throws Exception
	{
		PageClass pageClassObj = new PageClass(driver);
		Map<String,String> sProductDetailsSearchPage = new LinkedHashMap<String, String>();
		sProductDetailsSearchPage.put("productName", pageClassObj.GetProductNameSearchPage());
		sProductDetailsSearchPage.put("productPrice", pageClassObj.GetProductPriceSearchPage());
		sProductDetailsSearchPage.put("productDescription", pageClassObj.GetProductDescriptionSearchPage());
		return sProductDetailsSearchPage;
	}
	
	public static Map<String,String> GetProductDetailsBuyNowPage() throws Exception
	{
		PageClass pageClassObj = new PageClass(driver);
		Map<String,String> sProductDetailsBuyNow = new LinkedHashMap<String, String>();
		sProductDetailsBuyNow.put("productName", pageClassObj.GetProductNameSearchPageBuyNow());
		sProductDetailsBuyNow.put("productPrice", pageClassObj.GetProductPriceSearchPageBuyNow());
		sProductDetailsBuyNow.put("productDescription", pageClassObj.GetProductDescriptionSearchPageBuyNow());
		return sProductDetailsBuyNow;
	}
}
