package Tests;

import Base.BaseSetup;
import Pages.HomePage;
import Pages.ProductsPage;
import Pages.loginPage;
import org.junit.Before;
import org.junit.Test;

public class ProductsSearch extends BaseSetup {
    public static loginPage ls;
    public static HomePage hp;
    public static ProductsPage Ps;

    @Before
    public void setUp(){
        super.setUp();
        ls = new loginPage(driver);
        hp = new HomePage(driver);
        Ps = new ProductsPage(driver);
    }

    @Test
    public void ProductsSearchValidation() throws Exception {
        Ps.ClickOnProducts();
        Ps.ProductPage();
        Ps.ProductValidation();
    }
}
