import com.sun.jna.platform.FileUtils;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;

/**
 * Created by Artur on 27.04.2017.
 */
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.OutputType.FILE;
import static sun.net.www.protocol.http.HttpURLConnection.userAgent;


public class Test1 {

    @Test
    public void test1(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");

        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test
    public void test19(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");

        driver.manage().window().getPosition();
        driver.manage().window().maximize();

        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("name", "value"));

        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test
    public void test20(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");

        assertEquals(driver.getCurrentUrl(), "https://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");

    //    assertEquals(driver.getPageSource().contains("<meta>google-analytics"));

        driver.close();
    }

    @Test
    public void test22(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");

        String windowHandler = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window("frame-id");
        driver.switchTo().alert();


        driver.close();
    }

    @Test
    public void test23(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");

        driver.navigate().refresh();

        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();

        driver.close();
    }

    @Test
    public void test24(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");

//        WebElement element = driver.findElement(By.id("submit-id"));
//        List<WebElement> elements = driver.findElements(By.tagName("li"));
//        driver.findElement(By.className("options-class"));
//        driver.findElement(By.name("button-name"));
//        driver.findElement(By.cssSelector(".options"));
//        driver.findElement(By.xpath("//li[@name='button-name']"));
//        driver.findElement(By.linkText("Contact Us"));
        driver.findElement(By.partialLinkText("Contact"));
        driver.navigate().to("https://www.google.com");
        WebElement search = driver.findElement(By.id("lst-ib"));
        search.sendKeys("Hello");


        WebElement searchButton = driver.findElement(By.id("_fZl"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib")));
        driver.close();
    }

    @Test
    public void test25() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com");
        WebElement search = driver.findElement(By.id("lst-ib"));

        search.click();
        search.sendKeys("Hello");
//        search.clear();
//        System.out.println("---" + search.getText());
        System.out.println(search.getAttribute("maxlength"));
//        System.out.println(search.getCssValue("font-size"));
//        assertEquals(search.getText(), "Hello");
        assertEquals(search.getAttribute("maxlength"), "2048");
        assertEquals(search.getCssValue("font-size"),"16px" );
        Assert.assertTrue(search.isDisplayed());
        Assert.assertTrue(search.isEnabled());

//        Assert.assertTrue(search.isSelected());
        Point point = search.getLocation();
        System.out.println(point);
        Dimension size = search.getSize();
        System.out.println(size);

//        Thread.sleep(5000);
//        driver.close();
    }

    @Test
    public void test33() throws InterruptedException, IOException{
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com");

        WebElement search = driver.findElement(By.id("lst-ib"));

        Actions action = new Actions(driver);
        action.moveToElement(search).click().build().perform();
        action.click().perform();
        action.sendKeys("Text").perform();

//        action.clickAndHold().perform();
//        action.doubleClick().perform();
//        action.dragAndDrop(search, search).perform();
//        action.dragAndDropBy(search, 100, 500).perform();
//        action.keyDown(Keys.ALT).perform();

//        action.keyUp(Keys.ENTER).perform();
//        action.moveByOffset(10, 10).perform();
//        action.moveToElement(search).perform();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("alert('HI!');");
//        js.executeAsyncScript("alert('HI, async!');");

        //        Assert.assertTrue(search.isSelected());
        TakesScreenshot sc = (TakesScreenshot) driver;
        File screensFile = sc.getScreenshotAs(FILE);
        org.apache.commons.io.FileUtils.copyFile(screensFile, new File("C:\\programming\\1.png"));
        driver.close();

    }

    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--user-agent=" + userAgent);
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setCapability(CapabilityType.PROXY, cap);
//        cap.setCapability(ChromeOptions.CAPABILITY , co);
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, "map that has been created in step 7");

        RemoteWebDriver driver = new ChromeDriver(dc);
        driver.navigate().to("https://www.epam.com");


        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test
    public void test3(){
        System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.navigate().to("https://www.epam.com");

        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
//        driver.close();
    }

    @Test
    public void simpleTest1(){
        new FirefoxDriver();
        new ChromeDriver();
        new InternetExplorerDriver();
//        new HTMLUnitDriver();
//        new SafariDriver();
//        new RemoteWebDriver(remoteUrl, remoteCapabilities);
    }
    @Test
    public void simpleTest(){
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
    public void testGoogleSearch() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}
