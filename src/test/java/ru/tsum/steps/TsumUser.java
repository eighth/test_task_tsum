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
    public void loginAsUser() {
        tsumHomePage.loginAsUser();
    }

    @Step
    public void shouldBeOnProfilePage() {
        assertThat(resultPage.headerLink()).isEqualTo("ne4epurenko@gmail.com");
    }

    @Step
    public void shouldBeOnNewUserPage() {
        assertThat(resultPage.noticeInfo()).isEqualTo("qazwsxedc@gmail.com");
    }

    @Step
    public void shouldBeOnNewUserPage2() {
        assertThat(resultPage.noticeInfo()).isEqualTo("ne4epurenko@gmail.com");
    }
}
