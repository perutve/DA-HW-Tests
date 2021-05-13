package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CreatedRegistration extends MainPage{

    @FindBy(xpath = "//a[@title = 'Stáhnout potvrzení o přihlášení']")
    protected WebElement registredChild;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-danger']")
    protected WebElement registrationCancel;

    //ul[@class="featureList" and li//text()[contains(., "Model")]]

    @FindBy(xpath = "//div[@role='alert']/ul[@class = 'm-0']/li")
    protected WebElement cancelConfirmation;

    public CreatedRegistration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public Boolean isRegistered(){
       return registredChild.isDisplayed();
    }

    public ReasonToCancel cancelRegistration(){
        registrationCancel.click();
        return new ReasonToCancel(getDriver());
    }

    public Boolean isCancellationConfirmed(){
        return cancelConfirmation.getText().contains("odhlášen");
    }
}
