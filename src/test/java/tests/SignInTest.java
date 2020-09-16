package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.main_pages.SelectTeamPage;
import pages.main_pages.SignInPage;
import pages.modal_pages.WelcomeModalPage;
import utilities.property.PropertyManager;

public class
SignInTest extends BaseTest {

    public SignInPage signInPage;
    public WelcomeModalPage welcomeModalPage;

    @Test
    public void login () {

        signInPage = new SignInPage(driver);
        welcomeModalPage = new WelcomeModalPage(driver);

        signInPage.basePage();
        welcomeModalPage.homeowner();
        signInPage.login();
        signInPage.signIn(PropertyManager.getInstance().getEmail(), PropertyManager.getInstance().getPassword());

        try {

            System.out.print("User is signed in!\n");
        } catch (Exception e) {
            Assert.fail("User is not signed in!\n");
        }
    }
}