package ru.tsum.ui;

import net.serenitybdd.core.pages.PageObject;

public class ResultPage extends PageObject {

    public String headerLink() {
        return $("//a[@class='header__link ng-star-inserted']").getText();
    }

    public String noticeInfo() {
        return $("//div[@class='notice info']").waitUntilVisible().getText();
    }
    public String noticeError() {
        return $("//div[@class='notice error']").waitUntilVisible().getText();
    }
}
