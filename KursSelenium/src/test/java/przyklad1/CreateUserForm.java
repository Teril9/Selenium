package przyklad1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateUserForm {

    private WebDriver driver;
    //private WebDriver driver1;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

        //driver1 = new ChromeDriver();

    }

    @Test
    public void testMS() throws InterruptedException {
        //First Name
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement firstNameLabel = driver.findElement(By.xpath("//label[@for='first-name']"));
        if (firstNameInput.isEnabled()) {
            firstNameInput.clear();
            firstNameInput.sendKeys("Karol");
            System.out.println(firstNameLabel.getText() + ": " + firstNameInput.getAttribute("value"));
        } else {
            Assert.fail();
        }

        //Last Name
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement lastNameLabel = driver.findElement(By.xpath("//label[@for='last-name']"));
        if (lastNameInput.isEnabled()) {
            lastNameInput.clear();
            lastNameInput.sendKeys("Kowalski");
            System.out.println(lastNameLabel.getText() + ": " + lastNameInput.getAttribute("value"));
        } else {
            Assert.fail();
        }
        //Gender
        WebElement genderRadioButton = driver.findElements(By.className("radio-inline")).get(0);        // By.name("gender") - 2 opcja
        WebElement genderRadioLabel = driver.findElement(By.xpath("//label[@for='gender']"));
        if(genderRadioButton.isEnabled()) {
            genderRadioButton.click();
            System.out.println(genderRadioLabel.getText() + ": " + genderRadioButton.getText());
        } else {
            Assert.fail();
        }

        //Date of Birth
        WebElement dateOfBirthInput = driver.findElement(By.id("dob"));
        dateOfBirthInput.clear();
        dateOfBirthInput.sendKeys("05/22/2010");

        //Address
        WebElement address = driver.findElement(By.id("address"));
        address.clear();
        address.sendKeys("Prosta 51");

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("karol.kowalski@mailinator.com");

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("Start123!");

        WebElement company = driver.findElement(By.id("company"));
        company.clear();
        company.sendKeys("Coders Lab");

        WebElement role = driver.findElement(By.id("role"));
        Select roleSelect = new Select(role);
        roleSelect.selectByIndex(1);
                //selectByValue("QA");

        WebElement jobExpectation = driver.findElement(By.id("expectation"));
        Select jobExpectationSelect = new Select(jobExpectation);
        jobExpectationSelect.selectByVisibleText("Nice manager/leader");
        jobExpectationSelect.selectByVisibleText("Chance to go onsite");

        WebElement waysOfDevelopment = driver.findElement(By.className("development-ways"));
        waysOfDevelopment.findElements(By.tagName("input")).get(0).click();
        waysOfDevelopment.findElements(By.tagName("input")).get(3).click();

        WebElement comment = driver.findElement(By.id("comment"));
        comment.clear();
        comment.sendKeys("To jest mój pierwszy automat testowy");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.submit();

    }

    @After
    public void tearDown() throws Exception{
        //driver.quit();
    }

}
