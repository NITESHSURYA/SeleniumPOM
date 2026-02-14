package Utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
    public static WebDriver driver;
    public  WebDriverWait wait;

    public CommonMethods(WebDriver driver) {
        CommonMethods.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    Faker faker = new Faker();
    public String randomPass() throws Exception {
        try {
            return faker.internet().password();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public String randomEmail(){
        return faker.internet().emailAddress();
    }

    public String randonName(){
        return faker.name().username();
    }

    public void Click(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }catch (RuntimeException e){
            throw new ElementNotInteractableException("Element is not clickable",e);
        }
    }
}
