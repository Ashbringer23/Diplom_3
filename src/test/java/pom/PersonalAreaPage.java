package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;

public class PersonalAreaPage {

    //локатор кнопки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;
    //локатор кнопки "Конструктор"
    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    private SelenideElement constructorButton;
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgersLogoButton;

    //метод клика по кнопке Выход
    public void clickLogoutButton() {
        logoutButton.click();
    }

    //метод клика по кнопке Конструктор
    public void clickConstructorButton() {
        constructorButton.click();
    }

    //метод клика по логотипу Stellar Burgers
    public void clickStellarBurgersLogoButton() {
        stellarBurgersLogoButton.click();
    }

    //метод нахождения кнопки Выход
    public boolean isLogoutExist() {
        logoutButton.shouldBe(exist);
        return logoutButton.isDisplayed();
    }
}
