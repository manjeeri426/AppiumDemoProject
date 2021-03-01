package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public AppiumDriver driver;
	public HomePage(AppiumDriver driver )
	{
		 this.driver = driver;
	     
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath="//*[@text='Preference']")
	public WebElement Preference;
	
	
	
}
