package cz.czechitas.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class AllRegistrations extends MainPage{

    @FindBy(xpath = "//div[@class = 'nav-item dropdown']/span")
    protected WebElement signedUser;

    @FindBy(xpath = "//i[@class='fa fa-fw mr-1 fa-plus-circle ']")
    protected WebElement newRegistration;


    public AllRegistrations(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public Boolean isUserSigned(){
        return signedUser.getText().contains("Přihlášen");
    }

    public MainPage goToCreateNewRegistration() {
        newRegistration.click();
        return new MainPage(getDriver());
    }

}
