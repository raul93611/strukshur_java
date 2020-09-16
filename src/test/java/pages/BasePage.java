package pages;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void waitVisibility (By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitInvisibility (By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void waitForElementToBeClickable (By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void waitForElementNotToBePresent (By elementBy) {
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy)));
    }

    public String getURL () {
        return driver.getCurrentUrl();
    }

    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void assertEqualsAttributes (By elementBy, String attributeName, String expectedText) {
        Assert.assertEquals(driver.findElement(elementBy).getAttribute(attributeName), expectedText);
    }

    public void selectOption (By elementBy, String selectOption) {
        waitVisibility(elementBy);
        new Select(driver.findElement(elementBy)).selectByVisibleText(selectOption);
    }

    public void switchTabs () {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void waitForElementToFadeIn (final By elementBy, final String cssValue, final String equals) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(elementBy).getCssValue(cssValue).equals(equals);
            }
        });
    }
}