package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Work{

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/button")
    private WebElement button;

    public Work(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void buttonCLick(){
        button.click();
    }

    public WebElement workElem(){
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'o-text-iconWrapperLeft')]")));
        return element;
    }
}

