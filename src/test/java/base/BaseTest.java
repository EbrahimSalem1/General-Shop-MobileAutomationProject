package base;

import androidPages.FormPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest 
{
	public AppiumDriverLocalService service;
	public AppiumDriver driver ;
	public FormPage formPage;


	@BeforeClass(alwaysRun=true)
   public  void startService() throws IOException{

	   service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Compu City//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		        service.start();


				UiAutomator2Options options =new UiAutomator2Options();
			    options.setPlatformName("Android");
			    options.setAutomationName("UiAutomator2");
			    options.setPlatformVersion("8.1.0");
				options.setDeviceName("0326325897004272");
				options.setApp("C:\\Users\\Compu City\\IdeaProjects\\GeneralShopMobileAutomationApp\\src\\main\\resources\\apps\\General-Store.apk");

				URL url = new URL("http://127.0.0.1:4723");
				driver = new AndroidDriver(url, options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				formPage = new FormPage(driver);

//			     driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options );
//				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//				 formPage = new FormPage(driver);
   }

   
   public double GetFormattedString(String Amount)
   {
		double Price = Double.parseDouble(Amount.substring(1));
		return Price;
   }


	@AfterClass(alwaysRun=true)
   public void stopService()
   {
	   driver.quit();
	   service.stop();
	  
   }
}
