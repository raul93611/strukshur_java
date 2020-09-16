package pages.global_pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.io.File;

public class SideBarPage extends BasePage {

    public SideBarPage(WebDriver driver) {
        super(driver);
    }

    By dragAndDropAreaBy = By.cssSelector(".nav-menu__dropzone");
    By importViaEmailBy = By.xpath("//*[@id='app']/app-layout/div/div/folder-show/nav-menu/nav/div/button");
    By myDownloadsBy = By.xpath("//a[@class='test-myDownloadsLink-navMenu']");
    By bindersBy = By.xpath("//a[@class='test-bindersLink-navMenu']");
    By needHelpLinkBy = By.cssSelector("nav-menu > nav > ul > li:nth-child(7) > a");
    By inputFieldForUploadBy = By.xpath("//upload-link[@class='u-font-weight-bold test-importBrowse']");
    By inputFieldBy = By.id("upload-link-input");

    public SideBarPage changeDisplayAttribute () {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(inputFieldForUploadBy);
        jse.executeScript("arguments[0].children[1].style.setProperty('display','block', 'important');", element);
        return this;
    }

    public SideBarPage uploadFile (String fileName) {
        writeText(inputFieldBy,fileName);
        return this;
    }

    public SideBarPage myDownloadsPage () {
        click(myDownloadsBy);
        return this;
    }

    public SideBarPage bindersPage () {
        click(bindersBy);
        return this;
    }

    public SideBarPage importViaEmail () {
        waitForElementToBeClickable(importViaEmailBy);
        click(importViaEmailBy);
        return this;
    }


    public SideBarPage needHelpPage () {
        click(needHelpLinkBy);
        return this;
    }

    public SideBarPage dragAndDrop (String fileNamePath) {
        DropFile(new File(fileNamePath), driver.findElement(dragAndDropAreaBy), 30, 30);
        return this;
    }

    public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if(!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

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
                        "      dataTransfer = { files: this.files, types: ['Files'], items: [{ kind: 'file'}] };" +
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
