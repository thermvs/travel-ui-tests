package registry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Register{

    private final WebDriver driver;

    @FindBy(xpath = "//div[2][@class='g-link styles__unauthorized__18ak0 styles__unauthorized__157g8']")
    private WebElement registerRedirect;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement registerEmail;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement registerAllow;

    @FindBy(xpath = "//button/div/div")
    private WebElement registerEnter;

    public Register(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void registerRedirect(){
        registerRedirect.click();
    }

    public void registerEmail(){
        registerEmail.click();
    }

    public void registerEmailSubmit(){
        registerEmail.sendKeys("testmail@gmail.com");
    }

    public void registerAllowButton(){
        registerAllow.click();
    }

    public void registerSubmit(){
        registerEnter.click();
    }

    public void registerEnter(){
        registerEnter.click();
    }

    public WebElement registerElem(){
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='styles__form__3Xq5X']")));
        return element;
    }
}



