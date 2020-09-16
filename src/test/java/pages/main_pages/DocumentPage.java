package pages.main_pages;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import utilities.property.PropertyManager;

public class DocumentPage extends BasePage {

    public DocumentPage(WebDriver driver) {
        super(driver);
    }

    By documentSignButtonBy = By.xpath("//button[contains(text(), 'Annotate')]");
    By manageButtonBy = By.xpath("//button[contains(text(), 'Manage')]");
    By viewFullAuditTrailBy = By.xpath("//button[contains(text(), 'View Full Audit Trail')]");
    By requestSignatureBy = By.xpath("//ul[@class='dropdown-menu']//li[@class='test-requestSignaturesDropdownItem ng-scope']");
    By deleteDocumentBy = By.xpath("//ul[@class='dropdown-menu']//li[@class='test-deleteDropdownItem ng-scope']");
    By redactBy = By.xpath("//ul[@class='toolbar-dropdown-menu test-toolbarDropdownMenu dropdown-menu']//li[@class='test-toolbarDropdownRedactBtn ng-scope']");
    By highlightBy = By.xpath("//ul[@class='toolbar-dropdown-menu test-toolbarDropdownMenu dropdown-menu']//li[@class='test-toolbarDropdownHiglightBtn ng-scope']");
    By textBy = By.xpath("//ul[@class='toolbar-dropdown-menu test-toolbarDropdownMenu dropdown-menu']//li[@class='test-toolbarDropdownTextBtn ng-scope']");
    By timestampBy = By.xpath("//ul[@class='toolbar-dropdown-menu test-toolbarDropdownMenu dropdown-menu']//li[@class='test-toolbarDropdownTimestampBtn ng-scope']");
    By createMonitorQueryBy = By.xpath("//ul[@class='dropdown-menu']//li[@class='test-monitorCreateDropdownItem ng-scope']");
    By approveMonitorBy = By.xpath("//ul[@class='dropdown-menu']//li[@class='test-monitorApproveDropdownItem ng-scope']");
    By changeDocumentSaveButtonBy = By.xpath("//div[@class='col-xs-12 pl-2']//span[@class='btn-group ng-scope']");
    By documentViewportBy = By.xpath("//div[@class='document-viewer-page-wrapper ng-scope']");
    By textBoxBy = By.xpath("//div[@class='text-box h-100']");
    By pageLoadedBy = By.xpath("//img[@class='page loaded']");
    By signButtonBy = By.xpath("//button[@class='btn btn-primary m-0 dropdown-toggle']");
    By addendumPageBy = By.xpath("/html/body/div/app-layout/div/div/document-show/div/section/document-content/div/document-content-editor/div/div[2]/document-toolbar/div/span/span/span/span/ul/li[1]/a");
    By declineButtonBy = By.xpath("//button[contains(text(),'btn btn-primary document-toolbar__signature-button document-toolbar__signature-button--margin ml-2 ng-scope')]");
    By versionButtonBy = By.xpath("//button[@class='btn btn-primary dropdown-toggle test-documentVersionsDropdownBtn ng-binding']");
    By uploadNewVersionBy = By.xpath("//li[@class='test-uploadNewVersionDropdownItem ng-scope']");
    By uploadNewVersionViaEmailBy = By.xpath("//li[@class='test-emailNewVersionDropdownItem ng-scope']");
    By actionButtonBy = By.xpath("//button[@class='document-viewer__page-actions-toggle test-documentViewerPageActionsBtn']");
    By setExpirationDateButtonBy = By.xpath("//button[@class='u-d-block btn btn-primary btn-xs test-setOrChangeExpirationDateBtn']");
    By monitorButtonBy = By.xpath("//button[@class='btn btn-primary test-monitorDropdownBtn ng-scope dropdown-toggle']");
    By saveButtonBy = By.xpath("//a[@ng-click='vm.handleOnSave()']");
    By fontSizeBy = By.xpath("//a[@class='toolbar-dropdown-btn-a test-fontSizeDropdownBtn ng-binding ng-scope']");
    By returnToDocumentButtonBy = By.xpath("//button[@class='btn btn-primary test-signatureCompleteModalCancelBtn']");
    By activeQueryLinkBy = By.xpath("/html/body/div/app-layout/div/div/document-show/div/document-details/section/div[7]/div/ul/li[1]/a/div[3]");

    public DocumentPage returnToDocument () {
        click(returnToDocumentButtonBy);
        return this;
    }

    public DocumentPage signFormWithInputFieldToSign (String textOnInputField) {
        String text = "//div[contains(text(),'" + textOnInputField + "')]";

        waitForElementToBeClickable(By.xpath(text));
        click(By.xpath(text));
        return this;
    }

    public DocumentPage fontSize (String size) {
        String font = "//li[@class='test-fontSizeDropdownOption-" + size + "']";

        click(fontSizeBy);
        click(By.xpath(font));
        return this;
    }

    public DocumentPage saveDocument () {
        click(saveButtonBy);
        return this;
    }

    public DocumentPage markAsApproved () {
        waitForElementToBeClickable(actionButtonBy);
        click(monitorButtonBy);
        click(approveMonitorBy);
        return this;
    }

    public DocumentPage openMonitorQuery () {
        waitForElementToBeClickable(actionButtonBy);
        click(monitorButtonBy);
        click(createMonitorQueryBy);
        return this;
    }

