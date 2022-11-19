package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RestoreForm {

    @FindBy(how = How.XPATH, using=".//a[text()='Войти']")
    private SelenideElement authButton;

    @FindBy(how = How.XPATH, using=".//button[text()='Восстановить']")
    private SelenideElement restoreButton;

    public AuthForm clickToAuthButton() {
        authButton.scrollTo();
        authButton.shouldBe(Condition.visible);
        authButton.click();
        AuthForm authForm = page(AuthForm.class);
        return authForm;
    }

    public void clickToRestoreButton() {
        restoreButton.scrollTo();
        restoreButton.shouldBe(Condition.visible);
        restoreButton.click();
    }
}
