package utilite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions 
{
	AppiumDriver driver;


	public AndroidActions(AndroidDriver driver)
	{
		this.driver = driver;
	}


	public double getFormattedAmount(String a) {
		return(Double.parseDouble(a.substring(1)));
	}



}















	//	public void scrollToText(String text)
//	{
//
//		driver.findElements(AppiumBy.androidUIAutomator("new UiScrollable ( new UiSelector() ).scrollIntoView( text ( \""+text+"\" ))"));
//
//
//	}

//	public void scrollToEndAction()
//	{
//		boolean canScrollMore;
//		do {
//			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//					"left", 100, "top", 100, "width", 200, "height", 200,
//					"direction", "down",
//					"percent", 3.0
//			));
//		}
//		while(canScrollMore);
//	}


