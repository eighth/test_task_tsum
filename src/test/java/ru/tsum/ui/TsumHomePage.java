package ru.tsum.ui;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.tsum.ru/")
public class TsumHomePage extends PageObject {

    public void loginAsUser(String user, String pass) {
        $("//a[@href='/login/']").click();
        find(By.cssSelector("p.auth-layout__control-button.first")).click();
        $("//div[@class='input-wrapper']/input[@formcontrolname='email']").sendKeys(user);
        $("//div[@class='input-wrapper']/input[@formcontrolname='password']").sendKeys(pass);
        $("//div[@class='button-wrapper']/button[@type='submit']").click();
    }

    public void registerAsUser(String user, String pass) {
        $("//a[@href='/login/']").click();
        find(By.cssSelector("p.auth-layout__control-button.last")).click();
        $("//div[@class='input-wrapper']/input[@type='email']").sendKeys(user);
        $("//div[@class='input-wrapper']/input[@type='password']").sendKeys(pass);
        $("//div[@class='button-wrapper']/button[@type='submit']").click();

    }
}
