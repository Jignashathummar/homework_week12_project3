package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Utility;

public class GearTest extends Utility {
    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    //1. userShouldAddProductSuccessFullyToShoppinCart()
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        mouseHoverToElement(By.id("ui-id-6"));
        //Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        //Verify the text ‘Overnight Duffle’
        verifyElements("Verify the text ‘Overnight Duffle’", "Overnight Duffle", By.className("base"));
        //Change Qty 3
        clearElement(By.id("qty"));
        sendTextToElement(By.id("qty"), "3");
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyElements("Verify the text ‘You added Overnight Duffle to your shopping cart.’", "You added Overnight Duffle to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[@class='action showcart']"));
        sleep(1);
        clickOnElement(By.xpath("//span[normalize-space()='View and Edit Cart']"));
        sleep(3);
        //Verify the product name ‘Overnight Duffle’
        verifyElements("Verify the product name ‘Overnight Duffle’", "Overnight Duffle", By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        //Verify the Qty is ‘3’
        String actualQuantity = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$45.00']"))).getAttribute("value");
        String expectedQuantity = "3";
        Assert.assertEquals(expectedQuantity, actualQuantity);
        //Verify the product price ‘$135.00’
        verifyElements("Verify the product price ‘$135.00’", "$135.00", By.xpath("//span[@data-bind='text: getValue()'][normalize-space()='$135.00']"));
        //Change Qty to ‘5’
        clearElement(By.className("input-text qty"));
        sendTextToElement(By.className("input-text qty"), "5");
        clickOnElement(By.xpath("//button[@title='Update Shopping Cart']"));
        //Verify the product price ‘$225.00’
        verifyElements("Verify the product price ‘$225.00’", "$225.00", By.xpath("//span[@data-bind='text: getValue()'][normalize-space()='$225.00']']"));

    }

    @After
    //close Browser
    public void close() {
//        closeBrowser();
    }

}
