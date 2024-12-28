package androidAppTestCases;

import androidPages.FormPage;
import base.BaseTest;
import ebrahimEngine.managers.JsonManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneralFormData_TC1 extends BaseTest {

    String jsonFilePathForUserNameField = "src/test/resources/TestDataJsonFiles/FormTestData.json";
    JsonManager json = new JsonManager(jsonFilePathForUserNameField);

    FormPage formpage = new FormPage(driver);


    @Test
    public void FillFormDataAndSelectCountryFromTheDropdownListAndClickOnShopButton(){

        // Call FormDataPage
        formpage = new FormPage(driver);
        formpage.clickOnCountryDropDownList();
        formpage.scrollOnCountryTxt();
        formpage.clickOnCountryTxtSelected();
        formpage.enterTxtNameField(json.getData("userName"));
        formpage.clickOnTypeOfGender();

        Assert.assertTrue(formpage.validateNameOfTypeOfGender().contains(json.getData("Gender")));
        formpage.clickOnLetsShopButton();

    }
}
