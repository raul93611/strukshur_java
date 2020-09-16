package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ShortcutPage extends BasePage {

    public ShortcutPage(WebDriver driver) {
        super(driver);
    }

    By originalDocumentMissingBy = By.xpath("//h5[@class='no-preview-title ng-scope']");

    public ShortcutPage verifyOriginalDocumentDeleted () {
        assertEquals(originalDocumentMissingBy,"The Original Document of this Shortcut No Longer Exists.");
        return this;
    }
}
