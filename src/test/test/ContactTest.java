package test;

import org.openqa.selenium.WebDriver;
import org.tendable.seleniumproject.common.CommonMethods;
import org.tendable.seleniumproject.pageobjects.ContactPage;
import org.tendable.seleniumproject.webdriver.SeleniumWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tendable.seleniumproject.pageobjects.HomePage;

public class ContactTest {
    private WebDriver driver;
    private HomePage homePage;
    private ContactPage contactPage;
    CommonMethods getPropFile = new CommonMethods();

    @BeforeClass
    public void setUp() {
        driver = new SeleniumWebDriver().getWebDriver();
        String baseUrl = getPropFile.getEnvPropertyValue("baseUrl");
        String contactLink = baseUrl.concat(getPropFile.getEnvPropertyValue("ContactUrl"));
        driver.get(contactLink);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test(priority = 1)
    // Verify Book a Demo Link is present and Enabled at Contact Page
    public void verifyContactPageBookDemoLinkTest() {
        Assert.assertEquals(driver.getTitle(), getPropFile.getEnvPropertyValue("ContactPageTitle"));
        Assert.assertTrue(homePage.isBookADemoLinkPresentAndEnabled());
    }

    @Test(priority = 2)
    // Verify Contact Page Form Fields are Displayed
    public void verifyContactPageFormFieldsDisplayedTest() {
        Assert.assertTrue(contactPage.isEmailInputPresent());
        Assert.assertTrue(contactPage.isFirstNameInputPresent());
        Assert.assertTrue(contactPage.isLastNameInputPresent());
        Assert.assertTrue(contactPage.isCompanyInputPresent());
        Assert.assertTrue(contactPage.isMessageTypeSelectPresent());
        Assert.assertTrue(contactPage.isAgreeToReceiveCheckboxPresent());
        Assert.assertTrue(contactPage.isSubmitButtonPresent());
    }

    @Test(priority = 3, dependsOnMethods = {"verifyContactPageFormFieldsDisplayedTest"})
    // Fill Contact Form and Verify Error Message
    public void verifyContactPageFormSubmittedTest() {
        contactPage.fillContactForm(getPropFile.getDataPropertyValue("email"),
                getPropFile.getDataPropertyValue("firstName"),
                getPropFile.getDataPropertyValue("lastName"),
                getPropFile.getDataPropertyValue("companyName"),
                getPropFile.getDataPropertyValue("messageType")
                );
        Assert.assertTrue(contactPage.isErrorMessagePresent());
        Assert.assertEquals(contactPage.getErrorValidationMessage(),
                getPropFile.getDataPropertyValue("errorMessage"));
    }

    @AfterClass
    public void tearDown() {
        homePage = null;
        contactPage = null;
        driver.close();
        driver.quit();
    }
}