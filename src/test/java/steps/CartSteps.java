package steps;

import androidPages.CartPage;
import androidPages.FormPage;
import androidPages.ProductCatalog;
import base.BaseTest;
import ebrahimEngine.managers.JsonManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps extends BaseTest {
    AppiumDriver driver;
    String jsonFilePathForAddToCart = "src/test/resources/TestDataJsonFiles/FormTestData.json";
    JsonManager json = new JsonManager(jsonFilePathForAddToCart);
    FormPage formpage = new FormPage(driver);
    ProductCatalog catalog = new ProductCatalog(driver);
    CartPage cartPage = new CartPage(driver);



    @Given("I open the General Store app on an Android device")
    public void iOpenTheGeneralStoreAppOnAnAndroidDevice() {
        formpage = new FormPage(driver);
    }

    @When("I select {string} from the dropdown list")
    public void iSelectFromTheDropdownList(String name) {
        formpage.clickOnCountryDropDownList();
        formpage.scrollOnCountryTxt();
        formpage.clickOnCountryTxtSelected();
    }

    @And("I enter {string} in the text field")
    public void iEnterInTheTextField(String arg0) {
        formpage.enterTxtNameField(json.getData("userName"));
    }

    @And("I select {string} as my gender and Assert it")
    public void iSelectAsMyGenderAndAssertIt(String arg0) {
        formpage.clickOnTypeOfGender();
        Assert.assertTrue(formpage.validateNameOfTypeOfGender().contains(json.getData("Gender")));
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String arg0) {
        formpage.clickOnLetsShopButton();
    }

    @And("I add two products to the cart")
    public void iAddTwoProductsToTheCart() {
        catalog.addFirstProductToCart();
        catalog.addSecondProductToCart();
        catalog.productTitlePage();
    }
    @Then("I navigate to the cart screen")
    public void iNavigateToTheCartScreen() throws InterruptedException {
        catalog.goToCartPage();
        Thread.sleep(3000);
    }

    @And("I should see my products displayed in the cart")
    public void iShouldSeeMyProductsDisplayedInTheCart() {
        Assert.assertTrue(cartPage.AllProductsInCardIsDisplayed());
        cartPage.getProductList();
    }

    @Then("the total amount should equal the sum of two products' values")
    public void theTotalAmountShouldEqualTheSumOfTwoProductsValues() {
        double totalSum = cartPage.getProductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        //Assert that the total amount equals the sum of two products value
        Assert.assertEquals(totalSum, displayFormattedSum); //170.79 + 165.0 = 335.79
    }
}
