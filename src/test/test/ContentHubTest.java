package test;

import org.openqa.selenium.WebDriver;
import org.tendable.seleniumproject.common.CommonMethods;
import org.tendable.seleniumproject.webdriver.SeleniumWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tendable.seleniumproject.pageobjects.HomePage;

public class ContentHubTest {
    private WebDriver driver;
    private HomePage homePage;
    CommonMethods getPropFile = new CommonMethods();

    @BeforeClass
    public void setUp() {
        driver = new SeleniumWebDriver().getWebDriver();
        String baseUrl = getPropFile.getEnvPropertyValue("baseUrl");
        String contentHubLink = baseUrl.concat(getPropFile.getEnvPropertyValue("ContentHubUrl"));
        driver.get(contentHubLink);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    // Verify Book a Demo Link is present and Enabled at Content Hub Page
    public void verifyContentHubPageBookDemoLinkTest() {
        Assert.assertEquals(driver.getTitle(), getPropFile.getEnvPropertyValue("ContentHubPageTitle"));
        Assert.assertTrue(homePage.isBookADemoLinkPresentAndEnabled());
    }

    @AfterClass
    public void tearDown() {
        homePage = null;
        driver.close();
        driver.quit();
    }
}