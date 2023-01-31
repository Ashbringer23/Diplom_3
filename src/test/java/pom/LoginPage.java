package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //страница входа
    @FindBy(how = How.CLASS_NAME, using = "App_componentContainer__2JC2W")
    private SelenideElement loginPage;
    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;
    //поле ввода Email
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement emailField;
    //поле ввода Password
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement passwordField;
    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;
    //локатор кнопки Восстановить пароль
    @FindBy(how = How.XPATH, using = "//*[text()='Восстановить пароль']")
    private SelenideElement forgotPasswordButton;

    //клик по кнопке Зарегистрироваться
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    //клик по кнопке Войти
    public void clickLoginButton() {
        loginButton.click();
    }

    //клик по кнопке Восстановление пароля
    public void clickForgotPasswordButton() {
        forgotPasswordButton.click();
    }

    //проверка существования кнопки Зарегистрироваться
    public boolean isRegistrationButtonExist() {
        registrationButton.shouldBe(Condition.exist);
        return registrationButton.isDisplayed();
    }

    //метод заполнения полей
    public void loginUserData(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
    }

}
