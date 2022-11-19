package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage extends CommonItems {
    @FindBy(how = How.XPATH, using=".//button[text()='Войти в аккаунт']")
    private SelenideElement enterToAccountButton;

    @FindBy(how = How.XPATH, using=".//button[text() = 'Оформить заказ']")
    private SelenideElement makeOrderButton;
    @FindBy(how = How.XPATH, using=".//span[text() = 'Булки']/../..")
    private SelenideElement bunsPageButton;

    @FindBy(how = How.XPATH, using=".//span[text() = 'Соусы']/../..")
    private SelenideElement saucePageButton;

    @FindBy(how = How.XPATH, using=".//span[text() = 'Начинки']/../..")
    private SelenideElement ingredientsPageButton;

    public AuthForm clickToEnterAccountButton() {
        enterToAccountButton.scrollTo();
        enterToAccountButton.shouldBe(Condition.visible);
        enterToAccountButton.click();
        AuthForm authForm = page(AuthForm.class);
        return authForm;
    }

    public void clickToBunsPageButton() {
        bunsPageButton.scrollTo();
        bunsPageButton.shouldBe(Condition.visible);
        bunsPageButton.click();
    }

    public void clickToSaucePageButton() {
        saucePageButton.scrollTo();
        saucePageButton.shouldBe(Condition.visible);
        saucePageButton.click();
    }

    public void clickToIngredientsPageButton() {
        ingredientsPageButton.scrollTo();
        ingredientsPageButton.shouldBe(Condition.visible);
        ingredientsPageButton.click();
    }
}
