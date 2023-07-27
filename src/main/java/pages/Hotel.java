package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hotel{

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"react-hat-container\"]/div/div/div/div[3]/div[2]/div/nav/li[4]/a/span[2]")
    private WebElement hotel;

    public Hotel(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void hotelSubmit(){
        hotel.click();
    }

    public WebElement hotelElem(){
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"timetable\"]")));
        return element;
    }
}


