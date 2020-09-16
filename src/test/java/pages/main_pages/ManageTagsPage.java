package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ManageTagsPage extends BasePage {

    public ManageTagsPage (WebDriver driver) {
        super(driver);
    }

    By createTagButtonBy = By.xpath("//button[contains(text(), 'Create Tag')]");
    By threeDotsDeleteTagBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']/li/a[@class='test-deleteTagBtn ng-scope']");

    public ManageTagsPage createTag () {
        click(createTagButtonBy);
        return this;
    }

    public ManageTagsPage deleteTag (String tagName) {
        String tag = "//a[contains(text(), '" + tagName + "')]/../following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(tag));
        click(threeDotsDeleteTagBy);
        return this;
    }
}
