package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class ProgressBarPage extends BasePage{


    @FindBy(css=".progress-label")
    public WebElement progressBar;

    public ProgressBarPage (WebDriver driver){
        super(driver);
    }

    private void waitForProgressBar(){

        wait.until(ExpectedConditions.textToBePresentInElement(progressBar,"Complete!"));

    }
    public String getLabel(){
        waitForProgressBar();
        return progressBar.getText();
    }

}
