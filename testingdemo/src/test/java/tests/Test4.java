package tests;
import org.testng.annotations.Test;
import base.Common;

public class Test4 extends Common{

	@Test
	public void test4method1() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://services.india.gov.in/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test4method2() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.seek.com.au/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test4method3() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.naukri.com/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test1method4() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.monster.com/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
}


//ChromeOptions options = new ChromeOptions();
