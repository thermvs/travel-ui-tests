package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Bus{

    private final WebDriver driver;

    @FindBy(xpath = "//div[contains(@data-ti, 'departure')]/div[1]/input[1]")
    private WebElement busFrom;

    @FindBy(xpath = "//div[contains(@data-ti, 'arrival')]/div[1]/input[1]")
    private WebElement busTo;

    @FindBy(xpath = "//div[contains(@data-ti, 'date')]/input")
    private WebElement busDate;

    @FindBy(xpath = "//button[contains(@data-ti, 'counter_increment')]")
    private WebElement busPersons;

    @FindBy(xpath = "//button[contains(@data-ti, 'order-button')]")
    private WebElement busSubmit;

    @FindBy(xpath = "//*[@id=\"content\"]/div/section/div/div[1]/div[2]/div/div[1]/div[2]")
    private WebElement busResultTable;

    @FindBy(xpath = "//*[@id=\"content\"]/div/section/div/div[1]/div[2]/div/div[1]/div[2]")
    private WebElement busResTable;

    @FindBy(xpath = "//*[@id=\"content\"]/div/section/div/div[1]/div[2]/div/div[1]/div[2]")
    private WebElement busRtTable;


    public Bus(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void busFrom(){
        busFrom.sendKeys("Казань");
    }

    public void busTo(){
        busTo.sendKeys("Москва");
    }

    public void busDate(){
        busDate.sendKeys("25.06.2023");
    }

    public void busPersons(){
        busPersons.click();
    }

    public void busSubmit(){
        busSubmit.click();
    }

    public WebElement busResultTable(){
        return busResultTable;
    }

    public WebElement busElem(){
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/section/div/div[1]/div[2]/div/div[1]/div[2]")));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/section/div/div[1]/div[2]/div/div[1]/div[2]")));
        return element;
    }
}


