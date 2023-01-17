package common;

import static org.testng.Assert.assertEquals;    
import static org.testng.Assert.fail;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import reporting.Logs;

public class CommonActions {
	 
	public static void input(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Logs.log(element +":has been passed to --->" + element);
		} catch ( NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log("Element not found--->" + element ); 
			fail();
		} 
	} 
	public static void click(WebElement element) {
		try {

			element.click();
			Logs.log(element +":has been click --->" + element);
		} catch ( NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log("Element not found--->" + element ); 
			fail();
		} 
	}

	public static boolean isPresent(WebElement element) {
		try {
			element.getAccessibleName();
			Logs.log(element.getAccessibleName()+ "<--- has been present");
			return false;
		}catch ( NoSuchElementException | NullPointerException e) {
			Logs.log("ELEMENT NOT FOUND--->" + element);
			return false;
		}
	}
	public static void assertGetText(WebElement element, String expcted) {
		if (element != null) {
			Logs.log(element +"<-----has Text+"+ element.getText()); 
			assertEquals(element.getText(), expcted);
		}else {
			Logs.log("ELEMENT NOT FOUND -->" + element ); 
			fail();
		}

	}
}