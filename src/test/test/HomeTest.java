package test;

import org.openqa.selenium.WebDriver;
import org.tendable.seleniumproject.common.CommonMethods;
import org.tendable.seleniumproject.webdriver.SeleniumWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tendable.seleniumproject.pageobjects.HomePage;

public class HomeTest {
    private WebDriver driver;
    private HomePage homePage;
    CommonMethods getPropFile = new CommonMethods();

    @BeforeClass
    public void setUp() {
        driver = new SeleniumWebDriver().getWebDriver();
        String baseUrl = getPropFile.getEnvPropertyValue("baseUrl");
        driver.get(baseUrl);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    // Verify Home Page Top Menu
    public void verifyHomePageTopMenuTest() {
        Assert.assertEquals(driver.getTitle(), getPropFile.getEnvPropertyValue("HomePageTitle"));
        Assert.assertTrue(homePage.isAboutLinkPresent());
        Assert.assertTrue(homePage.isProductsLinkPresent());
        Assert.assertTrue(homePage.isSectorsLinkPresent());
        Assert.assertTrue(homePage.isContentHubLinkPresent());
        Assert.assertTrue(homePage.isContactLinkPresent());
        Assert.assertTrue(homePage.isBookADemoLinkPresentAndEnabled());
    }

    @AfterClass
    public void tearDown() {
        homePage = null;
        driver.close();
        driver.quit();
    }
}