package tests;
import org.testng.annotations.Test;
import base.Common;

public class Test1 extends Common {

	@Test
	public void test1method1() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.linkedin.com/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test1method2() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test1method3() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.cricbuzz.com/");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
	
	@Test
	public void test1method4() {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		driver.get("https://www.w3schools.com/java/default.asp");
		System.out.println("************** Tilte is ***********" + driver.getTitle());
	}
}
