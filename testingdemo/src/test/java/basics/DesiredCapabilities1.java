package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DesiredCapabilities1 {
	private WebDriver driver;

	@Test
	public void test_chromeoptions_Only() throws MalformedURLException {

		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capabilities = new DesiredCapabilities();


		capabilities.setCapability("requireWindowFocus", true);
		// capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "77.0");
		capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one
		capabilities.setCapability("build", "R.1.2.3");
		capabilities.setCapability("name", "Regression");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		capabilities.setCapability("selenium_version","4.0.0-alpha-2");
		capabilities.setCapability("timezone","UTC+05:30");
		capabilities.setCapability("geoLocation","IN");
		capabilities.setCapability("chrome.driver","78.0");
		try {
			// driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
			driver = new RemoteWebDriver(new URL("http://192.168.1.125:4444"), capabilities);
			//driver = new ChromeDriver();
			driver.get("https://www.lambdatest.com/blog/desired-capabilities-in-selenium-testing/");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}