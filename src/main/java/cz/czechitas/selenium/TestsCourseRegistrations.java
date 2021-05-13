package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestsCourseRegistrations {

    WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test // Test 1 - Rodič s existujícím účtem se musí být schopen přihlásit do webové aplikace.
    public void signInRegisteredUser() {

        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        SignInPage signInPage = mainpage.goToSignInForm();
        AllRegistrations allRegistrations = signInPage.signInAndGoToAllRegistrations();

        Assertions.assertTrue(allRegistrations.isUserSigned());

    }

    @Test
    // Test 2 - Rodič s existujícím účtem musí být schopen přihlásit svoje dítě na kurz tak, že nejprve vybere kurz a potom se přihlásí ke svému účtu.
    public void chooseCourseForRegistrationBeforeSigningIn() {

        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        DATestingPage daTestingPage = mainpage.goToDATestingPage();
        CourseRegistrationFormPage registrationForm = daTestingPage.clickOnAlgorithmsBasics();

        new SignInPage(browser).signInAndGoToRegistrationForm();
        CreatedRegistration createdRegistration = registrationForm.createAnApplication();

        Assertions.assertTrue(createdRegistration.isRegistered());
    }

    @Test
    // Test 3 - Rodič s existujícím účtem musí být schopen přihlásit svoje dítě na kurz tak, že se nejprve přihlásí ke svému účtu a potom vybere kurz.
    public void chooseCourseForRegistrationAfterSigningIn() {

        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        SignInPage signInPage = mainpage.goToSignInForm();

        AllRegistrations registrations = signInPage.signInAndGoToAllRegistrations();
        registrations.goToCreateNewRegistration();

        DATestingPage daTestingPage = mainpage.goToDATestingPage();

        CourseRegistrationFormPage registrationForm = daTestingPage.clickOnAlgorithmsBasics();
        CreatedRegistration createdRegistration = registrationForm.createAnApplication();

        Assertions.assertTrue(createdRegistration.isRegistered());
    }

    @Test // Test 4 - Jeden další scénář dle své úvahy.
    public void createRegistrationAfterSigningInAndThenCancelRegistration() {

        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();
        mainpage.goToSignInForm();

        SignInPage signInPage = new SignInPage(browser);

        AllRegistrations registrations = signInPage.signInAndGoToAllRegistrations();
        registrations.goToCreateNewRegistration();

        DATestingPage daTestingPage = mainpage.goToDATestingPage();

        CourseRegistrationFormPage RegistrationForm = daTestingPage.clickOnAlgorithmsBasics();
        CreatedRegistration createdRegistration = RegistrationForm.createAnApplication();

        Assertions.assertTrue(createdRegistration.isRegistered());

        ReasonToCancel cancellation = createdRegistration.cancelRegistration();
        cancellation.getLoggedOut();

        Assertions.assertTrue(createdRegistration.isCancellationConfirmed());

    }

    @AfterEach
    public void tearDown() {
        browser.close();
    }

}
