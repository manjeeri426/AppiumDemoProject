package TestCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.Property;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import PageObjectModel.HomePage;
import PageObjectModel.Pop_up;
import PageObjectModel.Pref_dependencies;
import PageObjectModel.Preference;
import PageObjectModel.Wifi_settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import resources.TestData;

public class PopUpBox2 {
	static AppiumDriver<MobileElement> driver;
	
	public static AppiumDriverLocalService service;
	
	
	@Test
	public void startserver()
	{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void ApiDemos(String input) throws InterruptedException, MalformedURLException, FileNotFoundException
	{
	
		DesiredCapabilities cap= new DesiredCapabilities();
	
	cap.setCapability("devicename","Android");
	cap.setCapability("udid", "60cda8f17d29");
	cap.setCapability("platformName","android");
	cap.setCapability("platformVersion"," 8.1.0");
	cap.setCapability("appPackage","io.appium.android.apis");
    cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT ,"50");
	cap.setCapability("adbExecTimeout",20000 );
	
	//cap.setCapability("autoGrantPermissions","true" );
	//cap.setCapability("noReset", "false");
	URL url =new URL("http://127.0.0.1:4723/wd/hub");
	driver =new AppiumDriver<MobileElement>(url,cap);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	System.out.println("app started....");
	
	//driver.findElementByXPath("//*[@text='Preference']").click();
HomePage p=new HomePage(driver);
p.Preference.click();
	
//driver.findElementByXPath("//*[@text='3. Preference dependencies']").click();
Preference p1=new Preference(driver);
p1.PreferenceDependcies.click();
	
//driver.findElementById("android:id/checkbox").click();
Pref_dependencies p2=new Pref_dependencies(driver);
p2.checkbox.click();
	Thread.sleep(2000);

//driver.findElementsByClassName("android.widget.RelativeLayout").get(1).click();
	Wifi_settings s=new Wifi_settings(driver);
	s.buttons.get(1).click();
	
//driver.findElementById("android:id/edit").sendKeys("hgh");

Pop_up u=new Pop_up(driver);

u.sendtext.sendKeys(input);

//driver.findElementById("android:id/button1").click();
u.closebutton.click();

service.stop();	
}
	
	
	public static void getScreenshot(String name) throws IOException
	{
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(image, new File("E:\\eclipse workspace\\AppiumTestingMaven\\ScreenshotsFailTestCase\\defectscreen.png"));
		FileUtils.copyFile(image,new File(System.getProperty("user.dir")+"\\"+name+".png"));
	}

}
