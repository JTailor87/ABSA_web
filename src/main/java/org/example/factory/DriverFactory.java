package org.example.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Properties;

public class DriverFactory {
    private ConfigReader configReader;
    Properties prop;
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_driver(String browser) {
        configReader = new ConfigReader();
        prop = configReader.init_prop();

        System.out.println("browser value is: " + browser);

        if (browser.equals("Chrome")) {
            if (prop.getProperty("headlessChrome").equalsIgnoreCase("Yes")) {
                System.out.println("Is " + browser +" running headless: "+prop.getProperty("headlessChrome"));
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                WebDriverManager.chromedriver().browserVersion("119.0.6045.160").setup();
//                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver(options));
            } else {
                WebDriverManager.chromedriver().browserVersion("119.0.6045.160").setup();
//            WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
            }
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("Safari")) {
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
