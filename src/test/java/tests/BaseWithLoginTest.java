package tests;

import org.testng.annotations.BeforeClass;
import pages.main_pages.SignInPage;
import utilities.property.PropertyManager;

public class BaseWithLoginTest extends BaseTest {

    public SignInPage signInPage;

    @BeforeClass
    public void login () {

        signInPage = new SignInPage(driver);

        signInPage.basePage();
        signInPage.signIn(PropertyManager.getInstance().getEmail(), PropertyManager.getInstance().getPassword());

    }
}
