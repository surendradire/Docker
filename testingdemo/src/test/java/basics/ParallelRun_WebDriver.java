package basics;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

//Note: 1. Does not close all browsers

public class ParallelRun_WebDriver {
	
	private WebDriver driver;
	
    @BeforeMethod
    protected void setup() {
    	WebDriverManager.chromedriver().setup();
    	driver= new ChromeDriver();   
    }
	
	@Test 
	protected void Test1() throws MalformedURLException, InterruptedException {  //Selenium server is running

		driver.get("https://www.selenium.dev/selenium/docs/api/dotnet/html/M_OpenQA_Selenium_Remote_RemoteWebDriver__ctor.htm");
		Thread.sleep(1000);
	}

	@Test 
	protected void Test2() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.google.com/");
		Thread.sleep(5000);
	}
	
	@Test 
	protected void Test3() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.cricbuzz.com/");
		Thread.sleep(1000);
	}
	
	@Test 
	protected void Test4() throws MalformedURLException, InterruptedException {  

		driver.get("https://en.wikipedia.org/wiki/Natural_environment");
		Thread.sleep(2000);
	}
	
	@Test 
	protected void Test5() throws MalformedURLException, InterruptedException {     
		
		driver.get("https://www.w3schools.com/tags/tag_select.asp");
		Thread.sleep(4000);
	}
	
    @AfterMethod
    protected void quitDriver() {
            driver.quit();
        }
    }

