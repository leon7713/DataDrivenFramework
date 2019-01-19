package testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginAsBankManager() {

        log.debug("inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        log.debug("Login successfully executed");
    }
}
