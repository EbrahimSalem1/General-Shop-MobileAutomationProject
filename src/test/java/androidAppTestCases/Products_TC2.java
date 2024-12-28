package androidAppTestCases;

import androidPages.FormPage;
import androidPages.ProductCatalog;
import base.BaseTest;
import ebrahimEngine.managers.JsonManager;
import org.testng.annotations.Test;

public class Products_TC2 extends BaseTest {

    String jsonFilePathForAddToCart = "src/test/resources/TestDataJsonFiles/FormTestData.json";
    JsonManager json = new JsonManager(jsonFilePathForAddToCart);


    @Test
    public void AddTwoProductsToCart() throws InterruptedException {

        // Call FormDataPage
        FormPage formPage1 = formPage;
        formPage1.formFeature(json.getData("userName"));


        // Call ProductPage to add TowProducts to Cart and Go To Cart Products
        ProductCatalog catalog = new ProductCatalog(driver);
        catalog.addFirstProductToCart();
        catalog.addSecondProductToCart();
        catalog.productTitlePage();
        catalog.goToCartPage();

    }
}
