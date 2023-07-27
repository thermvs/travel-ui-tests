package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusTest {

    public static WebDriver chromeDriver;
    public static WebDriver firefoxDriver;
    private List<WebDriver> driverList;
    private Map<String, Object> vars;
    private Map<String, Object> vars1;
    JavascriptExecutor js;
    JavascriptExecutor js1;

    @BeforeEach
    public void setUp() {
        driverList = new ArrayList<>();
        System.setProperty("webdriver.firefox.driver", "src/test/java/resources/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        js = (JavascriptExecutor) chromeDriver;
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        js1 = (JavascriptExecutor) firefoxDriver;
        driverList.add(firefoxDriver);
        driverList.add(chromeDriver);
        vars = new HashMap<>();
        vars1 = new HashMap<>();
    }

    @AfterEach
    public void tearDown() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }

    @Test
    public void busPageTicket() {
        driverList.forEach(driver -> {
            Class<? extends WebDriver> driverClass = driver.getClass();
            driver.get("https://bus.tutu.ru/");
            driver.manage().window().setSize(new Dimension(1000, 1000));

            Bus bus = new Bus(driver);
            bus.busFrom();
            bus.busTo();
            bus.busDate();
            bus.busPersons();
            bus.busSubmit();
            assertTrue(bus.busResultTable().isDisplayed());
        });
    }
}
