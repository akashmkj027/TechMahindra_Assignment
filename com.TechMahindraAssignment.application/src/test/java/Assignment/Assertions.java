package Assignment;

import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;


public class Assertions {

	public static void AssertString(String sActualString, String sExpectedValue) throws Exception
	{
		Assert.assertTrue(sActualString.equals(sExpectedValue));
	}
	
	public static void AssertSearchAndCheckoutScreenDetails(Map<String, String> mSeachScreenProductData, Map<String, String> mCheckoutScreenProductData)
	{
		if(mSeachScreenProductData.size() == mCheckoutScreenProductData.size())
		{
			for(int i=0; i<mSeachScreenProductData.size(); i++)
			{
				Assert.assertTrue(mSeachScreenProductData.get("productName").equals(mCheckoutScreenProductData.get(mCheckoutScreenProductData.get("productName"))));
				Assert.assertTrue(mSeachScreenProductData.get("productPrice").equals(mCheckoutScreenProductData.get(mCheckoutScreenProductData.get("productPrice"))));
				Assert.assertTrue(mSeachScreenProductData.get("productDescription").equals(mCheckoutScreenProductData.get(mCheckoutScreenProductData.get("productDescription"))));
						
			}
		}
	}
	
	public static void AssertFail(String sMeessage)
	{
		Assert.fail(sMeessage);
	}
	
	
	
	
}
