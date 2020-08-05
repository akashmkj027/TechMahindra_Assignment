package Assignment;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageClass {

	AndroidDriver<MobileElement> driver;
	ActionAndroid actionMobileDriverObj = new ActionAndroid(driver);
	public PageClass(AndroidDriver<MobileElement> Idriver)
	{
			this.driver=Idriver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id="com.ebay.mobile:id/search_box")
	MobileElement searchBox;
	
	@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
	MobileElement searchTextBox;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Add to search query,65-inch lcd tv\"]/parent::android.widget.RelativeLayout/android.widget.TextView")
	MobileElement selectSuggestion;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.ebay.mobile:id/textview_item_title\"]")
	MobileElement selectProduct;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_name")
	MobileElement sSearchedProductName;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_price")
	MobileElement sSearchedProductPrice;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_description")
	MobileElement sSearchedProductDescription;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_name")
	MobileElement sSearchedProductNameBuyOut;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_price")
	MobileElement sSearchedProductPriceBuyOut;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_description")
	MobileElement sSearchedProductDescriptionBuyOut;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Buy It Now\"]")
	MobileElement sBuyNowButton;
	
	//android.widget.Button[@content-desc="Buy It Now"]
	public void TapOnSearchedBox() throws Exception
	{
		actionMobileDriverObj.TapElement(searchBox);
	}

	public void SetValueForSearchTextBox(String sSearchText) throws Exception
	{
		actionMobileDriverObj.SetValueTextBox(searchTextBox, sSearchText);
	}
	
	public void ScrollToProduct(String sProductName) throws Exception
	{
		actionMobileDriverObj.ScrollToElementByText(sProductName);
	}
	
	public void ScrollToBuyNow(String sProductName) throws Exception
	{
		actionMobileDriverObj.ScrollToElementByText("Buy It Now");
	}
	
	public void SelectProduct() throws Exception
	{
		actionMobileDriverObj.TapElement(selectProduct);
	}
	
	public void TapBuyNowButton() throws Exception
	{
		actionMobileDriverObj.TapElement(sBuyNowButton);
	}
	
	public String GetProductNameSearchPage() throws Exception
	{
		return actionMobileDriverObj.GetTextOfElement(sSearchedProductName);
	}
	
	public String GetProductDescriptionSearchPage() throws Exception
	{
		return actionMobileDriverObj.GetTextOfElement(sSearchedProductDescription);
	}
	
	public String GetProductPriceSearchPage() throws Exception
	{
		return actionMobileDriverObj.GetTextOfElement(sSearchedProductPrice);
	}
	
	public String GetProductNameSearchPageBuyNow() throws Exception
	{
		return actionMobileDriverObj.GetTextOfElement(sSearchedProductNameBuyOut);
	}
	
	public String GetProductDescriptionSearchPageBuyNow() throws Exception
	{
		return actionMobileDriverObj.GetTextOfElement(sSearchedProductDescriptionBuyOut);
	}
	
	public String GetProductPriceSearchPageBuyNow() throws Exception
	{
		return actionMobileDriverObj.GetTextOfElement(sSearchedProductPriceBuyOut);
	}
}
