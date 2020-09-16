package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.property.PropertyManager;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    By emailBy = By.id("email");
    By passwordBy = By.id("_password");
    By nextButtonBy = By.xpath("//button[contains(text(), 'Next')]");
    By loginSubmitButtonBy = By.id("submit");
    By signUpButtonBy = By.id("sign-up-pw-btn");
    By messageSignInFailed = By.xpath("//div[contains(text(), 'Your email or password was incorrect.')]");
    By loginButtonBy = By.xpath("//button[contains(text(), 'Login')]");

    String baseURL = PropertyManager.getInstance().getURL();

    public SignInPage basePage() {
        driver.get(baseURL);
        return this;
    }

    public SignInPage login(){
        click(loginButtonBy);
        return this;
    }

    public SignInPage signIn(String email, String password) {
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(loginSubmitButtonBy);
        return this;
    }

    public SignInPage signUp() {
        click(signUpButtonBy);
        return this;
    }

    public SignInPage signInSAML(String email) {
        writeText(emailBy, email);
        click(nextButtonBy);
        return this;
    }

    public SignInPage verifyButtonDisabled(By elementBy, String attributeName, String expectedText) {
        assertEqualsAttributes(elementBy, attributeName, expectedText);
        return this;
    }
}

