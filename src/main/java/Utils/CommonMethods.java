package Utils;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    public void Click(WebElement element)throws Exception{
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            Thread.sleep(500);
            element.click();
        }catch (RuntimeException e){
            throw new ElementNotInteractableException("Element is not clickable",e);
        }
    }

    public void Enter(WebElement element,String enterText)throws Exception{
        try{
            Thread.sleep(500);
            element.sendKeys(enterText);
        }catch (RuntimeException e){
            throw new ElementNotInteractableException("Element is not clickable",e);
        }
    }

    public String randomAddress(){
       return faker.address().fullAddress();
    }

    public String randomState(){
       return faker.country().capital();
    }

    public String randomPhoneNumber(){
      return faker.phoneNumber().cellPhone();
    }

    public String randomZipCode(){
        return faker.address().zipCode();
    }

    public String randomCity(){
        return faker.address().city();
    }

    public List<WebElement> getAllElements(String xpathExpression) {
        if (xpathExpression == null || xpathExpression.isEmpty()) {
            throw new IllegalArgumentException("XPath expression cannot be null or empty");
        }
        try {
            return driver.findElements(By.xpath(xpathExpression));
        } catch (Exception e) {
            throw new RuntimeException("Failed to find elements with XPath: " + xpathExpression, e);
        }
    }

    public String getText(WebElement element){
        if(element == null){
            throw new IllegalArgumentException("Xpath cannot be null or empty");
        }
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        }catch (Exception e){
            throw new RuntimeException("Failed to find the text with the xpath"+ e.getMessage());
        }
    }
}
