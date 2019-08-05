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
        user.loginAsUser("windoed@gmail.com", "1qaz3edc5tgb6yhn");
        user.shouldBeOnProfilePage();
    }

    @Test
    public void shouldBeAbleToRegisterAsUser() {
        user.isOnTheHomePage();
        user.registerAsUser("windoed@gmail.com", "1qaz3edc5tgb6yhn");
        user.shouldBeOnNewUserPage();
    }

    @Test
    public void shouldNotLoginAsAnUnregisteredUser() {
        user.isOnTheHomePage();
        user.loginAsUser("windoed2@gmail.com", "dfgdsfzdfgdsfgdsfgg");
        user.shouldNotBeOnANonExistingUser();
    }

    @Test
    public void shouldNotRegisterAsARegisteredUser() {
        user.isOnTheHomePage();
        user.registerAsUser("windoed@gmail.com", "dfgdsfzdfgdsfgdsfgg");
        user.shouldNotBeOnAnExistingUser();
    }

    @Test
    public void shouldNotRegisterWithIncorrectEmail() {
        user.isOnTheHomePage();
        user.registerAsUser("qdfgfffhdfghc", "dfgdsfzdfgdsfgdsfgg");
        user.shouldNotBeOnIncorrectEmail();
    }
}
