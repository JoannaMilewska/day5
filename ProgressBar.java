import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBar extends BaseTest{

    @BeforeMethod
    public void OpenPage(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
    }

    @Test
    public void shouldDisplayCompleteInProgressBar(){
        //given
        String expectedText= "Complete!";

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"),expectedText));
        Assert.assertEquals(driver.findElement(By.cssSelector(".progress-label")).getText(),expectedText);

    }

    @Test
    public void shouldHaveSpecifiedClassWhenProgressBarIsComplete(){
        //given
        String expectedText= "Complete!";
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-progressbar-complete")));
        //when puste
        //then
        Assert.assertEquals(driver.findElement(By.cssSelector(".progress-label")).getText(),expectedText);

    }
}
