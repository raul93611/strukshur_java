package pages.modal_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class WelcomeModalPage extends BasePage {

    public WelcomeModalPage(WebDriver driver) {
        super(driver);
    }
    By modalWindowBy = By.xpath("//div[@class='modal modal-new-visitor fade ng-scope ng-isolate-scope in']");
    By homeownerButtonBy = By.xpath("//button[contains(text(), 'Homeowner')]");
    By professionalButtonBy = By.xpath("//button[@class='btn hidden-xs'][contains(text(),\"I'm a Professional\")]");

    public WelcomeModalPage homeowner(){
        waitForElementToFadeIn(modalWindowBy, "opacity", "1");
        click(homeownerButtonBy);
        return this;
    }
}
