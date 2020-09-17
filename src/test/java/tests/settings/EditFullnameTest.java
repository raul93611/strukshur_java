package tests.settings;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.global_pages.NotificationsPage;
import pages.main_pages.SettingsPage;
import tests.BaseWithSettingsTest;

public class EditFullnameTest extends BaseWithSettingsTest {
    public SettingsPage settingsPage;
    public NotificationsPage notificationsPage;

    @Test
    public void editFullname(){
        settingsPage = new SettingsPage(driver);
        notificationsPage = new NotificationsPage(driver);

        String newName = "Luis Cardozo";
        settingsPage.editFullname(newName);

        try{
            notificationsPage.verifyNotification("Basics Edited");
            System.out.print("Fullname edited!");
        }catch(Exception e){
            Assert.fail("Fullname was not edited!");
        }
    }
}
