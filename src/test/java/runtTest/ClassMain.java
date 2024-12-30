package runtTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObject.*;


public class ClassMain {

	static Home homepage;
	WebDriver driver;
	static String url,name;

	@BeforeMethod
	public void beforeClass() throws IOException{
		Properties propiedades = new Properties();
		InputStream entrada = null;
		entrada = new FileInputStream("./data.properties");
		propiedades.load(entrada);
		url = propiedades.getProperty("url");
		name = propiedades.getProperty("name");
		homepage = new Home(driver);
	}

	@Test
	public void test1() throws Exception {
		driver = Home.startdriver();
		homepage.urlAcceso(url, driver);
		homepage.accion(name);
	}

	@AfterMethod
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}
}