    public DocumentPage openActiveQuery () {
        click(activeQueryLinkBy);
        return this;
    }

    public DocumentPage verifyPlaceholderFilledViaEmail (String placeholderFillDate,String placeholderMovedVia,String originalFileName) {
        String date = "/html/body/div/app-layout/div/div/document-show/div/document-details/section/div[7]/div[1]/p[2]/date-time/span";
        String via = "/html/body/div/app-layout/div/div/document-show/div/document-details/section/div[6]/div[2]/p[2]";
        String document = "/html/body/div/app-layout/div/div/document-show/div/document-details/section/div[6]/div[3]/p[2]";

        assertEquals(By.xpath(date),placeholderFillDate);
        assertEquals(By.xpath(via),placeholderMovedVia);
        assertEquals(By.xpath(document),originalFileName);
        return this;
    }

    public DocumentPage verifyPlaceholderFilled (String placeholderFillDate,String placeholderMovedVia,String originalFileName) {
        String date = "/html/body/div/app-layout/div/div/document-show/div/document-details/section/div[5]/div[3]/p[2]/date-time/span";
        String via = "/html/body/div/app-layout/div/div/document-show/div/document-details/section/div[5]/div[4]/p[2]";
        String document = "/html/body/div/app-layout/div/div/document-show/div/document-details/section/div[5]/div[5]/p[2]";

        assertEquals(By.xpath(date),placeholderFillDate);
        assertEquals(By.xpath(via),placeholderMovedVia);
        assertEquals(By.xpath(document),originalFileName);
        return this;
    }

    public DocumentPage verifyExpirationDateVisible (String expirationDate) {
        String date = "//section[@class='u-d-flex u-flex-wrap mb-4 document-details test-documentDetailsSection']//span[contains(text(),'" + expirationDate + "')]";

        assertEquals(By.xpath(date),expirationDate);
        return this;
    }

    public DocumentPage setExpirationDate () {
        click(setExpirationDateButtonBy);
        return this;
    }

    public DocumentPage checkVersion (String version) {
        assertEquals(versionButtonBy,version);
        return this;
    }

    public DocumentPage uploadNewVersionViaEmail () {
        waitForElementToBeClickable(actionButtonBy);
        click(versionButtonBy);
        click(uploadNewVersionViaEmailBy);
        return this;
    }

    public DocumentPage uploadNewVersion () {
        waitForElementToBeClickable(actionButtonBy);
        click(versionButtonBy);
        click(uploadNewVersionBy);
        return this;
    }

    public String emailToName () {
        String email = PropertyManager.getInstance().getEmail();
        return WordUtils.capitalizeFully(email.substring(0,email.length() - 15).replace("."," "));
    }

    public DocumentPage verifySigners (String signerName,String reason) {
        String signer = "//div[@id='signatures']//div[contains(text(),'" + signerName + " for " + reason + "')]";

        assertEquals(By.xpath(signer),signerName + " for " + reason);
        return this;
    }

    public DocumentPage signAddendumPage () {
        click(signButtonBy);
        waitForElementToBeClickable(addendumPageBy);
        click(addendumPageBy);
        return this;
    }

    public DocumentPage clickAndHold () {
        Actions action = new Actions(driver);
        action.dragAndDropBy(driver.findElement(documentViewportBy), 12, 50).build().perform();
        return this;
    }

    public DocumentPage timestampDocument () {
        waitForElementToBeClickable(pageLoadedBy);
        click(documentSignButtonBy);
        click(timestampBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(documentViewportBy), 0, 0);
        actions.moveByOffset(-400, -100).click().build().perform();
        click(changeDocumentSaveButtonBy);
        return this;
    }

    public DocumentPage textDocument (String text) {
        waitForElementToBeClickable(pageLoadedBy);
        click(documentSignButtonBy);
        click(textBy);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(documentViewportBy), 0, 0);
        actions.moveByOffset(-400, -100).click().build().perform();
        writeText(textBoxBy,text);
        click(changeDocumentSaveButtonBy);
        return this;
    }

    public DocumentPage redactDocument () {
        waitForElementToBeClickable(pageLoadedBy);
        click(documentSignButtonBy);
        click(redactBy);
        Actions action = new Actions(driver);
        action.dragAndDropBy(driver.findElement(documentViewportBy), 35, 50).build().perform();
        click(changeDocumentSaveButtonBy);
        return this;
    }

    public DocumentPage highlightDocument () {
        waitForElementToBeClickable(pageLoadedBy);
        click(documentSignButtonBy);
        click(highlightBy);
        Actions action = new Actions(driver);
        action.dragAndDropBy(driver.findElement(documentViewportBy), 12, 50).build().perform();
        click(changeDocumentSaveButtonBy);
        return this;
    }

    public DocumentPage viewAuditTrail() {
        waitVisibility(documentSignButtonBy);
        click(viewFullAuditTrailBy);
        return this;
    }

    public DocumentPage requestSignature() {
        waitVisibility(documentViewportBy);
        click(manageButtonBy);
        click(requestSignatureBy);
        return this;
    }

    public DocumentPage deleteDocument () {
        click(manageButtonBy);
        click(deleteDocumentBy);
        return this;
    }

    public DocumentPage signButtonVisible() {
        waitVisibility(pageLoadedBy);
        return this;
    }

    public DocumentPage actionButtonVisible () {
        waitVisibility(actionButtonBy);
        return this;
    }
}
