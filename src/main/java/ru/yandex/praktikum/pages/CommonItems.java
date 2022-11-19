package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class CommonItems {
    @FindBy(how = How.XPATH, using=".//p[text()='Личный Кабинет']")
    protected SelenideElement userProfileButton;

    @FindBy(how = How.XPATH, using=".//div[@class='AppHeader_header__logo__2D0X2']/a")
    private SelenideElement logoButton;

    @FindBy(how = How.XPATH, using=".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    public AuthForm clickToUserProfileButton() {
        userProfileButton.scrollTo();
        userProfileButton.shouldBe(Condition.visible);
        userProfileButton.click();
        AuthForm authForm = page(AuthForm.class);
        return authForm;
    }

    public MainPage clickToLogoButton() {
        logoButton.scrollTo();
        logoButton.shouldBe(Condition.visible);
        logoButton.click();
        MainPage mainPage = page(MainPage.class);
        return mainPage;
    }

    public MainPage clickToConstructorButton() {
        constructorButton.scrollTo();
        constructorButton.shouldBe(Condition.visible);
        constructorButton.click();
        MainPage mainPage = page(MainPage.class);
        return mainPage;
    }
}
