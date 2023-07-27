package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tour{

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"react-hat-container\"]/div/div/div/div[3]/div[2]/div/nav/li[6]/a/span[2]")
    private WebElement tour;


    public Tour(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void tourSubmit(){
        tour.click();
    }

    public WebElement trainElem(){
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"timetable\"]")));
        return element;
    }
}


