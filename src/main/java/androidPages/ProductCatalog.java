package androidPages;

import utilite.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductCatalog extends AndroidActions
{
	AppiumDriver driver;
	WebDriverWait wait;
	private final String needed = "Jordan 6 Rings";
	private final String needed2 = "Air Jordan 9 Retro";


	public ProductCatalog(AppiumDriver driver){
		super((AndroidDriver) driver);
		this.driver = driver;
	}


	By productTitlePage = By.id("com.androidsample.generalstore:id/toolbar_title");
	By cartBtn = By.id("com.androidsample.generalstore:id/appbar_btn_cart");



	public void productTitlePage(){
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.attributeContains(productTitlePage, "text", "Products"));
	}


	public void addFirstProductToCart(){
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + needed + "\"))"));
		int itemCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < itemCount; i+=1) {
			String itemName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (itemName.equalsIgnoreCase(needed)) {
				driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

			}
		}
	}

	public void addSecondProductToCart(){
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + needed2 + "\"))"));
		int itemCount = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < itemCount; i+=1) {
			String itemName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (itemName.equalsIgnoreCase(needed2)) {
				driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

			}
		}
	}

	public CartPage goToCartPage() {
		driver.findElement(cartBtn).click();
		return new CartPage(driver);
	}


	public void productCatalogFeature(){
		addFirstProductToCart();
		addSecondProductToCart();
		productTitlePage();
	}

}