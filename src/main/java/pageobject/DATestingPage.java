package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DATestingPage extends MainPage{

    @FindBy(xpath = "//a[@class='btn btn-sm align-self-center btn-primary']")
    protected WebElement algorithmsBasics;

    public DATestingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public CourseRegistrationFormPage clickOnAlgorithmsBasics() {
        algorithmsBasics.click();
        return new CourseRegistrationFormPage(getDriver());
    }
}
