package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.PersonalAreaPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest {

    private final MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка нажатия на кнопку 'Конструктор' из личного кабинета")
    public void constructorButtonTest() {
        mainPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUserData("archilol777@gmail.com", "123456");
        loginPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        PersonalAreaPage personalAreaPage = page(PersonalAreaPage.class);
        personalAreaPage.clickConstructorButton();
        Assert.assertTrue(mainPage.isCheckoutButtonExist());
    }

    @Test
    @DisplayName("Проверка нажатия на логотип 'Stellar Burgers' из личного кабинета")
    public void stellarBurgersLogoButtonTest() {
        mainPage.clickPersonalAreaButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginUserData("archilol777@gmail.com", "123456");
        loginPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        PersonalAreaPage personalAreaPage = page(PersonalAreaPage.class);
        personalAreaPage.clickStellarBurgersLogoButton();
        Assert.assertTrue(mainPage.isCheckoutButtonExist());
    }
}
