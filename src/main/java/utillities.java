import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class utillities {

	static AndroidDriver driver;
		public utillities(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated constructor stub
			this.driver=driver;
	}

		public static void scrollToText(String containedText)
	    {

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
	    }

	
	

}
