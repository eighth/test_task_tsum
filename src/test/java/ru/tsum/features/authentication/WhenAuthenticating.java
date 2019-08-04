package ru.tsum.features.authentication;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.tsum.steps.TsumUser;

@RunWith(SerenityRunner.class)
public class WhenAuthenticating {
    @Steps
    private TsumUser user;

    @Managed(driver = "chrome")
    WebDriver browser;

    @Test
    public void shouldBeAbleToLoginAsUser() {
        user.isOnTheHomePage();
        user.loginAsUser();
        user.shouldBeOnProfilePage();
    }

    @Test
    public void shouldBeAbleToRegisterAsUser() {
        user.isOnTheHomePage();
//        user.registerAsUser("ne4epurenko@gmail.com", "24a10c19i89d");
        user.registerAsUser("qazwsxedc@gmail.com", "dfgdsfzdfgdsfgdsfgg");
        user.shouldBeOnNewUserPage();
    }

    @Test
    public void shouldNotLoginAsAnUnregisteredUser() {
        user.isOnTheHomePage();
        user.loginAsUser();
        user.shouldBeOnProfilePage();
    }

    @Test
    public void shouldNotRegisterAsARegisteredUser() {
        user.isOnTheHomePage();
        user.loginAsUser();
        user.shouldBeOnProfilePage();
    }

}
