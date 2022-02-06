import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.ProgressBarPage;

public class progressBarTest extends BaseTest {

    @Test

    public void shouldDisplayCompleteInProgressBar() {
        //given
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        //when

        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        //then
        Assert.assertEquals(progressBarPage.getLabel(),"Complete!");
    }
}
