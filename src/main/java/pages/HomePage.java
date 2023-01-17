package pages;


import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static common.CommonActions.*;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView")
	WebElement item ;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]/android.widget.TextView")
	WebElement addToCartElement;
	@FindBy(xpath= "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.TextView")
	WebElement viewCartElement;
	@FindBy(xpath ="//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]") 
	WebElement proceedToChecOutElement ;
	//@FindBy(xpath ="//android.view.ViewGroup[@content-desc='container header']/android.widget.TextView")
	//WebElement loginTextElement; 
	
	public void clickItem() {
		click(item);	
	}
	
	public void  clickAddToNewCart() {
		click(addToCartElement);
	}
	public void clickViewCart() {
		click(viewCartElement);
	}
	public void clickProceedToCheckOut() {
		click(proceedToChecOutElement);
	}
	 //public void assertLoginText() {
	//	 assertGetText(loginTextElement, "Login");
		 
}

