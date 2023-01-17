package ecmmerce;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test; 
import base.BaseClass;

public class InstallationFile_Test extends BaseClass{
	@Test
	public void test() {
		homePage.clickItem();
		homePage.clickAddToNewCart();
		homePage.clickViewCart();
		homePage.clickProceedToCheckOut();
		//homePage.assertLoginText();
		
	}

}
