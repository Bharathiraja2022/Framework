package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.Test;

import SeleniumBase.SeleniumBase;

public class HomePage extends SeleniumBase{

	
	public HomePage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickSignIn()
	{
		WebElement signIn=driver.findElement(By.linkText("Sign in"));
		click(signIn);
	}
	
	
	
	
	
	
	
}
