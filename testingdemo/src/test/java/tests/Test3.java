package tests;
import org.testng.annotations.Test;
import base.Common;


public class Test3 extends Common{

	@Test
	public void test3method1() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://retail.onlinesbi.sbi/retail/login.htm");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test3method2() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test3method3() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.icicibank.com/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test3method4() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.passportindia.gov.in");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
}


//ChromeOptions options = new ChromeOptions();
