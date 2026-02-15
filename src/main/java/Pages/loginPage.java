package Pages;

import Utils.CommonMethods;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement MrButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement MrsButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement months;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement years;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement SignupForLetter;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement address;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement State;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement createAccount;

    @FindBy(xpath = "//b[contains(text(),'Account')]")
    public WebElement accountCreated;

    @FindBy(xpath = "//b[contains(text(),'Account')]")
    public WebElement accountDeleted;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement Continue;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteAccount;



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
            String name = common.randonName();
            signupName.sendKeys(name);
            Thread.sleep(1000);
            String email = common.randomEmail();
            signupEmail.sendKeys(email);
            common.Click(signupButton);
        }else {
            throw new Exception();
        }
    }

    public void ClickTitle() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(MrButton));
        if(RandomTitleSelection()==1){
            common.Click(MrButton);
            Thread.sleep(2000);
        }else {
            common.Click(MrsButton);
        }
        System.out.println(RandomTitleSelection());
    }

    public void SelectCountry(){
        Random random = new Random();
        int randomNumber = random.nextInt(7)+1;
        Select select = new Select(country);
        select.selectByIndex(randomNumber);
    }

    /*
    This Method Enters all the details in the create account page, and for Title
    it will select randomly instead of selecting statically, and every method created
    to enter randomly using faker.
    */
    public void EnterDetails() throws Exception {
        common.Enter(password, common.randomPass());
        LocalDate today = LocalDate.now();
        int date = today.getDayOfMonth();
        int getMonth = today.getMonthValue();
        int getYears = today.getYear()-20;
        String str = String.valueOf(date);
        String year = String.valueOf(getYears);
        common.Click(days);
        common.Enter(days,str);
        DateTimeFormatter DT = DateTimeFormatter.ofPattern("MMMM");
        String textMonth = today.format(DT);
        common.Click(months);
        common.Enter(months, textMonth);
        common.Click(years);
        common.Enter(years,year);
        common.Click(SignupForLetter);
        common.Enter(firstName, common.randonName());
        common.Enter(lastName, common.randonName());
        common.Enter(address,common.randomAddress());
        SelectCountry();
        common.Enter(State, common.randomState());
        common.Enter(city, common.randomCity());
        common.Enter(zipCode, common.randomZipCode());
        common.Enter(phoneNumber, common.randomPhoneNumber());
    }

    public void SubmitDetails() throws Exception {
        common.Click(createAccount);
        String text= common.getText(accountCreated);
        Assert.assertEquals("ACCOUNT CREATED!", text);
        Assert.assertTrue("Element should be visible", accountCreated.isDisplayed());
        common.Click(Continue);
    }

    public void DeleteAccount() throws Exception {
        common.Click(deleteAccount);
        String text = common.getText(accountDeleted);
        Assert.assertEquals("ACCOUNT DELETED!",text);
    }

}
