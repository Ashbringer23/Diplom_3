package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    //локатор кнопки Войти
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginButton;

    //метод клика по кнопке Войти
    public void clickLoginButton() {
        loginButton.click();
    }
}
