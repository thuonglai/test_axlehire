package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends MobileObject {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Tutorials")
    private WebElement  tutorialLink;

    public void clickTutorialLink(){
        waitFor(tutorialLink).click();
//        clickOn(tutorialLink);
    }
}
