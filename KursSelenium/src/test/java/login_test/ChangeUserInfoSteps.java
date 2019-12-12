package login_test;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {
    UserInfoPage userInfoPage;
    WebDriver driver;
    LoginPage loginPage;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        userInfoPage = new UserInfoPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }

    @And("^He changes his birthday to \"([^\"]*)\"$")
    public void heChangesHisBirthdayTo(String date) {
        userInfoPage.setBirthdate(date);
    }

    @And("^He signs up for our newsletter$")
    public void heSignsUpForOurNewsletter() {
        userInfoPage.signInForNewsletter();
    }

    @And("^He saves information$")
    public void heSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("^He sees \"([^\"]*)\"$")
    public void heSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
    }

    @When("^He goes to UserInformationPage$")
    public void heGoesToUserInformationPage() {
        loginPage.navigateToPersonalInformation();
    }
}