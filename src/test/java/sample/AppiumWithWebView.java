package sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumWithWebView {

	static WebDriver driver;


	@ BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANDROID);
		dc.setVersion("12");
		dc.setBrowserName("chrome");
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new RemoteWebDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test 
	public void test() {
		driver.get("https://www.amazon.com/");
		WebElement searchElement = driver.findElement(By.xpath("//input[@id='nav-search-keywords']"));
		searchElement.sendKeys("Iphone 14 pro Max", Keys.ENTER);
	}

}
