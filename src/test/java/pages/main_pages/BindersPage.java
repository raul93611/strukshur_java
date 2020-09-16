package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class BindersPage extends BasePage {

    public BindersPage(WebDriver driver) {
        super(driver);
    }

    By threeDotsDownloadBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-downloadLink ng-scope')]");
    By threeDotsDeleteBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-deleteLink ng-scope')]");
    By threeDotsCreateTaskBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-createTaskLink ng-scope')]");
    By threeDotsRenameUpdateBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-editLink ng-scope')]");
    By threeDotsAssignTagsBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-assignTagsLink ng-scope')]");
    By threeDotsAssignTypeBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-assignCategoyLink ng-scope')]");
    By threeDotsDuplicateBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-duplicateLink ng-scope')]");
    By threeDotsMoveBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-moveLink ng-scope')]");
    By createNewButtonBy = By.xpath("//button[contains(text(), 'Create New')]");
    By newPlaceholderBy = By.xpath("//*[@id='app']/app-layout/div/div/folder-show/section/div[2]/div[1]/ul/li[2]/a");
    By newFolderBy = By.xpath("//*[@id='app']/app-layout/div/div/folder-show/section/div[2]/div[1]/ul/li[1]/a");
    By importShortcutBy = By.xpath("//*[@id='app']/app-layout/div/div/folder-show/section/div[2]/div[1]/ul/li[3]/a");
    By filterInputBy = By.cssSelector(".test-tableFilterInput");
    By infiniteListBy = By.xpath("//div[@class='infinite-table__row u-user-select-none ng-scope folder-show__item--loaded']");
    By rootOfListBy = By.xpath("//div[@class='md-virtual-repeat-offsetter']");
    By bindersBreadCrumbBy = By.xpath("//a[@class='white-space-pre-wrap test-BindersLink']");
    By actionsButtonBy = By.xpath("//button[@class='btn btn-default mr-3 test-manageSelectedLink dropdown-toggle']");
    By actionsAuditTrailBy = By.xpath("//a[@class='test-auditTrailLink ng-scope']");

    public BindersPage auditTrail (String folderName) {
        String folder = "//a[contains(text(),'" + folderName + "')]/../preceding-sibling::div[@class='c-infinite-table__cell']";

        click(By.xpath(folder));
        click(actionsButtonBy);
        click(actionsAuditTrailBy);
        return this;
    }

    public BindersPage renameUpdateFolder (String folderName) {
        String folder = "//a[contains(text(),'" + folderName + "')]/../following-sibling::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(folder));
        click(threeDotsRenameUpdateBy);
        return this;
    }

    public BindersPage moveFolder (String folderName) {
        String folder = "//a[contains(text(),'" + folderName + "')]/../following-sibling::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(folder));
        click(threeDotsMoveBy);
        return this;
    }

    public BindersPage duplicateFolder (String folderName) {
        String folder = "//a[contains(text(),'" + folderName + "')]/../following-sibling::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(folder));
        click(threeDotsDuplicateBy);
        return this;
    }

    public BindersPage filter (String searchString) {
        writeText(filterInputBy,searchString);
        return this;
    }

    public BindersPage checkDocumentPresent (String documentName) {
        String document = "//a[contains(text(),'" + documentName + "')]";

        waitVisibility(By.xpath(document));
        waitForElementToBeClickable(By.xpath(document));
        return this;
    }

    public BindersPage emptyList () {
        WebElement root = driver.findElement(rootOfListBy);
        int childs = root.findElements(infiniteListBy).size();
        if (childs == 0) {
            System.out.print("File is not in search list!");
        } else {
            System.out.print("Search found not empty list!");
        }
        return this;
    }

    public BindersPage createNewPlaceholder () {
        waitForElementToBeClickable(createNewButtonBy);
        click(createNewButtonBy);
        click(newPlaceholderBy);
        return this;
    }

    public BindersPage createNewFolder () {
        waitForElementToBeClickable(createNewButtonBy);
        click(createNewButtonBy);
        click(newFolderBy);
        return this;
    }

    public BindersPage importShortcut () {
        waitForElementToBeClickable(createNewButtonBy);
        click(createNewButtonBy);
        click(importShortcutBy);
        return this;
    }

    public BindersPage viewDocument (String documentName) {
        String document = "//a[contains(text(),'" + documentName + "')]";
        click(By.xpath(document));
        return this;
    }

    public BindersPage threeDots (String elementName) {
        String anyElement = "//a[contains(text(),'" + elementName + "')]/../following-sibling::div[@class='c-infinite-table__cell mr-3 dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(anyElement));
        return this;
    }

    public BindersPage duplicateDocument () {
        click(threeDotsDuplicateBy);
        return this;
    }

    public BindersPage moveDocument () {
        click(threeDotsMoveBy);
        return this;
    }

    public BindersPage assignType () {
        click(threeDotsAssignTypeBy);
        return this;
    }

    public BindersPage downloadDocument () {
        click(threeDotsDownloadBy);
        return this;
    }

    public BindersPage createTask () {
        click(threeDotsCreateTaskBy);
        return this;
    }

    public BindersPage assignTags () {
        click(threeDotsAssignTagsBy);
        return this;
    }

    public BindersPage deleteDocument () {
        click(threeDotsDeleteBy);
        return this;
    }

    public BindersPage renameUpdate () {
        click(threeDotsRenameUpdateBy);
        return this;
    }

    public void waitForEmailImport (String documentName) {
        String document = "//a[contains(text(),'" + documentName + "')]";

        driver.navigate().refresh();
        driver.findElement(By.xpath(document));
    }
}
