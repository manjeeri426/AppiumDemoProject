package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Pop_up {
public Pop_up(AppiumDriver<MobileElement> driver) {
		// TODO Auto-generated constructor stub
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

@AndroidFindBy(id="android:id/edit")
		public WebElement sendtext;

@AndroidFindBy(id="android:id/button1")
public WebElement closebutton;

}