package com.maven.junittesting;
import static org.junit.Assert.assertEquals;

	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Ignore;
	import org.junit.Test;
//	import org.junit.jupiter.api.DisplayName;


	public class JUnitLifeCycle {	
		@Before
		public void beforeTestMethod()
		{
			System.out.println("Before -run before test method");
		}
		@After
		public void afterTestMethod()
		{
			System.out.println("after - run after test method");
		}
		@BeforeClass  // it runs first and execute once
		public static void runOnceBeforeClass()
		{
			System.out.println("Beforeclass- run before test method");
		}
		@AfterClass  // it runs last and execute once
		public static void runOnceAfterClass()
		{
			System.out.println("Afterclass - run after test method");
		}
		@Ignore
		public void ignore()
		{
			System.out.println("Ignore stmt.");
		}
		@Ignore
		@Test(timeout=1000)
		public void testTimeOut()
		{
			System.out.println("test timeout - 1s sec.");
		}
		@Test(timeout=500)
		public void testTimeOut1()
		{
			System.out.println("test timeout - 0.5 sec.");
		}
		@Test(timeout=500)
		public void testTimeOut2()
		{
			System.out.println("test timeoutdefault");
		}
		@Test
//		   @DisplayName("Test Get Area")
		   public void testGetArea() {
		       System.out.println("Area test");
		      Circle c1 = new Circle(1.2);
		      assertEquals(4.5239, c1.getArea(), 0.01);
		      }
	}

