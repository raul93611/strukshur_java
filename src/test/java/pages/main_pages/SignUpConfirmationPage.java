package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utilities.property.PropertyManager;

public class SignUpConfirmationPage extends BasePage {

    public SignUpConfirmationPage(WebDriver driver) {
        super(driver);
    }

    By nextStepBy = By.xpath("//h1[contains(text(), 'Next Step: Confirm Email')]");

    public SignUpConfirmationPage verifyUserSignedUp (String expectedText) {
        assertEquals(nextStepBy,expectedText);
        return this;
    }
}
