package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NeedHelpPage extends BasePage {

    public NeedHelpPage(WebDriver driver) {
        super(driver);
    }

    By titleNeedHelpBy = By.xpath("//h1[contains(text(), 'Welcome! How can we help?')]");
    By usernameDropdownBy = By.id("user-name");
    By loaderBy = By.xpath("//div[@class='help-desk__container']");

    public NeedHelpPage verifyNeedHelpPageOpened () {
        switchTabs();
        assertEquals(titleNeedHelpBy,"Welcome! How can we help?");
        System.out.print(getURL());
        return this;
    }


}
