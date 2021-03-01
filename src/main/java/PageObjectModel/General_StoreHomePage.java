package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class General_StoreHomePage {
	public AppiumDriver driver;
	public General_StoreHomePage (AppiumDriver driver )
	{
		 this.driver = driver;
	     
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@text='Australia']")
	public WebElement countryselection;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
public  WebElement name;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	 public WebElement checkbox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement button;
	
}
