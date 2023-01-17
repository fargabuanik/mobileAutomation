package sample;

import org.openqa.selenium.Platform;

import utils.Configuration;

public class TestClass {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		String platfom = configuration.getProperty("urlPath");
		System.out.println(platfom);
	
	}

}
