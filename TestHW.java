import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.OutputType.FILE;

/**
 * Created by Artur on 04.05.2017.
 */
public class TestHW
{
    @Test
    public void test1(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));

  //      driver.manage().window().setSize(new Dimension(1024, 768));

        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test
    public void test2(){
    System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    driver.navigate().to("https://www.epam.com");
    js.executeScript("window.scrollBy(0,500)");
    assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    driver.close();
    }

    @Test
    public void test3(){
        System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setJavascriptEnabled(true);
//        cap.setBrowserName("chrome");
//        cap.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        cap.setBrowserName(DesiredCapabilities.firefox().getBrowserName());

        cap.setPlatform(Platform.ANDROID);
        cap.setVersion("37.0");
        WebDriver driver = new InternetExplorerDriver(cap);
        driver.navigate().to("https://browser-info.ru/");
    }

    @Test
    public void test4(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
//        driver.navigate().to("https://www.avito.ru/");
//        driver.findElement(By.id("region_653240")).click();
        driver.navigate().to("https://www.avito.ru/sankt-peterburg?q=%D1%84%D0%BE%D1%80%D1%82%D0%B5%D0%BF%D0%B8%D0%B0%D0%BD%D0%BE");
        Assert.assertEquals(driver.getTitle(), "фортепиано - Доска объявлений от частных лиц и компаний в Санкт-Петербурге на Avito");

        driver.close();
    }


    @Test
    public void test5() throws InterruptedException, IOException {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com");

        WebElement search = driver.findElement(By.id("lst-ib"));

        Actions action = new Actions(driver);
        action.moveToElement(search).click().build().perform();
        action.click().perform();
        action.sendKeys("Text").perform();

        TakesScreenshot sc = (TakesScreenshot) driver;
        File screensFile = sc.getScreenshotAs(FILE);
        org.apache.commons.io.FileUtils.copyFile(screensFile, new File("C:\\programming\\1.png"));
        driver.close();

    }

}
