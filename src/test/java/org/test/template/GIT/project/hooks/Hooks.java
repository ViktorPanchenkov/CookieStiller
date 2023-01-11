package org.test.template.GIT.project.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private static WebDriver driver;
    private static WebDriverWait wait;
    static ChromeDriverService service;
  //  private final static String PATH_TO_CHROMEDRIVER = "C:\\chromedriver_win32\\chromedriver.exe";


    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriverWait getWaiter() {
        return wait;
    }





}
