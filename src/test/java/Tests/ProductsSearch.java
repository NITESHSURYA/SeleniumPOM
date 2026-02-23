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
    public static ProductsSearch Ps;

    @Before
    public void setUp(){
        super.setUp();
        ls = new loginPage(driver);
        hp = new HomePage(driver);
    }

    @Test
    public void ProductsSearchValidation(){

    }
}
