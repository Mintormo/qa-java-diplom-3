package ru.yandex.praktikum.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class LoginTest extends BaseTest {
    final String makeOrderButtonSelector = ".//button[text() = 'Оформить заказ']/..";

    @Test
    @DisplayName(value = "Авторизация через кнопку 'Войти в аакаунт' на главной странице")
    public void loginMainPage() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            authForm.clickToLoginButton();
            $(By.xpath(makeOrderButtonSelector)).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Авторизация через нажатие кнопки профиля")
    public void loginUserProfile() {
        try {
            AuthForm authForm = registration();
            MainPage mainPage = authForm.clickToLogoButton();
            AuthForm authForm1 = mainPage.clickToUserProfileButton();
            authForm1.setEmailTextLine(email);
            authForm1.setPasswordTextLine(password);
            authForm1.clickToLoginButton();
            $(By.xpath(makeOrderButtonSelector)).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Авторизация через форму регистрации")
    public void loginRegistrationForm() {
        try {
            AuthForm authForm = registration();
            MainPage mainPage = authForm.clickToLogoButton();
            AuthForm authForm1 = mainPage.clickToEnterAccountButton();
            RegisterForm registerForm1 = authForm1.clickToRegisterButton();
            AuthForm authForm2 = registerForm1.clickToAuthButton();
            authForm2.setEmailTextLine(email);
            authForm2.setPasswordTextLine(password);
            authForm2.clickToLoginButton();
            $(By.xpath(makeOrderButtonSelector)).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Авторизация через форму восстановления пароля")
    public void loginRestoreForm() {
        try {
            AuthForm authForm = registration();
            RestoreForm restoreForm = authForm.clickToRestoreButton();
            AuthForm authForm1 = restoreForm.clickToAuthButton();
            authForm1.setEmailTextLine(email);
            authForm1.setPasswordTextLine(password);
            authForm1.clickToLoginButton();
            $(By.xpath(makeOrderButtonSelector)).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }
}
