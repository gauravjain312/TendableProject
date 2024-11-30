package test;

import org.openqa.selenium.WebDriver;
import org.tendable.seleniumproject.common.CommonMethods;
import org.tendable.seleniumproject.webdriver.SeleniumWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tendable.seleniumproject.pageobjects.HomePage;

public class AboutTest {
    private WebDriver driver;
    private HomePage homePage;
    CommonMethods getPropFile = new CommonMethods();

    @BeforeClass
    public void setUp() {
        driver = new SeleniumWebDriver().getWebDriver();
        String baseUrl = getPropFile.getEnvPropertyValue("baseUrl");
        String aboutLink = baseUrl.concat(getPropFile.getEnvPropertyValue("AboutUrl"));
        driver.get(aboutLink);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    // Verify Book a Demo Link is present and Enabled at About Page
    public void verifyAboutPageBookDemoLinkTest() {
        Assert.assertEquals(driver.getTitle(), getPropFile.getEnvPropertyValue("AboutPageTitle"));
        Assert.assertTrue(homePage.isBookADemoLinkPresentAndEnabled());
    }

    @AfterClass
    public void tearDown() {
        homePage = null;
        driver.close();
        driver.quit();
    }
}