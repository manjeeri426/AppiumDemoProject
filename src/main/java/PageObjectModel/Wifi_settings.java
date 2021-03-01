package PageObjectModel;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Wifi_settings {

	public Wifi_settings(AppiumDriver<MobileElement> driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
	}

	@AndroidFindBy(className="android.widget.RelativeLayout")
	public  java.util.List <WebElement> buttons;
}
