package cucumber.test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    private WebDriver driver;

    @Given("^an open browser with google\\.com$")
    public void anOpenBrowserWithGoogleCom() {
        // Skonfiguruj sterownik przeglądarki
         System.setProperty("webdriver.chrome.driver",
            "src/main/resources/drivers/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("http://www.google.com");
    }


    @When("^a keyword (.*) is entered in input field$")
    public void aKeywordSeleniumIsEnteredInInputField(String keyword) {
        //public void enterKeyword(String keyword){
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();
        }

    @Then("^the first one should contain selenium$")
    public void theFirstOneShouldContainSelenium() {
    }

    @And("^close browserFeature$")
    public void closeBrowserFeature() {
        driver.quit();
    }
}
