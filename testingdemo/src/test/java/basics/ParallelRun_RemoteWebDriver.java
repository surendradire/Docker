package basics;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelRun_RemoteWebDriver {
	
	private RemoteWebDriver driver;
	//String hubUrl= "http://localhost:4444";
	String hubUrl= "http://192.168.1.125:4444";
	
    @BeforeMethod
    protected void setup() {
    	ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
    	try {
			driver = new RemoteWebDriver(new URL(hubUrl), options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}   
    }
	
	@Test 
	protected void Test1() throws MalformedURLException, InterruptedException {  //Selenium server is running

		driver.get("https://www.selenium.dev/selenium/docs/api/dotnet/html/M_OpenQA_Selenium_Remote_RemoteWebDriver__ctor.htm");
		Thread.sleep(10000);
	}

	@Test 
	protected void Test2() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.google.com/");
		Thread.sleep(10000);
	}
	
	@Test 
	protected void Test3() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.cricbuzz.com/");
		Thread.sleep(10000);
	}
	
	@Test 
	protected void Test4() throws MalformedURLException, InterruptedException {  

		driver.get("https://en.wikipedia.org/wiki/Natural_environment");
		Thread.sleep(10000);
	}
	
	@Test 
	protected void Test5() throws MalformedURLException, InterruptedException {     
		
		driver.get("https://www.w3schools.com/tags/tag_select.asp");
		Thread.sleep(10000);
	}
	
    @AfterMethod
    protected void killDriver() {
            driver.quit();
        }
    }

