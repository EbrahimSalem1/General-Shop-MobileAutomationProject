package androidAppTestCases;

import androidPages.CartPage;
import androidPages.ProductCatalog;
import base.BaseTest;
import ebrahimEngine.managers.JsonManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cart_TC3 extends BaseTest {

    String jsonFilePathForUserNameField = "src/test/resources/TestDataJsonFiles/FormTestData.json";
    JsonManager json = new JsonManager(jsonFilePathForUserNameField);


    @Test
    public void testAssertThatCartProductsIsDisplayedAndThatTheTotalAmountEqualsTheSumOfTwoProductsValue() throws InterruptedException {

        formPage.formFeature(json.getData("userName"));

        // Call Products Page With productCatalogFeature Function
        ProductCatalog productCatalog = new ProductCatalog(driver);
        productCatalog.productCatalogFeature();
        productCatalog.goToCartPage();

        Thread.sleep(5000);


        //Call Cart Page
        CartPage cartPage = new CartPage(driver);
        //Assert That All your Products IsDisplayed In Cart Page
        Assert.assertTrue(cartPage.AllProductsInCardIsDisplayed());
        cartPage.getProductList();


        double totalSum = cartPage.getProductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        //Assert that the total amount equals the sum of two products value
        Assert.assertEquals(totalSum, displayFormattedSum); //170.79 + 165.0 = 335.79

    }

}
