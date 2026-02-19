package Pages;

import Utils.CommonMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    CommonMethods common;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        common = new CommonMethods(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement Logout;

    public By LogoutButton =  By.xpath("//a[normalize-space()='Logout']");

    public void UserLogout() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(Logout));
        common.Click(Logout);
        List<WebElement> elements= common.findElements(LogoutButton);
        if(!elements.isEmpty()){
            Assert.fail("Still logout is present");
        }
    }
}
