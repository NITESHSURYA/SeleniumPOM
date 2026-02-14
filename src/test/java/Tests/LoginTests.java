package Tests;

import Base.BaseSetup;
import Pages.loginPage;
import org.junit.Before;
import org.junit.Test;

public class LoginTests extends BaseSetup {

    public static loginPage ls;

    @Before
    public void setUp(){
        super.setUp();
         ls = new loginPage(driver);
    }

    @Test
    public void TC01() throws Exception {
        ls.signup();

    }
}
