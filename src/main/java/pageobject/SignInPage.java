package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SignInPage extends MainPage{

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(xpath = "//button[@type = 'submit']")
    protected WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    private void signIn() {
        email.sendKeys("perutkova.v@seznam.cz");
        password.sendKeys("Perutkova123");
        signInButton.click();
    }

    public AllRegistrations signInAndGoToAllRegistrations(){
        signIn();
        return new AllRegistrations(getDriver());
    }

    public CourseRegistrationFormPage signInAndGoToRegistrationForm(){
        signIn();
        return new CourseRegistrationFormPage(getDriver());
    }

}
