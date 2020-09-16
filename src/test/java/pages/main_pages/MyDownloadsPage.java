package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MyDownloadsPage extends BasePage {

    public MyDownloadsPage(WebDriver driver) {
        super(driver);
    }

    By checkboxDownloadedItemsBy = By.xpath("//th[@class='col-xs-1 hidden-xs']//i[@class='far fa-fw fa-square checkbox-icon']");
    By actionsButtonBy = By.xpath("//button[contains(text(),'Actions')]");
    By deleteDropdownButtonBy = By.xpath("//*[@id='app']/app-layout/div/div/downloads-index/section/div[1]/div/ul/li[1]/a");

    public MyDownloadsPage verifyDocumentDownloaded (String fullDocumentName, String documentStatus) {
        String document = "//a[contains(text(),'" + fullDocumentName + "')]";
        String status = "//td[contains(text(),'" + documentStatus + "')]";

        waitForElementToBeClickable(By.xpath(document));
        assertEquals(By.xpath(status),documentStatus);
        assertEquals(By.xpath(document),fullDocumentName);
        return this;
    }

    public MyDownloadsPage verifyAuditTrailDownloaded (String binderNameAndFileName, String documentStatus, String fullBinderNameAndFileName) {
        String auditTrail = "//a[contains(text(),'" + binderNameAndFileName + "')]";
        String status = "//td[contains(text(),'" + documentStatus + "')]";
        String auditTrailPDF = "//a[contains(text(),'" + fullBinderNameAndFileName + "')]";

        waitForElementToBeClickable(By.xpath(auditTrail));
        assertEquals(By.xpath(status),documentStatus);
        assertEquals(By.xpath(auditTrailPDF),fullBinderNameAndFileName);
        return this;
    }

    public MyDownloadsPage deleteAllDownloadedItems () {
        click(checkboxDownloadedItemsBy);
        click(actionsButtonBy);
        click(deleteDropdownButtonBy);
        return this;
    }

}
