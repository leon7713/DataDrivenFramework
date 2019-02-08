package testcases;

import com.w2a.base.TestBase;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    @Test
    public void openAccount() throws InterruptedException {
        click("openaccount_CSS");
        


        click("process_CSS");
    }
}
