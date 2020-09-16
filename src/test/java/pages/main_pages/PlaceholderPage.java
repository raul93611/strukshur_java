package pages.main_pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.io.File;

public class PlaceholderPage extends BasePage {

    public PlaceholderPage(WebDriver driver) {
        super(driver);
    }

    By manageButtonBy = By.xpath("//a[@class='btn btn-primary test-manageDocumentDropdownBtn dropdown-toggle']");
    By assignTagsBy = By.xpath("//li[@class='test-assignTagsDropdownItem ng-scope']");
    By createTaskBy = By.xpath("//li[@class='test-createTaskDropdownItem ng-scope']");
    By deleteBy = By.xpath("//li[@class='test-deleteDropdownItem ng-scope']");
    By duplicateBy = By.xpath("//li[@class='test-duplicateDropdownItem ng-scope']");
    By moveBy = By.xpath("//li[@class='test-moveDropdownItem ng-scope']");
    By dropzoneBy = By.xpath("//div[@class='text-center dropzone test-fileDropzone ng-pristine ng-untouched ng-valid ng-not-empty']");
    By versionButtonBy = By.xpath("//a[@class='btn btn-primary dropdown-toggle test-versionDropdownBtn']");
    By fillViaEmailBy = By.xpath("//li[@class='test-fillViaEmailDropdownItem ng-scope']");
    By fillWithEBindersBy = By.xpath("//li[@class='test-fillWithDocumentDropdownItem ng-scope']");
    By setDueDateBy = By.xpath("//button[@class='u-d-block btn btn-primary btn-xs']");
    By assignDocumentTypeBy = By.xpath("//button[@class='u-d-block btn btn-primary btn-xs test-assignDocumentCategoryBtn ng-scope']");
    By viewFullAuditTrailBy = By.xpath("//button[@class='u-d-block btn btn-primary btn-xs test-viewFullAuditTrailBtn ng-scope']");
    By renameButtonBy = By.xpath("//button[@class='u-d-block btn btn-primary btn-xs test-renameBtn']");

    public PlaceholderPage fillViaEmail () {
        waitForElementToBeClickable(versionButtonBy);
        click(versionButtonBy);
        click(fillViaEmailBy);
        return this;
    }

    public PlaceholderPage fillWithDocument () {
        waitForElementToBeClickable(versionButtonBy);
        click(versionButtonBy);
        click(fillWithEBindersBy);
        return this;
    }

    public PlaceholderPage movePlaceholder () {
        waitForElementToBeClickable(manageButtonBy);
        click(manageButtonBy);
        click(moveBy);
        return this;
    }

    public PlaceholderPage duplicatePlaceholder () {
        waitForElementToBeClickable(manageButtonBy);
        click(manageButtonBy);
        click(duplicateBy);
        return this;
    }

    public PlaceholderPage verifyTypeVisible (String documentStatus,String documentType) {
        String type = "//section[@class='u-d-flex u-flex-wrap mb-4 document-details test-documentDetailsSection']//p[contains(text(),'" + documentType + "')]";
        String status = "//section[@class='u-d-flex u-flex-wrap mb-4 document-details test-documentDetailsSection']//p[contains(text(),'" + documentStatus + "')]";

        assertEquals(By.xpath(type),documentType);
        assertEquals(By.xpath(status),documentStatus);
        return this;
    }

    public PlaceholderPage assignType () {
        waitForElementToBeClickable(assignDocumentTypeBy);
        click(assignDocumentTypeBy);
        return this;
    }

    public PlaceholderPage verifyTags (String tagsAssigned) {
        String date = "//section[@class='u-d-flex u-flex-wrap mb-4 document-details test-documentDetailsSection']//span[contains(text(),'" + tagsAssigned + "')]";

        assertEquals(By.xpath(date),tagsAssigned);
        return this;
    }

    public PlaceholderPage assignTags () {
        waitForElementToBeClickable(manageButtonBy);
        click(manageButtonBy);
        click(assignTagsBy);
        return this;
    }

    public PlaceholderPage verifyDueDateVisible (String expirationDate) {
        String date = "//section[@class='u-d-flex u-flex-wrap mb-4 document-details test-documentDetailsSection']//span[contains(text(),'" + expirationDate + "')]";

        assertEquals(By.xpath(date),expirationDate);
        return this;
    }

    public PlaceholderPage dueDateSet () {
        waitForElementToBeClickable(setDueDateBy);
        click(setDueDateBy);
        return this;
    }

    public PlaceholderPage dragAndDrop (String fileNamePath) {
        DropFile(new File(fileNamePath), driver.findElement(dropzoneBy), 30, 30);
        return this;
    }

    public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if(!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, 30);

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input = (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        wait.until(ExpectedConditions.stalenessOf(input));
    }
}
