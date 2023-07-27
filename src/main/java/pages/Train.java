package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Train{

    private final WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder, 'Откуда')]")
    private WebElement trainFrom;

    @FindBy(xpath = "//input[contains(@placeholder, 'Куда')]")
    private WebElement trainTo;

    @FindBy(xpath = "//button[contains(@data-ti, 'date_arrow_increase')]")
    private WebElement trainPersons;

    @FindBy(xpath = "//div[contains(@class, 'button_wrp m-border_inner')]/button")
    private WebElement trainSubmit;

    public Train(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void trainFrom(){
        trainFrom.sendKeys("Санкт-Петербург");
    }

    public void trainTo(){
        trainTo.sendKeys("Зеленогорск");
    }

    public void trainPersons(){
        trainPersons.click();
    }

    public void trainSubmit(){
        trainSubmit.click();
    }

    public WebElement trainElem(){
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"timetable\"]")));
        return element;
    }
}


