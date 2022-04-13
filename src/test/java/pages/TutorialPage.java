package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Type;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TutorialPage extends MobileObject {
    public TutorialPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Assigned Route")
    private WebElement assignedRouterType;

    @AndroidFindBy(accessibility = "Direct Booking")
    private WebElement directBookingType;

    @AndroidFindBy(accessibility = "Ticket Booking")
    private WebElement ticketBookingType;

    public void chooseAssignedRouterType() {
        waitABit(2000);
        waitFor(assignedRouterType);
        clickOn(assignedRouterType);
    }

    public void chooseDirectBookingType() {
        waitFor(directBookingType);
        clickOn(directBookingType);
    }

    public void chooseTicketBookingType() {
        waitFor(ticketBookingType);
        clickOn(ticketBookingType);
    }

    public void chooseTutorialByType(String type) {
        if (type.equals(Type.ASSIGNED_ROUTE.getValue()))
            chooseAssignedRouterType();
        else if (type.equals(Type.DIRECT_BOOKING.getValue()))
            chooseDirectBookingType();
        else
            chooseTicketBookingType();
    }
}
