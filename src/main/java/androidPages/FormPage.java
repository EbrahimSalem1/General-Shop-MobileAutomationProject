package androidPages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FormPage {
	
	AppiumDriver driver;

	public FormPage(AppiumDriver driver){
		this.driver = driver;
	}



	By insertNameTextField = By.id("com.androidsample.generalstore:id/nameField");
	By SelectGender = By.id("com.androidsample.generalstore:id/radioMale");
	By countryDropDownList = By.id("com.androidsample.generalstore:id/spinnerCountry");
	By countryTxtSelection = AppiumBy.androidUIAutomator("new UiScrollable ( new UiSelector() ).scrollIntoView( text ( \"Egypt\" ))");
	By clickOnCountrySelected = By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]");
	By clickOnLetsShopBtn = By.id("com.androidsample.generalstore:id/btnLetsShop");


		public void enterTxtNameField(String name){
			driver.findElement(insertNameTextField).sendKeys(name);
		}

		public void clickOnTypeOfGender(){
			driver.findElement(SelectGender).click();
		}

		public String validateNameOfTypeOfGender(){
		return driver.findElement(SelectGender).getText();
	}

		public void clickOnCountryDropDownList(){
			driver.findElement(countryDropDownList).click();
		}

		public void scrollOnCountryTxt(){
			driver.findElement(countryTxtSelection);
		}

		public void clickOnCountryTxtSelected(){
			driver.findElement(clickOnCountrySelected).click();
		}

		public ProductCatalog clickOnLetsShopButton(){
			driver.findElement(clickOnLetsShopBtn).click();
			return new ProductCatalog(driver);
		}


		public FormPage formFeature(String name){
			enterTxtNameField(name);
			clickOnTypeOfGender();
			validateNameOfTypeOfGender();
			clickOnCountryDropDownList();
			scrollOnCountryTxt();
			clickOnCountryTxtSelected();
			clickOnLetsShopButton();
			return this;

		}

}