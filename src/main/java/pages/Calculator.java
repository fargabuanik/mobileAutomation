package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reporting.Logs;

public class Calculator {

	WebDriver driver;
	public Calculator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.google.android.calculator:id/op_add")
	WebElement addElement;
	@FindBy(id ="com.google.android.calculator:id/eq")
	WebElement equalElement; 
	@FindBy(id="com.google.android.calculator:id/result_final")
	WebElement resultElement;

	public int getSumTotal(int...arr) throws InterruptedException {
		for(int i : arr) {
			if(i < 10) {
				WebElement digit = driver.findElement(By.id("com.google.android.calculator:id/digit_"+i));
				digit.click();
				addElement.click();
			}else if(i > 9){
				String temp = String.valueOf(i);
				System.out.println(temp);
				for(char st : temp.toCharArray()) {
					WebElement digit = driver.findElement(By.id("com.google.android.calculator:id/digit_"+st));
					digit.click();
				}
				addElement.click();
			}		
		}		

		equalElement.click();
		String resultValue = resultElement.getText();
		Logs.log("Result is :" + resultValue);
		return Integer.parseInt(resultValue);
	}
}
