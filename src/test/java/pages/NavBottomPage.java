package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;

public class NavBottomPage extends MobileObject {
    public NavBottomPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Routes Tab')]")
    private WebElement routeTab;

    @AndroidFindBy(xpath = "//android.widget.ImageView[starts-with(@content-desc,'Booking Tab')]")
    private WebElement bookingTab;

    @AndroidFindBy(xpath = "//android.widget.ImageView[starts-with(@content-desc,'Messenger Tab')]")
    private WebElement messengerTab;

    @AndroidFindBy(xpath = "//android.widget.ImageView[starts-with(@content-desc,'History Tab')]")
    private WebElement historyTab;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Profile Tab 5 of 5\"]")
    private WebElement profileTab;

    public void clickRouterTab() {
        waitFor(routeTab);
        clickOn(routeTab);
    }

    public void clickBookingTab() {
        waitFor(bookingTab);
        clickOn(bookingTab);
    }

    public void clickMessengerTab() {
        waitFor(messengerTab);
        clickOn(messengerTab);
    }

    public void clickHistoryTab() {
        waitFor(historyTab);
        clickOn(historyTab);
    }

    public void clickProfileTab() {
        waitABit(1000);
        Dimension dimension = this.androidDriver().manage().window().getSize();
        int x = dimension.width - 110;
        int y = dimension.height - 80;
        PointOption pointOption = PointOption.point(x, y);
        new TouchAction(this.androidDriver()).tap(pointOption).release()
                .perform();
    }
}
