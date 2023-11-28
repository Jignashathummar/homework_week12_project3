package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {
    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

        @Test
    //verifyTheSortByProductNameFilter
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        //* Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        //* Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //* Select Sort By filter “Product Name”
        sleep(1);
        selectByVisibleTextFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "Product Name ");
        sleep(2);
        //* Verify the products name display in alphabetical order
        boolean isListAscendingOrder = verifyTheListIsAscendingOrder(By.className("product-item-link"));
        verifyElements("Verify the products name display in alphabetical order", "true", String.valueOf(isListAscendingOrder));

    }
    @Test
    //verifyTheSortByPriceFilter
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        //* Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        //* Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //* Select Sort By filter “Price”
//        clickOnElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        selectByVisibleTextFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "Price ");
        //* Verify the products price display in Low to High
        sleep(2);
        boolean isListAscendingOrder = verifyTheListIsAscendingOrder(By.xpath("//span[@class='price-container price-final_price tax weee']//span[@class='price']"));
        verifyElements("Verify the products price display in Low to High", "true", String.valueOf(isListAscendingOrder));
    }

    @After
    //close Browser
    public void close() {
        closeBrowser();
    }
}
