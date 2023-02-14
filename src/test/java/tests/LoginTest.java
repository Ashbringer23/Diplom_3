package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.ForgotPasswordPage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    private final MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка входа с кнопки 'Войти в акаунт' на главной странице")
    public void loginButtonOnMainPageTest() {
        mainPage.clickLoginButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUserData("archilol777@gmail.com", "123456");
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isCheckoutButtonExist());
    }

    @Test
    @DisplayName("Проверка входа с кнопки 'Личный кабинет' на главной странице")
    public void personalAreaButtonTest() {
        mainPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUserData("archilol777@gmail.com", "123456");
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isCheckoutButtonExist());
    }

    @Test
    @DisplayName("Проверка входа через кнопку 'Войти' на странице регистрации")
    public void loginButtonOnRegistrationPageTest() {
        mainPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickLoginButton();
        loginPage.loginUserData("archilol777@gmail.com", "123456");
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isCheckoutButtonExist());
    }

    @Test
    @DisplayName("Проверка входа через кнопку 'Войти' на странице восстановления пароля")
    public void loginButtonOnForgotPasswordPageTest() {
        mainPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.clickLoginButton();
        loginPage.loginUserData("archilol777@gmail.com", "123456");
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isCheckoutButtonExist());
    }
}