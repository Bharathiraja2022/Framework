package utils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends report{
@BeforeTest
	void setData()
	{
		desc="first test";
		author="bharathi";
		category="smoke";
	}
	@Test
	void myTest()
	{
		System.out.println("Test begins");
		step("pass","some description");
		System.out.println("Test ends");
	}
}
