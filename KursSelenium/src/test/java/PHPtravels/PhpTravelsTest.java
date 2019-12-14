package PHPtravels;
import org.junit.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.List;


public class PhpTravelsTest {

        private WebDriver driver;
        //private WebDriver driver1;

        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver");

            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://www.phptravels.net/");

            //driver1 = new ChromeDriver();
        }

        @Test
        public void testPhpTravels() throws InterruptedException {
            //flight
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[2]/a")).click();

            //1st city
            WebElement cityFromInput = driver.findElement(By.id("s2id_autogen5"));
            cityFromInput.sendKeys("WAW");
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/div")).click();

            //2nd city
            WebElement cityToInput = driver.findElement(By.id("s2id_autogen6"));
            cityToInput.sendKeys("EWR");
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/div/span")).click();

            //Depart
            List<WebElement> inputs = driver.findElements(By.tagName("input"));
            for (WebElement input : inputs) {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].removeAttribute('readonly','readonly')",input);
            }
            driver.findElement(By.id("FlightsDateStart")).sendKeys("2020-01-27");

            //Search
            //driver.findElement(By.className("btn-primary btn btn-block")).click();
            driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[2]/div[4]/button")).submit();


            //*[@id="LIST"]/li[1]/div/div[1]/div[2]/form/div[2]/div/button
            //driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/nav/div[3]/svg/path")).click();
            //driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/div/div/div[2]/div[30]")).click();
            //driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[2]/div[3]/div/div/div[2]/div/div[2]/div/span/button[2]")).click();
            //driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[2]/div[4]/button")).click();

            driver.findElement(By.xpath("//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/button")).click();
            driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Pol");
            driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys("Polk");
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("polpolk@com.com");
            driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("555222444");
            driver.findElement(By.xpath("//*[@id=\"birthday\"]")).sendKeys("1999-10-10");
            driver.findElement(By.xpath("//*[@id=\"cardno\"]")).sendKeys("ABC654321");
            driver.findElement(By.id("expiration")).sendKeys("2022-01-01");

            //country
            driver.findElement(By.id("s2id_nationality")).click();
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Poland");
            driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div/span")).click();


            WebElement card = driver.findElement(By.xpath("//*[@id=\"cardtype\"]"));
            Select cardSelect = new Select(card);
            cardSelect.selectByIndex(4);

            driver.findElement(By.xpath("//*[@id=\"card-number\"]")).sendKeys("1234567890");

            WebElement expirationDate = driver.findElement(By.xpath("//*[@id=\"expiry-month\"]"));
            Select expirationDateSelect = new Select(expirationDate);
            expirationDateSelect.selectByIndex(4);

            WebElement expirationYear = driver.findElement(By.xpath("//*[@id=\"expiry-year\"]"));
            Select expirationYearSelect = new Select(expirationYear);
            expirationYearSelect.selectByIndex(3);

            driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("063");

            //checkbox
            //driver.findElement(By.id("acceptTerm")).click();
            List<WebElement> checkbox = driver.findElements(By.className("custom-control custom-checkbox form-group acceptterm"));
            //checkbox[0];

            driver.findElement(By.xpath("//*[@id=\"confirmBooking\"]")).click();


//            WebElement submit = driver.findElement(By.id("submit"));
//            submit.submit();

        }

        @After
        public void tearDown() throws Exception{
            //driver.quit();
        }
}