package TestCase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SeleniumBase.Browser;
import SeleniumBase.Locators;
import SeleniumBase.SeleniumBase;

public class GoogleTest extends SeleniumBase{
@Test
	void searchLetCode()
	{
		setUp(Browser.CHROME,"https://www.google.com/");
		WebElement search=element(Locators.name,"q");
		type(search,"letcode with koushik",Keys.ENTER);
		quit();
	}
}
