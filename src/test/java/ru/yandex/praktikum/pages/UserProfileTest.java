package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class UserProfileTest extends BaseTest {
    @Test
    @DisplayName(value = "Переход в профиль пользователя")
    public void enterToUserProfile() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            AuthMainPage authMainPage = authForm.clickToLoginButton();
            UserProfile userProfile = authMainPage.clickToUserProfile();
            Assert.assertEquals(username, userProfile.getUsername());
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Выход из аккаунта через личный профиль")
    public void logout() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            AuthMainPage authMainPage = authForm.clickToLoginButton();
            UserProfile userProfile = authMainPage.clickToUserProfile();
            userProfile.clickToLogoutButton();
            $(By.xpath(".//h2[text()='Вход']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Переход к конструктору")
    public void goToConstructor() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            AuthMainPage authMainPage = authForm.clickToLoginButton();
            UserProfile userProfile = authMainPage.clickToUserProfile();
            userProfile.clickToConstructorButton();
            $(By.xpath(".//h1[text()='Соберите бургер']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "При нажатии на логотип попадаем на главную страницу")
    public void clickToLogo() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            AuthMainPage authMainPage = authForm.clickToLoginButton();
            UserProfile userProfile = authMainPage.clickToUserProfile();
            userProfile.clickToLogoButton();
            $(By.xpath(".//h1[text()='Соберите бургер']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }
}
