package tests;
import org.testng.annotations.Test;
import base.Common;


public class Test2 extends Common{

	@Test
	public void test2method1() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test2method2() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://move.nl/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test2method3() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://mijn.makelaarsland.nl/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test2method4() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.funda.nl/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
}


//ChromeOptions options = new ChromeOptions();
