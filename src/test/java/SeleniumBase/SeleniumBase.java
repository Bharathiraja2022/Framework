package SeleniumBase;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase implements SeleniumAPI{
long timeouts=30;
long maxWaitTime=10;
protected RemoteWebDriver driver=null;
WebDriverWait wait=null;

	@Override
	public void setUp(String url) {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
		driver.get(url);
		wait=new WebDriverWait(driver, maxWaitTime);
	}

	@Override
	public void setUp(Browser browserName, String url) {
		switch(browserName)
		{
		
		case CHROME :
			 driver=new ChromeDriver();
			 break;
		case FIREFOX :
			 driver=new FirefoxDriver();

			break;	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
		driver.get(url);
		wait=new WebDriverWait(driver, maxWaitTime);
	}

	@Override
	public void close() {

		driver.close();
	}

	@Override
	public void quit() {

		driver.quit();
	}

	@Override
	public WebElement element(Locators type, String value) {
switch(type)
{
case id :
	return driver.findElement(By.id(value));
case name :
	return driver.findElement(By.name(value));
case classname :
	return driver.findElement(By.className(value));
case linktext :
	return driver.findElement(By.linkText(value));
case partiallinktext :
	return driver.findElement(By.partialLinkText(value));
case tagname :
	return driver.findElement(By.tagName(value));
case cssSelector :
	return driver.findElement(By.cssSelector(value));
case xpath :
	return driver.findElement(By.id(value));
}
		return null;
	}

	@Override
	public void switchTowindow(int i) {
Set<String> windowHandles=driver.getWindowHandles();
ArrayList<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(i));
	}

	@Override
	public void selectValue(WebElement ele, String value) {
		WebElement element=isElementVisible(ele);
		new Select(element).selectByValue(value);

		
	}
	private WebElement isElementVisible(WebElement ele)
	{
		WebElement element=wait.withMessage("element is not clickable").until(ExpectedConditions.elementToBeClickable(ele));
		return element;

	}

	@Override
	public void selectText(WebElement ele, String text) {
		WebElement element=isElementVisible(ele);
		new Select(element).selectByVisibleText(text);
		
	}

	@Override
	public void selectIndex(WebElement ele, int position) {
		WebElement element=isElementVisible(ele);
		new Select(element).selectByIndex(position);
		
	}

	@Override
	public void click(WebElement ele) {
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(ele));
element.click();
		
	}

	@Override
	public void type(WebElement ele, String value) {
WebElement element=wait.until(ExpectedConditions.visibilityOf(ele));
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public void type(WebElement ele, String value,Keys keys) {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele));
				element.click();
				element.clear();
				element.sendKeys(value,keys);
			}
	@Override
	public void appendText(WebElement ele,String testdata) {
		WebElement element=isElementVisible(ele);
		element.sendKeys(testdata);
	}

	@Override
	public String getTitle() {

		return driver.getTitle();
	}

	@Override
	public String getURL() {

		return driver.getCurrentUrl();
	}

	@Override
	public boolean isdisplayed(WebElement ele) {

		return ele.isDisplayed();
	}

	@Override
	public boolean isEnabled() {

		return false;
	}

	@Override
	public boolean isSelected() {
		
		return false;
	}
	
}
