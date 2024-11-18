package assessment;

import org.testng.annotations.Test;

import SeleniumBase.Locators;
import SeleniumBase.SeleniumBase;

public class Login extends SeleniumBase{
@Test
	 void login()
	{
		setUp("https://letcode.in/");
		click(element(Locators.linktext,"Log in"));
		type(element(Locators.name,"email"),"koushik350@gmail.com");
		type(element(Locators.name,"password"),"koushik350@gmail.com");
		click(element(Locators.classname,"button.button.is-primary"));
		quit();
		
	}


}
