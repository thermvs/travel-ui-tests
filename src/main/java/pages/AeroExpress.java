package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AeroExpress {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[1]/div[4]/div[2]/div[2]")
    private WebElement aeChoose;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[1]/div[4]/div[2]/div[3]/div[1]/a[3]")
    private WebElement aeSubmit;

    public AeroExpress(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void aeroChoose(){
        aeChoose.click();
    }
    public void aeroSubmit(){
        aeSubmit.click();
    }
}

