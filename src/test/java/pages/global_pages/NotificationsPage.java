package pages.global_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.HashMap;

public class NotificationsPage extends BasePage {

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    public NotificationsPage verifyNotification (String key) {

        HashMap <String,String> text = new HashMap <> ();

        text.put("Tags Updated","Tags Updated!");
        text.put("Task Created","Task Created!");
        text.put("Document annotated","Document annotated successfully." );
        text.put("Document type and status updated","Document type and status updated.");
        text.put("Folder structure","Folder structure successfully imported.");
        text.put("Tag Created","Tag Created!");
        text.put("User Roles Updated","User Roles Updated!");
        text.put("Team name updated","Team name updated.");
        text.put("Team timezone updated","Team timezone updated.");
        text.put("Printer Updated","Team printer upload binder updated.");
        text.put("Label Deleted","Label successfully deleted.");
        text.put("Updated label","Updated label.");
        text.put("Binder updated","Binder updated");
        text.put("Folder updated","Folder updated.");
        text.put("Folder Created","Folder created.");
        text.put("Folder deleted","Folder deleted.");
        text.put("Document signed","Document signed successfully.");
        text.put("Placeholder moved","Placeholder moved.");
        text.put("Role duplicated","Role duplicated!");
        text.put("Permissions Updated","Permissions Updated!");
        text.put("Role Updated","Role Updated!");
        text.put("Role Deleted","Role Deleted!");
        text.put("Monitor review created","Monitor review created!");
        text.put("Monitor review status updated","Monitor review status updated!");
        text.put("Document Approved","Document marked as approved!");
        text.put("Team form field text updated","Team form field text updated.");
        text.put("Finalizing document","Finalizing document, this may take a minute.");
        text.put("Document signed, annotated and finalized","Document signed, annotated and finalized successfully.");
        text.put("Document finalized","Document finalized successfully.");
        text.put("Shortcut Created","Successfully created 1 shortcut(s)!\n" + "CLICK HERE FOR DETAILS");
        text.put("Teammate Added","1 member(s) added to the team!");
        text.put("Binder created","Binder created.");

        String string = text.get(key);
        String xpath = "//div[contains(text(), '" + string + "')]";

        waitForElementToBeClickable(By.xpath(xpath));
        assertEquals(By.xpath(xpath),string);
        click(By.xpath(xpath));
        return this;
    }

    public NotificationsPage verifyNotificationWithName (String name, String expectedText, String key) {

        HashMap <String,String> xpath = new HashMap <> ();

        xpath.put("Role","//div[starts-with(text(), 'Role " + name + " created!')]");
        xpath.put("Duplicated to","//div[starts-with(text(), 'Successfully duplicated to " + name + ".')]");
        xpath.put("Due Date","//div[contains(text(), 'Document " + name + " due date updated.')]");
        xpath.put("Expiration Date","//div[contains(text(), 'Document " + name + " expiration date updated.')]");
        xpath.put("Moved to","//div[contains(text(), 'Successfully moved to " + name + ".')]");
        xpath.put("Renamed","//div[contains(text(), 'Document name updated to \"" + name + "\".')]");
        xpath.put("Label Created","//div[contains(text(), 'Created label " + name + ".')]");
        xpath.put("StartsName","//div[starts-with(text(), '" + name + "')]");
        xpath.put("Delete Tag","//div[contains(text(), 'Successfully deleted tag " + name + "!')]");
        xpath.put("Duplicate","//div[starts-with(text(), '" + name + " successfully duplicated.')]");
        xpath.put("Move","//div[starts-with(text(), '" + name + " successfully moved.')]");
        xpath.put("Deleted","//div[contains(text(), '" + name + " deleted.')]");
        xpath.put("Teammate Removed","//div[contains(text(), '" + name + " has been removed from the team.')]");
        xpath.put("Placeholder Created","//div[contains(text(), '" + name + " placeholder created.')]");
        xpath.put("Binder Deleted","//div[contains(text(),'Binder " + name +" deleted.')]");

            String message = xpath.get(key);
            waitForElementToFadeIn(By.xpath(message),"opacity","1");
            assertEquals(By.xpath(message), expectedText);

        return this;
    }

    By downloadStartedMessageBy =   By.xpath("//div[@class='ui-notification ng-scope info']//div[@class='message ng-binding']//a[@class='page-action u-d-inline']");
    By documentReadyToDownloadBy = By.xpath("//a[contains(text(), 'CLICK TO DOWNLOAD')]");

    public NotificationsPage verifyDownloadStarted () {
        waitForElementToBeClickable(downloadStartedMessageBy);
        assertEquals(downloadStartedMessageBy,"MY DOWNLOADS");
        return this;
    }

    public NotificationsPage verifyGreenMessageDownloadComplete () {
        waitForElementToBeClickable(documentReadyToDownloadBy);
        assertEquals(documentReadyToDownloadBy,"CLICK TO DOWNLOAD");
        return this;
    }

}