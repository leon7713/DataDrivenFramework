package testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode) throws InterruptedException {

        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();

        Thread.sleep(2000);
    }

    @DataProvider
    public Object[][] getData() {

        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[1][3];
        data[0][0] = "Leon";
        data[0][1] = "Ushar";
        data[0][2] = "109388";

        return data;
    }

}