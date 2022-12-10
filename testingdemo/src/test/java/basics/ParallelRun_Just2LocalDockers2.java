package basics;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelRun_Just2LocalDockers2 {
	
	private RemoteWebDriver driver;
	
	String hubUrl_chrome= "http://localhost:4445";
	String hubUrl_edge= "http://localhost:4444";
	String hubUrl_firefox= "http://localhost:4446";
	
    @BeforeMethod
	@Parameters ({"BrowserType"})
    protected void setup(String browsertype, ITestResult result) {
    	
    	ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		if (browsertype.equals("chrome")) {
			System.out.println("Test case : " + result.getMethod().getMethodName() + " is running with browser : "+ browsertype);
			try {
				driver = new RemoteWebDriver(new URL(hubUrl_chrome), options);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
		}
		else if (browsertype.equals("edge")) {
			System.out.println("Test case : " + result.getMethod().getMethodName() + " is running with browser : "+ browsertype);
			
			EdgeOptions op = new EdgeOptions();
			options.setAcceptInsecureCerts(true);
			try {
				driver = new RemoteWebDriver(new URL(hubUrl_edge), op);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
		}
		
		else if (browsertype.equals("firefox")) {
			try {
				driver = new RemoteWebDriver(new URL(hubUrl_firefox), options);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
		}
    }
	
	@Test 
	protected void Test1() throws MalformedURLException, InterruptedException {  
	
		driver.get("https://www.selenium.dev/selenium/docs/api/dotnet/html/M_OpenQA_Selenium_Remote_RemoteWebDriver__ctor.htm");
		//Thread.sleep(10000);
	}

	@Test 
	protected void Test2() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.google.com/");
		//Thread.sleep(10000);
	}
	
	@Test 
	protected void Test3() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.cricbuzz.com/");
		//Thread.sleep(10000);
	}
	
	@Test 
	protected void Test4() throws MalformedURLException, InterruptedException {  

		driver.get("https://en.wikipedia.org/wiki/Natural_environment");
		//Thread.sleep(10000);
	}
	
	@Test 
	protected void Test5() throws MalformedURLException, InterruptedException {     
		
		driver.get("https://www.w3schools.com/tags/tag_select.asp");
		//Thread.sleep(10000);
	}
	
    @AfterMethod
    protected void killDriver() {
            driver.quit();
        }
    }

