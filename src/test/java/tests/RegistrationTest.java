package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {

    private final MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void registrationUserTest() {
        mainPage.clickLoginButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.registrationUserData("archilol", "archilol@yandex.ru", "Zu6038910");
        registrationPage.clickRegistrationButton();
        Assert.assertTrue(loginPage.isRegistrationButtonExist());
    }

    @Test
    @DisplayName("Проверка ошибки при регистрации с неправильным паролем")
    public void registrationUserWithWrongPasswordTest() {
        mainPage.clickLoginButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.registrationUserData("archilol", "archilol@yandex.ru", "Zu6038910");
        registrationPage.clickRegistrationButton();
        Assert.assertTrue(registrationPage.incorrectPasswordMessageVisible());
    }
}
