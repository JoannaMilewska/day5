import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertPageTest extends BaseTest{

    @Test
    public void shouldDisplayCorrectMessageAfterClickingSimpleAlertButton(){
        //given
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertPage alertPage = new AlertPage(driver);
        //when
        alertPage.processSimpleAlert();
        //then
        Assert.assertEquals(alertPage.getSimpleAlertLabel(),"OK button pressed");

    }
    @Test
    public void shouldDisplayCorrectMessageAfterClickingDelayedAlertButton(){
        //given
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertPage alertPage = new AlertPage(driver);
        //when
        alertPage.processDelayedAlert();
        //then
        Assert.assertEquals(alertPage.getDelayedAlertLabel(),"OK button pressed");

    }

    @Test
    public void shouldDisplaySimpleAlertCorrectTest(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertPage alertPage = new AlertPage(driver);
        //when
        alertPage.processSimpleAlert();
        //then
        Assert.assertTrue(alertPage.isSimpleAlertLabelCorrect());

    }

    @Test
    public void shouldDisplayDelayedAlertCorrectTest(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertPage alertPage = new AlertPage(driver);
        //when
        alertPage.processDelayedAlert();
        //then
        Assert.assertTrue(alertPage.isDelayedAlertLabelCorrect());

    }
}
