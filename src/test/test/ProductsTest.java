package test;

import org.openqa.selenium.WebDriver;
import org.tendable.seleniumproject.common.CommonMethods;
import org.tendable.seleniumproject.webdriver.SeleniumWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tendable.seleniumproject.pageobjects.HomePage;

public class ProductsTest {
    private WebDriver driver;
    private HomePage homePage;
    CommonMethods getPropFile = new CommonMethods();

    @BeforeClass
    public void setUp() {
        driver = new SeleniumWebDriver().getWebDriver();
        String baseUrl = getPropFile.getEnvPropertyValue("baseUrl");
        String productsLink = baseUrl.concat(getPropFile.getEnvPropertyValue("ProductsUrl"));
        driver.get(productsLink);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    // Verify Book a Demo Link is present and Enabled at Products Page
    public void verifyProductsPageBookDemoLinkTest() {
        Assert.assertEquals(driver.getTitle(), getPropFile.getEnvPropertyValue("ProductsPageTitle"));
        Assert.assertTrue(homePage.isBookADemoLinkPresentAndEnabled());
    }

    @AfterClass
    public void tearDown() {
        homePage = null;
        driver.close();
        driver.quit();
    }
}