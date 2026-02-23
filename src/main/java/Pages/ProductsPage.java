package Pages;

import Utils.CommonMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    CommonMethods common;

    public ProductsPage(WebDriver driver) {
        loginPage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.common = new CommonMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()=' Products']")
    public WebElement Products;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement SearchBar;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement SearchButton;

    @FindBy(xpath = "//div[contains(@class,'productinfo')]//p")
    public WebElement ProductNames;

    public By ProductName = By.xpath("//div[contains(@class,'productinfo')]//p");

    public void ClickOnProducts() throws Exception {
        common.Click(Products);
    }

    public void ProductPage() throws Exception {
        common.Enter(SearchBar,"TShirt");
        common.Click(SearchButton);
    }

    public void ProductValidation(){
        List<WebElement> products=common.findElements(ProductName);
        for (WebElement product : products) {
            String Name = common.getText(product);
            String CleanedName = Name.toLowerCase();
            if (!Name.contains("tshirt") || !Name.contains("T-shirt") || !Name.contains("Tshirt")) {
                Assert.fail("Product Name does not have Tshirt init");
            }
        }
    }
}
