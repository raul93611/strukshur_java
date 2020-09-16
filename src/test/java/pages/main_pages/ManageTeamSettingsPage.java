package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ManageTeamSettingsPage extends BasePage {

    public ManageTeamSettingsPage(WebDriver driver) {
        super(driver);
    }

    By teamNameInputBy = By.id("teamName");
    By saveTeamSettingsButtonBy = By.xpath("//button[contains(text(),'Save Team Settings')]");
    By timezoneSelectBy = By.xpath("/html/body/div/app-layout/div/div/manage-team-settings/section/div[2]/div/div[1]/manage-team-profile/form/div[2]/timezone-picker/select");
    By printerBinderBy = By.id("printerBinder");
    By labelsTabBy = By.xpath("//a[contains(text(),'Labels')]");
    By teamProfileTabBy = By.xpath("//a[contains(text(),'Team Profile')]");
    By createLabelBy = By.xpath("//button[contains(text(),'Create Label')]");
    By deleteLabelBy = By.xpath("//a[@class='test-deleteLabelLink ng-scope']");
    By editLabelBy = By.xpath("//a[@class='test-editLabelLink ng-scope']");
    By auditTrailButtonBy = By.xpath("//button[@class='btn btn-default mr-3 test-auditTrailBtn']");
    By signatureFieldsBy = By.xpath("//input[@ng-model='vm.fields.signatureFieldPlaceholder']");
    By textFieldsBy = By.xpath("//input[@ng-model='vm.fields.textFieldPlaceholder']");

    public ManageTeamSettingsPage signatureAndTextChange (String signatureField,String textField) {
        writeText(signatureFieldsBy,signatureField);
        writeText(textFieldsBy,textField);
        click(saveTeamSettingsButtonBy);
        return this;
    }

    public ManageTeamSettingsPage auditTrail () {
        click(auditTrailButtonBy);
        return this;
    }

    public ManageTeamSettingsPage deleteLabel (String labelName) {
        String label = "//td[contains(text(), '" + labelName + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(labelsTabBy);
        click(By.xpath(label));
        click(deleteLabelBy);
        return this;
    }

    public ManageTeamSettingsPage editLabel (String labelName) {
        String label = "//td[contains(text(), '" + labelName + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(labelsTabBy);
        click(By.xpath(label));
        click(editLabelBy);
        return this;
    }

    public ManageTeamSettingsPage labelCreate () {
        click(labelsTabBy);
        click(createLabelBy);
        return this;
    }

    public ManageTeamSettingsPage renameTeam (String newTeamName) {
        writeText(teamNameInputBy,newTeamName);
        click(saveTeamSettingsButtonBy);
        return this;
    }

    public ManageTeamSettingsPage timezoneChange (String timezone) {
        selectOption(timezoneSelectBy,timezone);
        click(saveTeamSettingsButtonBy);
        return this;
    }

    public ManageTeamSettingsPage selectBinderPrinter () {
        click(printerBinderBy);
        return this;
    }

    public ManageTeamSettingsPage saveTeamSettings () {
        click(saveTeamSettingsButtonBy);
        return this;
    }
}
