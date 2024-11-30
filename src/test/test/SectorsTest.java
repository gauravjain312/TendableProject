package test;

import org.openqa.selenium.WebDriver;
import org.tendable.seleniumproject.common.CommonMethods;
import org.tendable.seleniumproject.webdriver.SeleniumWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tendable.seleniumproject.pageobjects.HomePage;

public class SectorsTest {
    private WebDriver driver;
    private HomePage homePage;
    CommonMethods getPropFile = new CommonMethods();

    @BeforeClass
    public void setUp() {
        driver = new SeleniumWebDriver().getWebDriver();
        String baseUrl = getPropFile.getEnvPropertyValue("baseUrl");
        String sectorsLink = baseUrl.concat(getPropFile.getEnvPropertyValue("SectorsUrl"));
        driver.get(sectorsLink);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    // Verify Book a Demo Link is present and Enabled at Sectors Page
    public void verifySectorsPageBookDemoLinkTest() {
        Assert.assertEquals(driver.getTitle(), getPropFile.getEnvPropertyValue("SectorsPageTitle"));
        Assert.assertTrue(homePage.isBookADemoLinkPresentAndEnabled());
    }

    @AfterClass
    public void tearDown() {
        homePage = null;
        driver.close();
        driver.quit();
    }
}