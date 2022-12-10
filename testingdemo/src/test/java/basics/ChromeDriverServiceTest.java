package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChromeDriverServiceTest  {
    private ChromeDriverService chromeDriverService;
    private WebDriver driver;

    @BeforeTest
    protected void startService() {
        if (chromeDriverService == null) {
            try {
                final String driverLocation = "src/main/resources/chromedriver.exe";  //Must need driver executable
                System.setProperty("webdriver.chrome.driver", driverLocation);
                
                chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(driverLocation))
                        .usingAnyFreePort()
                        .build();
                chromeDriverService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    protected void stopService() {
        if (chromeDriverService != null && chromeDriverService.isRunning()) {
            chromeDriverService.stop();
            //driver.quit();
        }
    }

    @Test
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        
        //ChromeDriver driver = new ChromeDriver(chromeDriverService,options);  
        driver = new ChromeDriver(chromeDriverService);
        driver.get("https://www.cricbuzz.com/");
    }
    
	
	@Test
	protected void CreateRemoteWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--start-maximized");

		driver = new RemoteWebDriver(chromeDriverService.getUrl(), new ChromeOptions());
		driver.get("https://www.selenium.dev/selenium/docs/api/dotnet/html/M_OpenQA_Selenium_Remote_RemoteWebDriver__ctor_2.htm");
	}
}
