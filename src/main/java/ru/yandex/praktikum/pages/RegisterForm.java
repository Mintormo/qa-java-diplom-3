package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterForm extends CommonItems {
    @FindBy(how = How.XPATH, using=".//label[text() = 'Email']/../input")
    private SelenideElement emailTextLine;

    @FindBy(how = How.XPATH, using=".//label[text() = 'Имя']/../input")
    private SelenideElement usernameTextLine;

    @FindBy(how = How.XPATH, using=".//label[text() = 'Пароль']/../input")
    private SelenideElement passwordTextLine;

    @FindBy(how = How.XPATH, using=".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using=".//a[text()='Войти']")
    private SelenideElement authButton;

    public void setEmailTextLine(String email) {
        emailTextLine.shouldBe(Condition.enabled).setValue(email);
    }

    public void setUsernameTextLine(String username) {
        usernameTextLine.shouldBe(Condition.enabled).setValue(username);
    }

    public void setPasswordTextLine(String password) {
        passwordTextLine.shouldBe(Condition.enabled).setValue(password);
    }

    public AuthForm clickToAuthButton() {
        authButton.scrollTo();
        authButton.shouldBe(Condition.visible);
        authButton.click();
        AuthForm authForm = page(AuthForm.class);
        return authForm;
    }

    public AuthForm clickToRegisterButton() {
        registerButton.scrollTo();
        registerButton.shouldBe(Condition.visible);
        registerButton.click();
        AuthForm authForm = page(AuthForm.class);
        return authForm;
    }
}
