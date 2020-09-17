package tests.settings;

import org.testng.annotations.Test;
import pages.main_pages.SettingsPage;
import tests.BaseWithSettingsTest;

public class EditTimezoneTest extends BaseWithSettingsTest {
    public SettingsPage settingsPage;

    @Test
    public void editTimezone(){
        settingsPage = new SettingsPage(driver);


    }
}
