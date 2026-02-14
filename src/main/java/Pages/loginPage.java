package Pages;

import Utils.CommonMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class loginPage {

    public static WebDriver driver;
    public static WebDriverWait wait;
    CommonMethods common;

    public loginPage(WebDriver driver) {
        loginPage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.common = new CommonMethods(driver);
        PageFactory.initElements(driver, this);
    }


    Faker faker = new Faker();

    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']")
    public WebElement HomePage;

    @FindBy(xpath = "//a[contains(text(),'Signup')]")
    public WebElement SignupLink;

    @FindBy(xpath = "//div[@class='signup-form']")
    public WebElement SignupForm;

    @FindBy(xpath = "//div[@class='signup-form']//input[@name='name']")
    public WebElement signupName;

    @FindBy(xpath = "//div[@class='signup-form']//input[@name='email']")
    public WebElement signupEmail;

    @FindBy(xpath = "//div[@class='signup-form']//button")
    public WebElement signupButton;


    public int RandomTitleSelection(){
        LocalDate today = LocalDate.now();
        int date = today.getDayOfMonth();
        String str = String.valueOf(date);
        int sum =0;
        for(char c:str.toCharArray()){
            sum+=Character.getNumericValue(c);
        }
        return sum%2;
    }

    public void signup() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(HomePage));
        SignupLink.click();
        if(SignupForm.isDisplayed()){
            signupName.sendKeys(common.randonName());
            Thread.sleep(1000);
            signupEmail.sendKeys(common.randomEmail());
            common.Click(signupButton);
        }else {
            throw new Exception();
        }
    }


}
