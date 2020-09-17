package tests;

import org.testng.annotations.BeforeClass;
import pages.main_pages.ProfilePage;

public class BaseWithSettingsTest extends BaseWithLoginTest{
    public ProfilePage profilePage;

    @BeforeClass
    public void settings(){
        profilePage = new ProfilePage(driver);

        profilePage.settings();
    }
}
