package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class MainPage extends BasePage{

    @FindBy(xpath = "//a[@href='https://cz-test-jedna.herokuapp.com/1-digitalni-akademie-testovani']")
    protected WebElement DATestingLink;

    @FindBy(xpath = "//i[@class='fa fa-user mr-2']")
    protected WebElement signInLink;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void goToMainPage() {
        getDriver().get("https://cz-test-jedna.herokuapp.com");
    }

    public DATestingPage goToDATestingPage() {
        DATestingLink.click();
        return new DATestingPage(getDriver());
    }

    public SignInPage goToSignInForm() {
        signInLink.click();
        return new SignInPage(getDriver());
    }

}
