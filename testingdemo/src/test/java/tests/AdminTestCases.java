package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminTestCases {

	@BeforeTest
	  public void BeforeTest() throws MalformedURLException {
		 System.out.println("start ---BeforeTest");
		 
		 	//WebDriverManager.edgedriver().setup();
		 
		    // ChromeOptions options = new ChromeOptions();

		     DesiredCapabilities dc = new DesiredCapabilities();
		     dc.setBrowserName("chrome");
					
			//URL url= new URL("http://localhost:4444/");
			URL url= new URL("http://localhost:7901");
			//URL url= new URL("http://localhost:7901/wd/hub");
			
			RemoteWebDriver driver= new RemoteWebDriver(url,dc);
			
		     driver.get("https://www.w3schools.com/java/default.asp");
		     
		     System.out.println("************** tilte is ***********"+ driver.getTitle());
		     
		     System.out.println("end ---BeforeTest");
		
		 
	  }
	
	 @Test
	  public void test1() {
		 System.out.println("start ---test1");
		 
	     System.out.println("end ---test1");
		 
	  }
	 
	 @Test
	  public void test2() {
		 System.out.println("start ---test2");
		 
		 System.out.println("end ---test2");
		 
	  }
}
