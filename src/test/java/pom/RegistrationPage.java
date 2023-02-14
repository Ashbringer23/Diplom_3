package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    //локатор поля Имя
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;
    //локатор поля Email
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;
    //локатор поля Password
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;
    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;
    //Локатор кнопки Войти
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement loginButton;
    //локатор текста Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement inCorrectPasswordMessage;

    //метод заполнения полей при регистрации
    public void registrationUserData(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
    }

    //метод нажатия на кнопку Зарегистрироваться
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    //метод нажатия на кнопку Войти
    public void clickLoginButton() {
        loginButton.click();
    }

    //метод проверки сообщения о вводе неправильного пароля
    public boolean incorrectPasswordMessageVisible() {
        inCorrectPasswordMessage.shouldBe(Condition.visible);
        return inCorrectPasswordMessage.isDisplayed();
    }
}

