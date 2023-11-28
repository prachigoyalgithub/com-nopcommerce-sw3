package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class ElectronicTest extends Utility {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.xpath(menu));
    }

    @org.junit.Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // Mouse Hover on “Electronics” Tab and "Cell Phone" tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']    "));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(electronics).moveToElement(cellPhone).click().build().perform();

        // Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);
    }

    @org.junit.Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // Mouse Hover on “Electronics” Tab and "Cell Phone" tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']    "));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(electronics).moveToElement(cellPhone).click().build().perform();

        // Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = driver.findElement(By.xpath("//h1[normalize-space()='Cell phones']")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);

        //  Click on List View Tab
        selectMenu("//a[@title='List']");

        // Navigate to current URL
        String expectedUrl = "https://demo.nopcommerce.com/cell-phones?viewmode=list&orderby=0&pagesize=6";
        if (!baseUrl.equals(expectedUrl)) {

            // Navigate to the new URL
            driver.get(expectedUrl);
        }
        //  Click on product name “Nokia Lumia 1020” link
        selectMenu("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]");

        //  Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = driver.findElement(By.xpath("//span[contains(text(),'$349.00')]")).getText();
        Assert.assertEquals("Text not verified", actualText, expectedText);

        // Change quantity to 2
        WebElement element = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        element.click();
        element.clear();
        element.sendKeys("2");

        //  Click on “ADD TO CART” tab
        selectMenu("//button[@id='add-to-cart-button-20']");

        // Close the bar
        selectMenu("//span[@title='Close']");

        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText1 = "The product has been added to your shopping cart";
        String actualText1 = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals("Text not verified", actualText1, expectedText1);
        Thread.sleep(2000);

        // Mouse Hover on “Electronics” Tab and "Cell Phone" tab
        mouseHoverToElement(By.xpath("//li[@id='topcartlink']"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
//        Actions action = new Actions(driver);
//        action.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        // String expectedQ = "2";
        // String actualQ = driver.findElement(By.xpath("//input[@value='2']")).getText();
        // Assert.assertEquals("Quantity not verified", actualQ, expectedQ);

        // Verify the Total
        String expectedTotal = "$698.00";
        String actualTotal = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Price not verified", expectedTotal, actualTotal);

        // click on checkbox “I agree with the terms of service”
        selectMenu("//input[@id='termsofservice']");

        //  Click on “CHECKOUT”
        selectMenu("//button[@id='checkout']");

        //  Verify the Text “Welcome, Please Sign In!”
        String expectedWelcome = "Welcome, Please Sign In!";
        String actualWelcome = driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals("Text not verified", expectedWelcome, actualWelcome);

        // Click on “REGISTER” tab
        selectMenu("//button[normalize-space()='Register']");

        // Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = driver.findElement(By.xpath("//h1[normalize-space()='Register']")).getText();
        Assert.assertEquals("Text not verified", expectedRegister, actualRegister);

        //  Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Champa");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Chameli");
        sendTextToElement(By.xpath("//input[@id='Email']"), "monday123@gmail.com");
        sendTextToElement(By.xpath("//input[@name= 'Password']"), "Monday@456");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Monday@456");

        //Click on Register button
        clickOnElement(By.xpath("//button[@name= 'register-button']"));

        //  Verify the message “Your registration completed”
        String expectedRegistration = "Your registration completed";
        String actualRegistration = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Text not verified", expectedRegistration, actualRegistration);

        // Click on continue
        selectMenu("//a[@class='button-1 register-continue-button']");

        // Login again because cart is empty
        selectMenu("//a[@class='ico-login']");
        sendTextToElement(By.xpath("//input[@id='Email']"), "monday14@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "Monday@123");
        selectMenu("//button[normalize-space()='Log in']");

        //  Verify the text “Shopping card”
        String expectedShopping = "Shopping cart";
        String actualShopping = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals(actualShopping, expectedShopping);

        //  click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //  Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //  Fill all the details
        WebElement country = driver.findElement(By.name("BillingNewAddress.CountryId"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United Kingdom");

        //selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Rugby");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "MK");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "NN1 1PD");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0123456789");

        // click on continue button
        selectMenu("//button[@onclick='Billing.save()']");

        // Click on Radio Button “2nd Day Air ($0.00)”
        selectMenu("//input[@id='shippingoption_2']");

        // Click on continue button
        selectMenu("//button[@class='button-1 shipping-method-next-step-button']");

        //  Select Radio Button “Credit Card”
        selectMenu("//input[@id='paymentmethod_1']");

        // Click on continue
        selectMenu("//button[@class='button-1 payment-method-next-step-button']");

        // Select visa card option
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "visa");

        //  Fill all the details
        // Cardholder name
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Champa Chemli");

        // Card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5368392055488809");

        // Expire date
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "3");

        // Expire Year
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");

        // Card code
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "568");

        // Click on “CONTINUE”
        selectMenu("//button[@class='button-1 payment-info-next-step-button']");

        // Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = driver.findElement(By.xpath("//span[normalize-space()='Credit Card']")).getText();
        Assert.assertEquals("Text not verified", expectedMethod, actualMethod);

        //  Verify “Shipping Method” is “2nd Day Air”
        String expectedShipping = "2nd Day Air";
        String actualShipping = driver.findElement(By.xpath("//span[normalize-space()='2nd Day Air']")).getText();
        Assert.assertEquals("Text not verified", actualShipping, expectedShipping);

        // Verify Total is “$698.00”
        String expectedValue = "$698.00";
        String actualValue = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Text not verified", expectedValue, actualValue);

        //  Click on “CONFIRM”
        selectMenu("//button[normalize-space()='Confirm']");

        // Verify the Text “Thank You”
        String expectedThank = "Thank you";
        String actualThank = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText();
        Assert.assertEquals("Text not verified", expectedThank, actualThank);

        //  Verify the message “Your order has been successfully processed!”
        String expectedMessage = "Your order has been successfully processed!";
        String actualMessage = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
        Assert.assertEquals("Text not verified", expectedThank, actualThank);

        //  Click on “CONTINUE”
        selectMenu("//button[normalize-space()='Continue']");

        //  Verify the text “Welcome to our store”
        String expectedWelcome2 = "Welcome to our store";
        String actualWelcome2 = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
        Assert.assertEquals("Text not verified", expectedWelcome2, actualWelcome2);
        //  Click on “Logout” link
        selectMenu("//a[@class='ico-logout']");
        //  Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl2 = "https://demo.nopcommerce.com/";
        Assert.assertEquals("Url not verified", expectedUrl2, currentUrl);
    }


}
