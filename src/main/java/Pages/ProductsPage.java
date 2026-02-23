package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void ClickOnProducts() throws Exception {
        common.Click(Products);
    }

    public void ProductsPage() throws Exception {
        common.Enter(SearchBar,"TShirt");
        common.Click(SearchButton);
    }


}
