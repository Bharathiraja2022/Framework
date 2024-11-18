package SeleniumBase;

import org.openqa.selenium.WebElement;

public interface SeleniumAPI {
	/**
	 * This will launch the chrome browser with the given URL
	 * @param url
	 */
void setUp(String url);
/**
 * This will launch the chrome browser with the given URL
 * 
 * @param browserName
 * @param url
 */
void setUp(Browser browserName,String url);

void close();
void quit();
/**
 * This method is used to find any webelement with in the page
 * @param type - element type eg- id,name or linkText
 * @param value -element value
 * @return webelement
 */
WebElement element(Locators type,String value);

void switchTowindow(int i);

void selectValue(WebElement ele,String value);

void selectText(WebElement ele,String text);

void selectIndex(WebElement ele,int position);

void click(WebElement ele);

void type(WebElement ele,String value);

void appendText(WebElement ele,String testdata);

String getTitle();

String getURL();

boolean isdisplayed(WebElement ele);
boolean isEnabled();
boolean isSelected();


}
