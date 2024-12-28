## Overveiw
- Test Automation Project for General Shop Android App with Appium 2 written by Java and based on Maven and Cucumber by java
- Using My Own Test Automation Engine as Testing Framework
- Using TestNG as the Testing Framework
- Using Page Object Model Design Pattern in writing Test script and Page actions
- Auto Scrolling to the Target Element into view (Scroll into Screen or into Swiped Element)
- Android UI Scrollable Class For very smooth and accurate swiping and without using Touch Actions of (x , y Coordinates).
- Test Data Management such that store All Test data in Json Files and Retrieve the Updated Test Data of Products 
- Generating Very Detailed Allure Reports with All Scenario Steps
- Perform Test Execution Locally On Real Android Mobile Devices
- Performing with GitHub Actions
- Performing With Cucumber By Java using Hooks and Runners Class

## Application Under Test
- General-Store.apk
- https://github.com/EbrahimSalem1/General-Shop-MobileAutomationProject/blob/master/src/main/resources/apps/General-Store.apk


## Scenario (Task) :-
- Open the General Store app on an Android device (real or emulator)
- Select Egypt country from the dropdown list.
- Enter your name in the text field.
- Select your Gender
- Assert that Gender Equals 'Male'
- Click on the Let’s Shop button.
- Add two product to the cart.
- Navigate to the cart screen.
- Assert that your products are displayed
- Assert that the total amount equals the sum of two products value


## Features
#### Structure of "main folder"
- Using the AndroidActions Page as Parent of all pages that inherit locators and actions, Thus achieving the right purpose of Inheritance
- Finding Elements using simple Techniques with ID, XPath & Advanced Techniques like XPath Axis and Android UIAutomator

#### Structure of "test folder"
- Using Base Test Class for defining Annotations to Open and Close App, such that all Test Classes inherit from it
- Start each Test from a clean state by Setting and Tearing down App for Every Test Case
- Using Assertions to Validation of Tests
  

#### Reporting Using Allure Report
- Reporting Test Result & Taking Screenshots for Failed Tests and Successful Tests
- Reporting Soft assertion failures and Taking Screenshots for them

#### Configurations
- Reading Global Variables and Configurations from Properties file
- App Type "NativeAndroid"

#### Test Data Management
- Test Data Preparation for Json Data like ""FormTestData"" by setting Json File
- Test Data Execution by reading test data from Json files whether Json data is represented as Simple Json Object or Nested Json Objects or Array of Json Objects

