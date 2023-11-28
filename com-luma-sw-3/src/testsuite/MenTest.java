package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    //open Browser
    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //* Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-5']"));
        //* Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        //* Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//div[@class='column main']//li[1]"));
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
//        Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        sleep(1);
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        clickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        sleep(4);
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyElements("Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’", "You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        //Click on ‘shopping cart’ Link into message
        sleep(2);
        clickOnElement(By.xpath("//a[@class='action showcart']"));
        sleep(1);
        clickOnElement(By.xpath("//span[normalize-space()='View and Edit Cart']"));
        sleep(2);
        //* Verify the text ‘Shopping Cart.’
        verifyElements("Verify the text ‘Shopping Cart.’", "Shopping Cart", By.xpath("//span[@class='base']"));
        //* Verify the product name ‘Cronus Yoga Pant’
        verifyElements("Verify the product name ‘Cronus Yoga Pant’", "Cronus Yoga Pant", By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        //* Verify the product size ‘32’
        verifyElements("Verify the product size ‘32’", "32", By.xpath("//dd[contains(text(),'32')]"));
        //* Verify the product colour ‘Black’
        verifyElements("Verify the product colour ‘Black’", "Black", By.xpath("//dd[contains(text(),'Black')]"));
    }

    @After
    public void close() {
          closeBrowser();
    }

}
