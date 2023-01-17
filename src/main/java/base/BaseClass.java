package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.Calculator;
import pages.HomePage;
import utils.Configuration;

public class BaseClass {

	public static WebDriver driver;
	public Configuration configuration = new Configuration();

	protected HomePage homePage;
	protected Calculator calcultor;

	@Parameters("automationType")
	@BeforeMethod
	public void setUp(String automationType) {
		DesiredCapabilities dc;
		System.out.println(automationType);
		switch (automationType) {
		case "installedApp":
			dc = capsForInstalledApp();
			break;
		case "installationFile":
			dc = capsForInstallationFile();
			break;
		case "moblieBrowser":
			dc = capsForWebView();
			break;
		default:
			dc = capsForWebView();
			break;
		}
		try {
			URL url = new URL(configuration.getProperty("urlpath"));
			driver = new RemoteWebDriver(url, dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		initClasses();

	}

	public DesiredCapabilities capsForInstalledApp() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platfom = configuration.getProperty("devicePlatform");
		System.out.println(platfom);
		if(platfom.trim().equalsIgnoreCase("android")) {
			dc.setPlatform(Platform.ANDROID);
			dc.setCapability("appActivity", "com.android.calculator2.Calculator");
			dc.setCapability("appPackage", "com.google.android.calculator");
		} else if (platfom.equalsIgnoreCase("ios")) {
			dc.setPlatform(Platform.IOS);
		}
		dc.setVersion(configuration.getProperty("deviceVersion"));
		return dc;

	}

	public DesiredCapabilities capsForInstallationFile() {
		System.out.println("Cap for Installed App");
		DesiredCapabilities dc = new DesiredCapabilities();
		String platfom = configuration.getProperty("devicePlatform");
		if (platfom.equalsIgnoreCase("Android")) {
			dc.setPlatform(Platform.ANDROID);
			dc.setCapability("app", new File(configuration.getProperty("appLocation")).getAbsolutePath());
		} else if (platfom.equals("ios")) {
			dc.setPlatform(Platform.IOS);
			dc.setCapability("app", new File(configuration.getProperty("appLocation")).getAbsolutePath());
		}

		dc.setVersion(configuration.getProperty("deviceVersion"));
		return dc;
	}

	public DesiredCapabilities capsForWebView() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platfom = configuration.getProperty("devicePlatform");
		if (platfom.equalsIgnoreCase("Android ")) {
			dc.setPlatform(Platform.ANDROID);
		} else if (platfom.equals("ios")) {
			dc.setPlatform(Platform.IOS);
		}
		dc.setVersion(configuration.getProperty("deviceVersion"));
		dc.setBrowserName(configuration.getProperty("browserName"));
		return dc;

	}

	public void initClasses() {
		homePage = new HomePage(driver);
		calcultor = new Calculator(driver);
	}

	@AfterMethod
	public void quittingDriver() {
		driver.quit();

	}
}
