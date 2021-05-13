package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CourseRegistrationFormPage extends MainPage{

    @FindBy(xpath = "//div[@class = 'filter-option-inner-inner']")
    protected WebElement dateSelector;

    @FindBy(id = "bs-select-1-0")
    protected WebElement selectDate;

    @FindBy(id = "forename")
    protected WebElement firstName;

    @FindBy(id = "surname")
    protected WebElement surname;

    @FindBy(id = "birthday")
    protected WebElement dateOfBirth;

    @FindBy(xpath = "//label[@for = 'payment_transfer']")
    protected WebElement typeOfPayment;

    @FindBy(xpath = "//label[@for = 'terms_conditions']")
    protected WebElement termsAndConditions;

    @FindBy(xpath = "//input[@value = 'Vytvořit přihlášku']")
    protected WebElement submitApplication;

    public CourseRegistrationFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public CreatedRegistration createAnApplication() {
        dateSelector.click();
        selectDate.click();
        firstName.sendKeys("Dítě");
        surname.sendKeys("Perutka");
        dateOfBirth.sendKeys("24.03.2010");
        typeOfPayment.click();
        termsAndConditions.click();
        submitApplication.click();
        return new CreatedRegistration(getDriver());
    }
}
