package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {

	//public static WebDriver driver;
	public static RemoteWebDriver driver;
	public ChromeOptions chromeoptions;
	public EdgeOptions edgeoptions;
	DesiredCapabilities capabilities;
	//public String huburl = "http://localhost:4444";
	public String huburl = "http://localhost:4444/wd/hub";
	boolean isRemote = false;

	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		setBrowser(browser);
	}

	public void setBrowser(String BrowserType) {

		if (BrowserType.contains("chrome")) {

			if (isRemote) {

				System.out.println("===" + BrowserType + "===");
				capabilities = new DesiredCapabilities();

				chromeoptions = new ChromeOptions();
				chromeoptions.addArguments("incognito");
				chromeoptions.addArguments("start-maximized");
				chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				chromeoptions.setPageLoadTimeout(Duration.ofSeconds(30));
				chromeoptions.setCapability(CapabilityType.BROWSER_NAME, Browser.CHROME);

				try {
					driver = new RemoteWebDriver(new URL(huburl), chromeoptions);
					driver.get("http://localhost:4444/ui");
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}

			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} else if (BrowserType.contains("edge")) {

			if (isRemote) {

				System.out.println("===" + BrowserType + "===");
				capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.EDGE);

				try {
					driver = new RemoteWebDriver(new URL(huburl), edgeoptions);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}

			else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}



}
