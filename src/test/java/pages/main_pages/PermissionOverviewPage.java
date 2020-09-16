package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class PermissionOverviewPage extends BasePage {

    public PermissionOverviewPage (WebDriver driver) {
        super(driver);
    }

    By permissionModalBy = By.xpath("//a[@class='test-openPermissionModalBtn ng-binding']");

    public PermissionOverviewPage openPermissionModal () {
        waitForElementToBeClickable(permissionModalBy);
        click(permissionModalBy);
        return this;
    }
}
