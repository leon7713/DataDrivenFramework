package com.w2a.utilities;

import com.w2a.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class TestUtil extends TestBase {

    public static void captureScreenshot(String result) throws IOException, InterruptedException {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\test\\" + result + "screenshot.png"));

    }
}
