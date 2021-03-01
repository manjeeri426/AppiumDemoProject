import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
                                         // TODO Auto-generated method stub
		static AndroidDriver<MobileElement> driver;
		public static AndroidDriver<MobileElement> main(String[] driver) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
		{
		FileInputStream fis=new FileInputStream("E:\\eclipse workspace\\AppiumTestingMaven\\src\\main\\java\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		prop.get("GeneralStoreApp_Package");
		prop.get("GeneralStoreApp_Activity");
		
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability("devicename",prop.get("Device_Name"));
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
		return driver;
	}

}
}
