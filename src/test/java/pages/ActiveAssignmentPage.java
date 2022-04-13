package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.Locale;

public class ActiveAssignmentPage extends MobileObject {
    public ActiveAssignmentPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Background Location Required Next")
    private WebElement popupBackgroundLocation;

    @AndroidFindBy(accessibility = "No pending assignments")
    private WebElement noPendingAssignmentTxt;

    private String noPendingAccessId = "No pending assignments";

    @AndroidFindBy(accessibility = "Start Tutorial")
    private WebElement startTutorialBtn;

    @AndroidFindBy(accessibility = "Quit tutorial")
    private WebElement quitBtn;

    @AndroidFindBy(accessibility = "Yes, quit tutorial")
    private WebElement agreeQuitTutorialBtn;

    public void clickButtonNext() {
        waitFor(popupBackgroundLocation);
        Point location = popupBackgroundLocation.getLocation();
        Dimension dimention = popupBackgroundLocation.getSize();
        int x = location.x + dimention.width / 2;
        int y = location.y + dimention.height - 145;
        new TouchActions(this.androidDriver())
                .move(x, y)
                .click()
                .release()
                .perform();

    }

    public boolean checkPageHasMessage(String message) {
//        boolean isDisplay = this.androidDriver().getContext().contains(message);
        int x = 1;
        while (x < 50) {
            if(this.androidDriver().getPageSource().toLowerCase().contains(message.toLowerCase())==true)
                return true;
            else
                x++;
        }
        return false;
    }

    public void deleteAllTutorial() {
        waitABit(2000);

//        withTimeoutOf(Duration.ofSeconds(5)).elementIsDisplayed(new AppiumBy.ByAccessibilityId(noPendingAccessId)) == false
        while (true) {
            try {
                waitFor(startTutorialBtn).click();
                waitFor(quitBtn).click();
                waitFor(agreeQuitTutorialBtn).click();
                waitABit(1000);
                if(this.isElementVisible(new AppiumBy.ByAccessibilityId(noPendingAccessId)) == true){
                    break;
                }
            } catch (Exception ex) {
                break;
            }
        }
    }
}
