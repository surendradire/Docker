package basics;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelRun_Just2LocalDockers1 {
	
	private RemoteWebDriver driver;
	private DesiredCapabilities dc;
	ChromeOptions coptions;
	EdgeOptions eoptions;
	FirefoxOptions foptions;
	String browsertype;
	
	String hubUrl_chrome= "http://localhost:4444";
	//String hubUrl_chrome= "http://192.168.1.125:1234";
		
	//String hubUrl_edge= "http://68.219.88.148:12345/";
	String hubUrl_edge= "http://localhost:4444";
	String hubUrl_firefox= "http://localhost:4447";
	
   /* @BeforeMethod
	@Parameters ({"BrowserType"})
    protected void setup(String browsertype, ITestResult result) { */
    	
    @BeforeMethod
    protected void setup() {
    	browsertype="edge";
    	
		if (browsertype.equals("chrome")) {
	    	dc= new DesiredCapabilities();
	    	coptions = new ChromeOptions();
			coptions.setAcceptInsecureCerts(true);
			
			//System.out.println("Test case : " + result.getMethod().getMethodName() + " is running with browser : "+ browsertype);
			try {
				driver = new RemoteWebDriver(new URL(hubUrl_chrome), coptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
		}
		else if (browsertype.equals("edge")) {
	    	dc= new DesiredCapabilities();
	    	eoptions = new EdgeOptions();
			eoptions.setAcceptInsecureCerts(true);
			
			//System.out.println("Test case : " + result.getMethod().getMethodName() + " is running with browser : "+ browsertype);
			try {
				driver = new RemoteWebDriver(new URL(hubUrl_edge), eoptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
		}
		
		else if (browsertype.equals("firefox")) {
	    	dc= new DesiredCapabilities();
	    	foptions = new FirefoxOptions();
			foptions.setAcceptInsecureCerts(true);
			
			try {
				driver = new RemoteWebDriver(new URL(hubUrl_firefox), foptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
		}
    }
	
	@Test 
	protected void Test1() throws MalformedURLException, InterruptedException {  
	
		driver.get("https://www.selenium.dev/selenium/docs/api/dotnet/html/M_OpenQA_Selenium_Remote_RemoteWebDriver__ctor.htm");
		Thread.sleep(10000);
		System.out.println("Browser-Name: "+ driver.getCapabilities().getBrowserName());
		System.out.println("Browser-Version : "+ driver.getCapabilities().getBrowserVersion());
	}

	@Test 
	protected void Test2() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.google.com/");
		System.out.println("Browser-Name: "+ driver.getCapabilities().getBrowserName());
		System.out.println("Browser-Version : "+ driver.getCapabilities().getBrowserVersion());
		//Thread.sleep(10000);
	}
	
	@Test 
	protected void Test3() throws MalformedURLException, InterruptedException {  

		driver.get("https://www.cricbuzz.com/");
		System.out.println("Browser-Name: "+ driver.getCapabilities().getBrowserName());
		System.out.println("Browser-Version : "+ driver.getCapabilities().getBrowserVersion());
		//Thread.sleep(10000);
	}
	
	@Test 
	protected void Test4() throws MalformedURLException, InterruptedException {  

		driver.get("https://en.wikipedia.org/wiki/Natural_environment");
		System.out.println("Browser-Name: "+ driver.getCapabilities().getBrowserName());
		System.out.println("Browser-Version : "+ driver.getCapabilities().getBrowserVersion());
		//Thread.sleep(10000);
	}
	
	@Test 
	protected void Test5() throws MalformedURLException, InterruptedException {     
		
		driver.get("https://www.w3schools.com/tags/tag_select.asp");
		System.out.println("Browser-Name: "+ driver.getCapabilities().getBrowserName());
		System.out.println("Browser-Version : "+ driver.getCapabilities().getBrowserVersion());
		//Thread.sleep(10000);
	}
	
    @AfterMethod
    protected void killDriver() {
            driver.quit();
        }
    }

