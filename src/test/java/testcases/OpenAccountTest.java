package testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    @Test (dataProvider = "getData")
    public void openAccount(String customer, String currency) throws InterruptedException {
        click("openaccount_CSS");
        Thread.sleep(2000);

        select("customet_CSS", customer);

        select("currency_CSS", currency);

        click("process_CSS");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.accept();
    }

    @DataProvider
    public Object[][] getData() {

        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[1][2];
        data[0][0] = "Harry Potter";
        data[0][1] = "Dollar";

        return data;
    }
}
