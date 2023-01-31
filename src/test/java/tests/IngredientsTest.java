package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pom.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class IngredientsTest {

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @DisplayName("Переход к разделам в конструкторе")
    public void checkSwitchSection() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.isBunsTabOpen();
        mainPage.isSaucesTabWorks();
        mainPage.isFillingsTabWorks();
        mainPage.isBunsTabWorks();
    }

}
