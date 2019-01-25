package com.w2a.base;

import com.w2a.utilities.ExcelReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

    @BeforeSuite
    public void setUp() throws IOException {

        if (driver == null) {

            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
            config.load(fis);
            log.debug("config file loaded !!!");
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\or.properties");
            OR.load(fis);
            log.debug("OR file loaded !!!");
        }

        if (config.getProperty("browser").equals("firefox")) {
            //execute in Firefox driver
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Leonidus\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (config.getProperty("browser").equals("chrome")) {
            //execute in chrome driver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leonidus\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            log.debug("chrome launched !!!");

        }
        else if (config.getProperty("browser").equals("IE")) {
            //execute in chrome driver
            System.setProperty("webdriver.IE.driver", "C:\\Users\\Leonidus\\IdeaProjects\\testselenium\\drivers\\MicrosoftWebDriver.exe");
            driver = new InternetExplorerDriver();
        }

        driver.get(config.getProperty("testsiteurl"));
        log.debug("navigated to: " + config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
    }

    public boolean isElementPresent(By by) {

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

        if (driver != null) {
            driver.quit();
        }

        log.debug("execution completed !!!");
    }

}
