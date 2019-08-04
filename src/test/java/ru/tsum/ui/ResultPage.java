package ru.tsum.ui;

import net.serenitybdd.core.pages.PageObject;

public class ResultPage extends PageObject {

//    public String headerText() {
//        return $("//div[@class='ui-h1']").getText();
//    }

    public String headerLink() {
        return $("//a[@class='header__link ng-star-inserted']").getText();
    }

        public String noticeInfo() {
//        return $("div.notice.info").getText();
        return $("div.notice.info").getText();
    }
}
