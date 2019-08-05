package ru.tsum.steps;

import net.thucydides.core.annotations.Step;
import ru.tsum.ui.ResultPage;
import ru.tsum.ui.TsumHomePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TsumUser {
    private TsumHomePage tsumHomePage;
    private ResultPage resultPage;

    @Step
    public void isOnTheHomePage() {
        tsumHomePage.open();
    }

    @Step
    public void registerAsUser(String user, String pass) {
        tsumHomePage.registerAsUser(user, pass);
    }

    @Step
    public void loginAsUser(String user, String pass) {
        tsumHomePage.loginAsUser(user, pass);
    }

    @Step
    public void shouldBeOnProfilePage() {
        assertThat(resultPage.headerLink()).isEqualTo("windoed@gmail.com");
    }

    @Step
    public void shouldBeOnNewUserPage() {
        assertThat(resultPage.noticeInfo()).isEqualTo("Успешная регистрация");
    }

    @Step
    public void shouldNotBeOnAnExistingUser() {
        assertThat(resultPage.noticeError()).isEqualTo("Пользователь с таким email уже существует.");
    }

    @Step
    public void shouldNotBeOnIncorrectEmail() {
        assertThat(resultPage.noticeError()).isEqualTo("Указан некорректный email");
    }

    @Step
    public void shouldNotBeOnANonExistingUser() {
        assertThat(resultPage.noticeError()).isEqualTo("Неверный логин или пароль");
    }
}
