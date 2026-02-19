package Tests;

import Base.BaseSetup;
import Pages.HomePage;
import Pages.loginPage;
import org.junit.Before;
import org.junit.Test;

public class LoginTests extends BaseSetup {

    public static loginPage ls;
    public static HomePage hp;

    @Before
    public void setUp(){
        super.setUp();
         ls = new loginPage(driver);
         hp = new HomePage(driver);
    }

    @Test
    public void TC01() throws Exception {
        ls.signup();
        ls.ClickTitle();
        ls.EnterDetails();
        ls.SubmitDetails();
        ls.DeleteAccount();

    }

    @Test
    public void TC02() throws Exception{
        ls.signup();
        ls.ClickTitle();
        ls.EnterDetails();
        ls.SubmitDetails();
        hp.UserLogout();
    }
}
