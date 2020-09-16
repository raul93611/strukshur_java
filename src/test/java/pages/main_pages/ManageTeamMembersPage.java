package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ManageTeamMembersPage extends BasePage {

    public ManageTeamMembersPage (WebDriver driver) {
        super(driver);
    }

    By addMembersButtonBy = By.xpath("//button[@class='btn btn-default mr-3 u-position-relative test-AddMembersBtn']");
    By threeDotsRemoveMemberBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-removeBtn ng-scope')]");
    By threeDotsManageAccessBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-manageAccessBtn ng-scope')]");
    By threeDotsRemoveAllPermissionsBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-removeALLPermissionsBtn ng-scope')]");
    By threeDotsPermissionOverviewBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-permissionOverviewBtn ng-scope')]");
    By reportButtonBy = By.xpath("//button[contains(text(),'Report')]");
    By auditTrailButtonBy = By.xpath("//*[@id='app']/app-layout/div/div/manage-team-members/section/div/div[2]/ul/li[2]/a");

    public ManageTeamMembersPage openAddMembersModal () {
        click(addMembersButtonBy);
        return this;
    }

    public ManageTeamMembersPage removeMember (String memberName) {
        String name = "//span[contains(text(), '" + memberName + "')]/../..//following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsRemoveMemberBy);
        return this;
    }

    public ManageTeamMembersPage manageAccess (String memberName) {
        String name = "//span[contains(text(), '" + memberName + "')]/../..//following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsManageAccessBy);
        return this;
    }

    public ManageTeamMembersPage removeAllPermissions (String memberName) {
        String name = "//span[contains(text(), '" + memberName + "')]/../..//following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsRemoveAllPermissionsBy);
        return this;
    }

    public ManageTeamMembersPage auditTrail () {
        waitForElementToBeClickable(reportButtonBy);
        click(reportButtonBy);
        click(auditTrailButtonBy);
        return this;
    }

    public ManageTeamMembersPage permissionOverview (String memberName) {
        String name = "//span[contains(text(), '" + memberName + "')]/../..//following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsPermissionOverviewBy);
        return this;
    }
}

