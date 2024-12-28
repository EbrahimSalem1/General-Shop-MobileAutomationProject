package androidPages;

import utilite.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class CartPage extends AndroidActions
{
	AppiumDriver driver;
	public CartPage(AppiumDriver driver)
	{
		super((AndroidDriver) driver);
		this.driver = driver;
		PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);

	}



	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;


	@FindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement displayedAllProduct;

	public boolean AllProductsInCardIsDisplayed(){
		return displayedAllProduct.isDisplayed();
	}

	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	public List<WebElement> getProductList()
	{
		
		return (List<WebElement>) productList;
	}
	
	public double getProductsSum()
	{
		int count = productList.size();
		double totalSum =0;
		for(int i =0; i< count; i++)
		{
			String amountString =productList.get(i).getText();
			Double price = getFormattedAmount(amountString);

			//170.79 + 165.0 = 335.79
			totalSum = totalSum + price;

		}
		return totalSum;
	}

	public Double getTotalAmountDisplayed()
	{
		return getFormattedAmount(totalAmount.getText());
	}

}
