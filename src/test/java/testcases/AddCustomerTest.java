package testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {

        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alerttext));
        Thread.sleep(2000);
        alert.accept();

        //Assert.fail();
    }

    @DataProvider
    public Object[][] getData() {

        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[1][4];
        data[0][0] = "Leon";
        data[0][1] = "Ushar";
        data[0][2] = "109388";
        data[0][3] = "Customer added successfully with customer id";

        return data;
    }

}