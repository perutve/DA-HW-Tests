package cz.czechitas.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ReasonToCancel extends MainPage{

    @FindBy(xpath = "//label[@for='logged_out_other']")
    protected WebElement cancellationReason;

    @FindBy(xpath = "//input[@value='Odhlásit žáka']")
    protected WebElement confirmButton;

    public ReasonToCancel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public CreatedRegistration getLoggedOut(){
        cancellationReason.click();
        confirmButton.click();
        return new CreatedRegistration(getDriver());
    }

}
