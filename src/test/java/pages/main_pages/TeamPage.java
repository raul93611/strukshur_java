package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TeamPage extends BasePage {

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    By createBinderButtonBy = By.xpath("//button[contains(text(), 'Create Binder')]");
    By threeDotsDeleteBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-deleteLink ng-scope')]");
    By threeDotsImportStructureBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-importFStructureLink ng-scope')]");
    By threeDotsRenameBinderBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-editLink ng-scope')]");
    By threeDotsDownloadBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-downloadLink ng-scope')]");
    By actionsButtonBy = By.xpath("//button[@class='btn btn-default mr-3 test-manageSelectedLink dropdown-toggle']");
    By actionsAuditTrailBy = By.xpath("//a[@class='test-auditTrailLink ng-scope']");

    public TeamPage auditTrail (String binderName) {
        String binder = "//a[contains(text(),'" + binderName + "')]/../preceding-sibling::div[@class='c-infinite-table__cell']";

        click(By.xpath(binder));
        click(actionsButtonBy);
        click(actionsAuditTrailBy);
        return this;
    }

    public TeamPage toTeamPage (String teamName) {
        String team = "//div[contains(text(),'" + teamName + "')]";
        click(By.xpath(team));

        return this;
    }

    public TeamPage createBinder () {
        waitForElementToBeClickable(createBinderButtonBy);
        click(createBinderButtonBy);
        return this;
    }

    public TeamPage openBinder (String binderName) {
        String binder = "//a[contains(text(),'" + binderName + "')]";

        click(By.xpath(binder));
        return this;
    }

    public TeamPage importStructure (String binderName) {
        String binder = "//a[contains(text(),'" + binderName + "')]";
        String binderMenu = binder + "/../following::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']/a/i[@class='fas fa-ellipsis-v']";

        waitForElementToBeClickable(By.xpath(binder));
        click(By.xpath(binderMenu));
        waitForElementToBeClickable(threeDotsImportStructureBy);
        click(threeDotsImportStructureBy);
        return this;
    }

    public TeamPage deleteBinder (String binderName) {
        String binder = "//a[contains(text(),'" + binderName + "')]";
        String binderMenu = binder + "/../following::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']/a/i[@class='fas fa-ellipsis-v']";

        waitForElementToBeClickable(By.xpath(binder));
        click(By.xpath(binderMenu));
        waitForElementToBeClickable(threeDotsDeleteBy);
        click(threeDotsDeleteBy);
        return this;
    }

    public TeamPage renameUpdateBinder (String binderName) {
        String binder = "//a[contains(text(),'" + binderName + "')]";
        String binderMenu = binder + "/../following::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']/a/i[@class='fas fa-ellipsis-v']";

        waitForElementToBeClickable(By.xpath(binder));
        click(By.xpath(binderMenu));
        waitForElementToBeClickable(threeDotsRenameBinderBy);
        click(threeDotsRenameBinderBy);
        return this;
    }

    public TeamPage downloadBinder (String binderName) {
        String binder = "//a[contains(text(),'" + binderName + "')]";
        String binderMenu = binder + "/../following::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']/a/i[@class='fas fa-ellipsis-v']";

        waitForElementToBeClickable(By.xpath(binder));
        click(By.xpath(binderMenu));
        waitForElementToBeClickable(threeDotsDownloadBy);
        click(threeDotsDownloadBy);
        return this;
    }
}
