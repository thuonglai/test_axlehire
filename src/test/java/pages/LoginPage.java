package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends MobileObject{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Log in with phone number\"]/preceding-sibling::android.widget.EditText[2]")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Log in with phone number\"]/preceding-sibling::android.widget.EditText[1]")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Log In")
    private WebElement loginBtn;

    public void loginToApp(String username, String password){
        waitFor(loginBtn);
        clickOn(usernameField);
        enter(username).into(usernameField);
        clickOn(passwordField);
        enter(password).into(passwordField);
        clickOn(loginBtn);
    }
}
