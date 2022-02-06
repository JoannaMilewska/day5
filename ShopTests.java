import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShopTests extends BaseTest{

    @Test

    public void shouldAddProductToTheShoppingCart(){

        String expectedText="There are no more items in your cart";

    driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product");
    driver.findElement(By.cssSelector(".add>button")).click();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn>.btn-primary")));
    driver.findElement(By.cssSelector(".cart-content-btn>.btn-primary")).click();
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"SHOPPING CART");
    driver.findElement(By.cssSelector(".remove-from-cart")).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".remove-from-cart")));
    String textFromPage=driver.findElement(By.cssSelector(".no-items")).getText();
    Assert.assertEquals(textFromPage,expectedText);



}
    @Test
    public void shouldContainTwoProductsToTheShoppingCart(){
        String expectedText="There are no more items in your cart";
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product");

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        //dodaj n razy do koszyka
        int nMugs=4;
        for(int i=0; i<nMugs-1; i++){
            driver.findElement(By.cssSelector(".add>button")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn>.btn-secondary")));
            driver.findElement(By.cssSelector(".cart-content-btn>.btn-secondary")).click();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".add>button"))));
        }

        driver.findElement(By.cssSelector(".add>button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn>.btn-primary")));

        driver.findElement(By.cssSelector(".cart-content-btn>.btn-primary")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"SHOPPING CART");
        Assert.assertEquals(driver.findElement(By.cssSelector(".js-cart-line-product-quantity")).getAttribute("value"),"4");
        driver.findElement(By.cssSelector(".remove-from-cart")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".remove-from-cart")));
        String textFromPage=driver.findElement(By.cssSelector(".no-items")).getText();
        Assert.assertEquals(textFromPage,expectedText);



    }}
