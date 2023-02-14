package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.PersonalAreaPage;

import static com.codeborne.selenide.Selenide.*;

public class LogoutTest {

    private final MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка выхода по кнопке 'Выйти' в личном кабинете")
    public void clickLogoutButtonTest() {
        mainPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUserData("archilol777@gmail.com", "123456");
        loginPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        PersonalAreaPage personalAreaPage = page(PersonalAreaPage.class);
        personalAreaPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isRegistrationButtonExist());
    }
}
