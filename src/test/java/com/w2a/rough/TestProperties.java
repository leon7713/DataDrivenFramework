package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main (String[] args) throws IOException {

        Properties config = new Properties();
        Properties OR = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
        config.load(fis);
        fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\or.properties");
        OR.load(fis);
        System.out.println(config.getProperty("browser"));
        System.out.println(OR.getProperty("bmlBtn_CSS"));
    }
}
