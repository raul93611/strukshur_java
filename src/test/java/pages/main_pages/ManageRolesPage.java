package pages.main_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ManageRolesPage extends BasePage {

    public ManageRolesPage(WebDriver driver) {
        super(driver);
    }

    By createRoleButtonBy = By.xpath("//button[@class='btn btn-default mr-3 test-createBinderLink']");
    By threeDotsDuplicateBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-duplicateBtn ng-scope')]");
    By threeDotsManageRolePermissionsBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-manageRolePermissionsBtn ng-scope')]");
    By threeDotsRenameBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-renameBtn ng-scope')]");
    By threeDotsManageAccessBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-manageAccessBtn ng-scope')]");
    By threeDotsDeleteBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-deleteBtn ng-scope')]");
    By threeDotsAuditTrailBy = By.xpath("//ul[@class='dropdown-menu dropdown-menu ng-scope']//a[contains(@class,'test-auditTrailBtn ng-scope')]");
    By createNewButtonBy = By.xpath("//button[contains(text(),'Create New')]");
    By teamLevelPermissionsBy = By.xpath("/html/body/div/app-layout/div/div/role-permissions/section/div[2]/div[1]/ul/li[1]/a");

    public ManageRolesPage auditTrail (String role) {
        String name = "//td[contains(text(), '" + role + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsAuditTrailBy);
        return this;
    }

    public ManageRolesPage manageRoleAccess (String role) {
        String name = "//td[contains(text(), '" + role + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsManageAccessBy);
        return this;
    }

    public ManageRolesPage renameRole (String role) {
        String name = "//td[contains(text(), '" + role + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsRenameBy);
        return this;
    }

    public ManageRolesPage addTeamLevelPermissions () {
        waitForElementToBeClickable(createNewButtonBy);
        click(createNewButtonBy);
        click(teamLevelPermissionsBy);
        return this;
    }

    public ManageRolesPage manageRolePermissions (String role) {
        String name = "//td[contains(text(), '" + role + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsManageRolePermissionsBy);
        return this;
    }

    public ManageRolesPage createRole () {
        waitForElementToBeClickable(createRoleButtonBy);
        click(createRoleButtonBy);
        return this;
    }

    public ManageRolesPage duplicateRole (String role) {
        String name = "//td[contains(text(), '" + role + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsDuplicateBy);
        return this;
    }

    public ManageRolesPage deleteRole (String role) {
        String name = "//td[contains(text(), '" + role + "')]/following-sibling::td[@class='dropdown-menu-right-nested dropdown']//i[@class='fas fa-ellipsis-v']";

        click(By.xpath(name));
        click(threeDotsDeleteBy);
        return this;
    }
}
