package testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() {

        System.setProperty("org.uncommons.reportng.escape-output","false"); //to show picture in html report
        log.debug("inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))),"Login not successful");

        log.debug("Login successfully executed");
        Reporter.log("Login successfully executed");
        Reporter.log("<a target=\"_blank\" href=\"C:\\Toshiba\\Tbackground.jpg\">Screenshot</a>");
        //Reporter.log("<a target=\"_blank\" href=\"C:\\Toshiba\\Tbackground.jpg\"><img src=\"C:\\Toshiba\\Tbackground.jpg\" </img></a>");
    }
}
