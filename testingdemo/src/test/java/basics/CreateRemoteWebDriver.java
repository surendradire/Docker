package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;


public class CreateRemoteWebDriver  {
	private WebDriver driver;

	@Test
	protected void CreateWebDriverLocally() {    	//webdriver locally

		WebDriverManager.chromedriver().setup(); 	//only needed here
		driver= new ChromeDriver();
		driver.get("https://www.thehindu.com/");

	}

	// run chrome driver - locally
	@Test 
	protected void createRemoteWebDriverFromChromeDriver() throws MalformedURLException {  //Chrome driver running at port 9515 locally
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.acceptInsecureCerts();
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		//WebDriverManager.chromedriver().setup();  //not needed
		//driver= new RemoteWebDriver(new URL("http://localhost:9515"), dc);    //DC and options both works for local remote driver 
		driver= new RemoteWebDriver(new URL("http://localhost:9515"), options); 
		
		driver.get("https://www.google.com/");
	}

	//Run selenium server standalone - locally, Local Selenium grid, can run 4 test cases parallel
	@Test 
	protected void createRemoteWebDriverFromSeleniumServer() throws MalformedURLException {  //Selenium server is running
		//DesiredCapabilities dc= new DesiredCapabilities();
		//dc.acceptInsecureCerts();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);     //works
		driver = new RemoteWebDriver(new URL("http://192.168.1.125:5777"), options);   //works , parameter is option not desired capability.
		driver.get("https://www.google.com/");
	}

}
