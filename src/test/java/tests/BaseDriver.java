package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseDriver {
    static WebDriver driver;
    public static String loginUrl = "https://www.gittigidiyor.com/uye-girisi";

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        driver.get("https://www.gittigidiyor.com/");
    }
    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void setById(String id, String value){
        WebElement loginElement =driver.findElement(By.id(id));
        loginElement.click();
        loginElement.clear();
        loginElement.sendKeys(value);
    }
    public void clickBy(By by){
        WebElement loginButton = driver.findElement(by);
        loginButton.click();
    }
}

