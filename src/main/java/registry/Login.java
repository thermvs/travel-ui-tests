package registry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login{

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='g-link styles__unauthorized__18ak0 styles__unauthorized__157g8']")
    private WebElement loginRedirect;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//button/div/div")
    private WebElement loginEnter;


    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loginRedirect(){
        loginRedirect.click();
    }

    public void loginEmail(){
        loginEmail.click();
    }

    public void loginEmailSubmit(){
        loginEmail.sendKeys("testmail@gmail.com");;
    }

    public void loginPassword(){
        loginPassword.click();
    }

    public void loginPasswordSubmit(){
        loginPassword.sendKeys("0123456789");
    }

    public void loginEnter(){
        loginEnter.click();
    }

    public WebElement loginElem(){
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-hat-container\"]/div/div/div/div[2]/div/div/a[2]")));
        return element;
    }
}



