package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before//action before every method
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {//1.1 Parameterised method
        clickOnElement(By.xpath("//body/div[6]/div[2]"));//1.2 click on the menu whichever parameter is passed

    }

    /**
     * verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
     */
    @Test
    public void verifyPageNavigation() {//1.3 verifyPageNavigation method
        String expectedMessage = "Welcome to our store";//1.3 Verifying the page navigation
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("correct page not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown () {
        closeBrowser();
    }

}

