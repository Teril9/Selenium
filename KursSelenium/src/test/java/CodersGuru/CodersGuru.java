package CodersGuru;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodersGuru {

    private WebDriver driver;

    @Given("^Page Coders Guru is opened$")
    public void pageCodersGuruIsOpened() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tester.codersguru.pl");
    }

    @When("^Go to register page$")
    public void goToRegisterPage() {
        WebElement element = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        element.click();
    }

    @And("^Fill all fields$")
    public void fillAllFields() {
        //email
        WebElement emailInput = driver.findElement(By.id("fos_user_registration_form_email"));
        emailInput.clear();
        emailInput.sendKeys("email@com1234.com");

        //name
        WebElement nameInput = driver.findElement(By.id("fos_user_registration_form_name"));
        nameInput.clear();
        nameInput.sendKeys("Karol");

        //lastname
        WebElement lastnameInput = driver.findElement(By.id("fos_user_registration_form_lastname"));
        lastnameInput.clear();
        lastnameInput.sendKeys("Bogdala");

        //password
        WebElement passwordInput = driver.findElement(By.id("fos_user_registration_form_plainPassword_first"));
        passwordInput.clear();
        passwordInput.sendKeys("Start123!");

        //repassword
        WebElement repasswordInput = driver.findElement(By.id("fos_user_registration_form_plainPassword_second"));
        repasswordInput.clear();
        repasswordInput.sendKeys("Start123!");

        //city
        WebElement cityInput = driver.findElement(By.id("form_city"));
        cityInput.clear();
        cityInput.sendKeys("Lodz");

        //postalCode
        WebElement postalCodeInput = driver.findElement(By.id("form_postal_code"));
        postalCodeInput.clear();
        postalCodeInput.sendKeys("96-010");

        //street
        WebElement streetnput = driver.findElement(By.id("form_street"));
        streetnput.clear();
        streetnput.sendKeys("Orla");

        //nr
        WebElement nrInput = driver.findElement(By.id("form_number"));
        nrInput.clear();
        nrInput.sendKeys("4");

        //checkBox
        WebElement checkBoxInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[12]/input"));
        checkBoxInput.click();

        //register
        WebElement register = driver.findElement(By.id("register-submit-btn"));
        register.click();
    }

    @Then("Go to final page")
    public void appearsInfo() throws Throwable {
        WebElement registerSubmit= driver.findElement(By.xpath("/html/body/section[3]/div/h1"));
        Assert.assertEquals("Pomoc w problemach programistycznych",registerSubmit.getText());
    }
}
