import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    @org.testng.annotations.Test
    public void test() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://ec2-54-208-152-154.compute-1.amazonaws.com/");

        int correctNumber = 0;

        AppPage appPage = new AppPage(driver);
        appPage.left0.sendKeys("1");
        appPage.left1.sendKeys("2");
        appPage.left2.sendKeys("3");
        appPage.left3.sendKeys("4");

        appPage.right0.sendKeys("5");
        appPage.right1.sendKeys("6");
        appPage.right2.sendKeys("7");
        appPage.right3.sendKeys("8");

        appPage.weigh.click();

        if (appPage.weighings.get(0).getText().contains("<")) {
            Thread.sleep(1000);
            appPage.reset.click();
            Thread.sleep(1000);
            appPage.left0.sendKeys("1");
            appPage.left0.sendKeys("2");
            appPage.right0.sendKeys("3");
            appPage.right1.sendKeys("4");
            appPage.weigh.click();
            if (appPage.weighings.get(1).getText().contains("<")) {
                appPage.reset.click();
                appPage.left0.sendKeys("1");
                appPage.right0.sendKeys("2");
                appPage.weigh.click();
                if (appPage.weighings.get(2).getText().contains("<")) {
                    correctNumber = 1;
                } else {
                    correctNumber = 2;
                }
            } else {
                appPage.reset.click();
                appPage.left0.sendKeys("3");
                appPage.right0.sendKeys("4");
                appPage.weigh.click();
                if (appPage.weighings.get(2).getText().contains("<")) {
                    correctNumber = 3;
                } else {
                    correctNumber = 4;
                }
            }
        } else {
            appPage.reset.click();
            appPage.left2.sendKeys("5");
            appPage.left3.sendKeys("6");
            appPage.right2.sendKeys("7");
            appPage.right3.sendKeys("8");
            appPage.weigh.click();
            if (appPage.weighings.get(1).getText().contains("<")) {
                appPage.reset.click();
                appPage.left0.sendKeys("5");
                appPage.right0.sendKeys("6");
                appPage.weigh.click();
                if (appPage.weighings.get(2).getText().contains("<")) {
                    correctNumber = 5;
                } else {
                    correctNumber = 6;
                }
            } else {
                appPage.reset.click();
                appPage.left0.sendKeys("7");
                appPage.right0.sendKeys("8");
                appPage.weigh.click();
                if (appPage.weighings.get(2).getText().contains("<")) {
                    correctNumber = 7;
                } else {
                    correctNumber = 8;
                }
            }
        }
        appPage.coins.get(correctNumber).click();
        System.out.println("Correct Number is: " + correctNumber);
        driver.switchTo().alert().accept();
        for (int i = 0; i < appPage.weighings.size(); i++) {
            System.out.println("List of weighings: " + appPage.weighings.get(i).getText());
        }
    }
}
