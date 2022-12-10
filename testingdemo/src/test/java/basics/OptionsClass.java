package basics;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


//      NOTE: ChromeDriver = only takes ChromeOptions or ChromeDriverService parameters, Alternative desiredCapabilities merged with options
//      RemoteWebDriver - takes desiredCapabilities, URI with options

public class OptionsClass {


	WebDriver driver;

	@Test
	public void test_chromeoptions_Only() {  	

		System.out.println("start ---test1");

		WebDriverManager.chromedriver().setup();
		ChromeOptions op =new ChromeOptions();

		op.addArguments("start-maximized");
		op.addArguments("--incognito");

		driver= new ChromeDriver(op);        //local - chrome options

		driver.get("https://cacert.com/");
		System.out.println("end ---test1");

	}

	@Test
	public void test_desired_capability_Only_RemoteWebDriver() {

		System.out.println("start ---test_desired_capability_Only_RemoteWebDriver");

		WebDriverManager.chromedriver().setup();

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);

		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--start-maximized"); 

		dc.merge(options);						
		
		//driver= new ChromeDriver(dc);          			// Not applicable for chrome driver
		//driver= new ChromeDriver(new ChromeOptions());    // Works

		//driver= new RemoteWebDriver(dc);        			//local - desired capabilities] provided selenium server running at port 4444, This constructor defaults proxy to http://127.0.0.1:4444/wd/hub
		driver= new RemoteWebDriver(new ChromeOptions());	//works
		driver.get("https://cacert.com/");
		System.out.println("end ---test_desired_capability_Only_RemoteWebDriver");

	}

	@Test
	public void test_Options_With_desiredcapability_Only_ChromeWebDriver() {

		System.out.println("start ---test_Options_With_desiredcapability_Only_ChromeWebDriver");

		WebDriverManager.chromedriver().setup();

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
		dc.setPlatform(Platform.WIN10);
		dc.setCapability("user", "user123");

		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--start-maximized"); 

		options.merge(dc);

		driver= new ChromeDriver(options);
		driver.get("https://cacert.com/");

		String str= (String) dc.getCapability("user");
		System.out.println(str);
		System.out.println(dc.getPlatformName());


		System.out.println("end ---test_Options_With_desiredcapability_Only_ChromeWebDriver");

	}

}
