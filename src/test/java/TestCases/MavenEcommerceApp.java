package TestCases;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
public class MavenEcommerceApp {
	static AndroidDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	
	@Test
	public void startserver()
	{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	@Test
	   public void totalValidation() throws InterruptedException, IOException
	    {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		//prop.get("Device_Name");
		String device_name=System.getProperty("deviceName");
		
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability("devicename",device_name);
		cap.setCapability("udid", "60cda8f17d29");
		cap.setCapability("platformName","android");
		cap.setCapability("platformVersion"," 8.1.0");
		cap.setCapability("appPackage",	prop.get("GeneralStoreApp_Package"));
	    cap.setCapability("appActivity",prop.get("GeneralStoreApp_Activity"));
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT ,"50");
		cap.setCapability("adbExecTimeout",20000 );
		
		//cap.setCapability("autoGrantPermissions","true" );
		//cap.setCapability("noReset", "false");
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,cap);
	
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	System.out.println("app started....");
	
	
	scrollToText("Australia");
//utillities u=new utillities(driver);
//u.scrollToText("Australia");
	driver.findElement(By.xpath("//*[@text='Australia']")).click();

	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TJ");

	driver.hideKeyboard();

	driver.findElement(By.xpath("//*[@text='Female']")).click();

	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	
	String productname="Nike SFB Jungle";
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + productname + "\").instance(0))"));

	// product list with prices
	java.util.List<MobileElement> lists= driver.findElementsByXPath("//android.widget.TextView");

     for(MobileElement e:lists)
	  {
	System.out.println(e.getAttribute("text"));
	  }
     
 int count=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
  System.out.println("count is--------"+ count);
  driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
  driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
  
  Thread.sleep(1000);
 
  driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
 
Thread.sleep(7000);
 
// validation
 int countprice=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
 System.out.println("count is----"+ countprice);
 
 double sum=0;
     for(int i=0;i<countprice;i++)
     {
	String price=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
	double newprices= ConvertStringToDouble(price);
	System.out.println("new prices----"+ newprices);
	sum=sum+newprices;
	System.out.println("sum of prices----"+ sum);
     }

 System.out.println("sum of prices----"+ sum);
 
 String total=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
 double newtotal=ConvertStringToDouble(total);
 
 System.out.println("total is----"+ newtotal);
 Assert.assertEquals(sum,229.90);

 service.stop();
} // totalValidation method closed
	
	public static double  ConvertStringToDouble(String price)
	{
	// TODO Auto-generated method stub
	String price1=price.substring(1);
	double newprice=Double.parseDouble(price1);
	System.out.println("new price are------"+ newprice);
	return newprice;
	}
	public static void scrollToText(String containedText)
    {

	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
    }
	
	public static void getScreenshot(String name) throws IOException {
		// TODO Auto-generated method stub
		
			File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(image, new File("E:\\eclipse workspace\\AppiumTestingMaven\\ScreenshotsFailTestCase\\defectscreen.png"));
			FileUtils.copyFile(image,new File(System.getProperty("user.dir")+"\\"+name+".png"));
			System.out.println("Failed test case is " + name);
		}
	}









		
