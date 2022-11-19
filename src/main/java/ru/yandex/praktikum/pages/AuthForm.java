package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AuthForm extends CommonItems {

    @FindBy(how = How.XPATH, using=".//label[text() = 'Email']/../input")
    private SelenideElement emailTextLine;

    @FindBy(how = How.XPATH, using=".//label[text() = 'Пароль']/../input")
    private SelenideElement passwordTextLine;

    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement restoreButton;

    public void setEmailTextLine(String email) {
        emailTextLine.shouldBe(Condition.enabled).setValue(email);
    }

    public void setPasswordTextLine(String password) {
        passwordTextLine.shouldBe(Condition.enabled).setValue(password);
    }

    public AuthMainPage clickToLoginButton() {
        loginButton.scrollTo();
        loginButton.shouldBe(Condition.visible);
        loginButton.click();
        AuthMainPage mainPage = page(AuthMainPage.class);
        return mainPage;
    }

    public RegisterForm clickToRegisterButton() {
        registerButton.scrollTo();
        registerButton.shouldBe(Condition.visible);
        registerButton.click();
        RegisterForm registerForm = page(RegisterForm.class);
        return registerForm;
    }

    public RestoreForm clickToRestoreButton() {
        restoreButton.scrollTo();
        restoreButton.shouldBe(Condition.visible);
        restoreButton.click();
        RestoreForm restoreForm = page(RestoreForm.class);
        return restoreForm;
    }

}