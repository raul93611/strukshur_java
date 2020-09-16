package pages.main_pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    By emailBy = By.id("email-input");
    By firstNameBy = By.id("first-name-input");
    By lastNameBy = By.id("last-name-input");
    By companyNameBy = By.id("orgName");
    By jobTitleBy = By.id("jobTitle");
    By passwordBy = By.id("password-input");
    By passwordConfirmationBy = By.id("confirmation-input");
    By companyTypeBy = By.cssSelector("form div:nth-child(4) select");
    By jobFunctionBy = By.cssSelector("form div:nth-child(6) select");
    By signUpButtonBy = By.xpath("//button[contains(text(), 'Sign Up')]");

    public SignUpPage signUp (String email, String firstName, String lastName, String companyType, String companyName, String jobFunction, String jobTitle, String password, String passwordConfirmation) {
        writeText(emailBy, email);
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        if (StringUtils.isNotBlank(companyType)) {
            selectOption(companyTypeBy, companyType);
        }
        writeText(companyNameBy, companyName);
        if (StringUtils.isNotBlank(jobFunction)) {
            selectOption(jobFunctionBy, jobFunction);
        }
        writeText(jobTitleBy, jobTitle);
        writeText(passwordBy, password);
        writeText(passwordConfirmationBy, passwordConfirmation);
        click(signUpButtonBy);
        return this;
    }

    public SignUpPage verifySignUpButtonDisabled (String attributeName , String expectedText) {
        assertEqualsAttributes(signUpButtonBy, attributeName , expectedText);
        return this;
    }
}
