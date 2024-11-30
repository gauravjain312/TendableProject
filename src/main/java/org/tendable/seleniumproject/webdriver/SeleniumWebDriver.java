package org.tendable.seleniumproject.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.tendable.seleniumproject.common.CommonMethods;

// Singleton Class for initializing WebDriver
public class SeleniumWebDriver {
    WebDriver driver = null;
    CommonMethods getPropFile = new CommonMethods();

    // Create the driver instance based on the browser name
    private void initializeWebDriver(String browser) {
        String webDriverPath = getPropFile.getEnvPropertyValue("webDriverPath");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", webDriverPath.concat("/chromedriver.exe"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", webDriverPath.concat("/msedgedriver.exe"));
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(options);
        }
    }

    // Return the driver instance based on the browser name
    public WebDriver getWebDriver() {
        // get browser name from env.properties file and initialize the driver
        String browserName = getPropFile.getEnvPropertyValue("browser");
        if (driver == null) {
            initializeWebDriver(browserName);
        }
        return driver;
    }
}