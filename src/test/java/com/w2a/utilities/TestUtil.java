package com.w2a.utilities;

import com.w2a.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtil extends TestBase {

    public static void captureScreenshot(String result) throws IOException, InterruptedException {

        Date d = new Date();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String myDate = d.toString().replace(":","_").replace(" ","_") + ".jpg";
        FileUtils.copyFile(src, new File("C:\\test\\" + result + myDate));

    }
}
