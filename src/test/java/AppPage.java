import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppPage {

    public AppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "left_0")
    public WebElement left0;
    @FindBy(id = "left_1")
    public WebElement left1;
    @FindBy(id = "left_2")
    public WebElement left2;
    @FindBy(id = "left_3")
    public WebElement left3;
    @FindBy(id = "right_0")
    public WebElement right0;
    @FindBy(id = "right_1")
    public WebElement right1;
    @FindBy(id = "right_2")
    public WebElement right2;
    @FindBy(id = "right_3")
    public WebElement right3;
    @FindBy(id = "weigh")
    public WebElement weigh;
    @FindBy(xpath = "(//button[@id='reset'])[2]")
    public WebElement reset;
    @FindBy (xpath = "//button[contains(@id,'coin')]")
    List<WebElement> coins;
    @FindBy(xpath = "//ol/li")
    public List<WebElement> weighings;
}