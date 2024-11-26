package Generic.AssertUtility;

import org.testng.Assert;

public class AssertUtility {
	public void hardAssertEquals(String actText,String expText) {
		 Assert.assertEquals(actText, expText);
	}
	
	public void hardAssertBoolean(Boolean res) {
		Assert.assertEquals(res,true);
	}
	
	public void hardAssertContains(String actText,String expText) {
		boolean res=actText.contains(expText);
		 Assert.assertTrue(res);
	}
}
