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

        text.put("Basics Edited","Basic info updated successfully!");

        String string = text.get(key);
        String xpath = "//div[contains(text(), '" + string + "')]";

        waitForElementToBeClickable(By.xpath(xpath));
        assertEquals(By.xpath(xpath),string);
        click(By.xpath(xpath));
        return this;
    }

}