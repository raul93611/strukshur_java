package tests;

import org.testng.annotations.BeforeClass;
import pages.main_pages.ProfilePage;
import pages.main_pages.SignInPage;
import pages.modal_pages.WelcomeModalPage;
import utilities.property.PropertyManager;

public class BaseWithLoginTest extends BaseTest {

    public SignInPage signInPage;
    public WelcomeModalPage welcomeModalPage;
    public ProfilePage profilePage;

    @BeforeClass
    public void login () {

        signInPage = new SignInPage(driver);
        welcomeModalPage = new WelcomeModalPage(driver);
        profilePage = new ProfilePage(driver);

        signInPage.basePage();
        welcomeModalPage.homeowner();
        signInPage.login();
        signInPage.signIn(PropertyManager.getInstance().getEmail(), PropertyManager.getInstance().getPassword());
    }
}
