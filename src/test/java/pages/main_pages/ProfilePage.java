package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    By userMenuBy = By.xpath("//div[@class='username ng-binding']");
    By logoutButtonBy = By.xpath("//a[contains(text(),'Logout')]");
    By settingsButtonBy = By.xpath("//a[contains(text(), 'Settings')]");

    public ProfilePage verifySignIn(String expectedText){
        moveToElement(userMenuBy);
        assertEquals(logoutButtonBy, expectedText);
        return this;
    }

    public ProfilePage settings(){
        moveToElement(userMenuBy);
        click(settingsButtonBy);
        return this;
    }
}
