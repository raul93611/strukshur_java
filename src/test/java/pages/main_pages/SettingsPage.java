package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SettingsPage extends BasePage {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    By fullnameInputBy = By.id("full-name");
    By saveButtonBy = By.xpath("//div[@class='tab-pane ng-scope active']//button[1]");

    public SettingsPage editFullname(String newName){
        writeText(fullnameInputBy, newName);
        waitForElementToBeClickable(saveButtonBy);
        clickJS(saveButtonBy);
        return this;
    }
}
