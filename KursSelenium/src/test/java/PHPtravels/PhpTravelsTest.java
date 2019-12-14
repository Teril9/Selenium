package PHPtravels;
import org.junit.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class PhpTravelsTest {

        private WebDriver driver;

        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver");

            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://www.phptravels.net/");
        }

        @Test
        public void testPhpTravels() throws InterruptedException, IOException {
            //flight
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[2]/a")).click();

            //1st city
            WebElement cityFromInput = driver.findElement(By.id("s2id_autogen5"));
            cityFromInput.sendKeys("WAW");
            Thread.sleep(2500);
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/div")).click();

            //2nd city
            WebElement cityToInput = driver.findElement(By.id("s2id_autogen6"));
            cityToInput.sendKeys("EWR");
            Thread.sleep(2500);
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/div/span")).click();

            //Depart
            List<WebElement> inputs = driver.findElements(By.tagName("input"));
            for (WebElement input : inputs) {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].removeAttribute('readonly','readonly')",input);
            }
            driver.findElement(By.id("FlightsDateStart")).sendKeys("2020-01-27");

            //Search
            driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[2]/div[4]/button")).submit();

            driver.findElement(By.xpath("//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/button")).click();
            driver.findElement(By.id("username")).sendKeys("polpolk@com.com");
            driver.findElement(By.id("password")).sendKeys("Start123!");
            driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Pol");
            driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys("Polk");
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("polpolk@com.com");
            driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("555222444");
            driver.findElement(By.xpath("//*[@id=\"birthday\"]")).sendKeys("1999-10-10");
            driver.findElement(By.xpath("//*[@id=\"cardno\"]")).sendKeys("ZS 0000177");
            driver.findElement(By.id("expiration")).sendKeys("2022-01-01");

            //country
            driver.findElement(By.id("s2id_nationality")).click();
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Poland");
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div/span")).click();


            WebElement card = driver.findElement(By.xpath("//*[@id=\"cardtype\"]"));
            Select cardSelect = new Select(card);
            cardSelect.selectByIndex(4);

            driver.findElement(By.xpath("//*[@id=\"card-number\"]")).sendKeys("4659 5678 0000 0000");

            WebElement expirationDate = driver.findElement(By.xpath("//*[@id=\"expiry-month\"]"));
            Select expirationDateSelect = new Select(expirationDate);
            expirationDateSelect.selectByIndex(4);

            WebElement expirationYear = driver.findElement(By.xpath("//*[@id=\"expiry-year\"]"));
            Select expirationYearSelect = new Select(expirationYear);
            expirationYearSelect.selectByIndex(3);

            driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("063");

            //checkbox
            JavascriptExecutor checkboxInput = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.id("acceptTerm"));
            checkboxInput.executeScript("arguments[0].click();", element);

            driver.findElement(By.id("confirmBooking")).submit();

//            Thread.sleep(10000);
//            Assert.assertTrue(driver.switchTo().alert().getText().contains("The server could not comply with the request since it is either malformed or otherwise incorrect."));
        }

        @After
        public void tearDown() throws Exception{
            takeScreenshot();
            //driver.quit();
        }

    private void takeScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(
                    "target/" + "ok" + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}