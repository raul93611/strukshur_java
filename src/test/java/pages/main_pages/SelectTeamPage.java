package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SelectTeamPage extends BasePage {

    public SelectTeamPage(WebDriver driver) {
        super(driver);
    }

    By userMenuBy = By.id("user-menu");
    By signOutButtonBy = By.xpath("//a[@class='test-signOutLink']");
    By settingsMenuBy = By.id("admin-menu");
    By manageTeamMembersBy = By.xpath("//a[@class='test-manageMembersLink-navBar']");
    By manageTeamSettingsBy = By.xpath("//a[@class='test-manageProfileLink-navBar']");
    By manageTagsBy = By.xpath("//a[@class='test-manageTagsLink-navBar']");
    By manageRolesBy = By.xpath("//a[@class='test-manageRolesLink-navBar']");

    public SelectTeamPage verifySignIn (String expectedText) {
        click(userMenuBy);
        assertEquals(signOutButtonBy, expectedText);
        return this;
    }

    public SelectTeamPage selectTeam (String teamName) {
        String team = "//td[contains(text(),'" + teamName + "')]";

        waitForElementToBeClickable(By.xpath(team));
        click(By.xpath(team));
        return this;
    }

    public SelectTeamPage manageTeamSettings () {
        click(settingsMenuBy);
        click(manageTeamSettingsBy);
        return this;
    }

    public SelectTeamPage manageTeamMembers () {
        click(settingsMenuBy);
        click(manageTeamMembersBy);
        return this;
    }

    public SelectTeamPage manageTags () {
        click(settingsMenuBy);
        click(manageTagsBy);
        return this;
    }

    public SelectTeamPage manageRoles () {
        click(settingsMenuBy);
        click(manageRolesBy);
        return this;
    }

}