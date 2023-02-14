package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    //локатор кнопки "Личный Кабинет"
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement personalAreaButton;
    //локатор кнопки "войти в акаунт"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти в аккаунт')]")
    private SelenideElement loginButton;
    //локатор кнопки "Оформить заказ" если пользаватель авторизирован
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement checkoutButton;

    //локатор секции Булки/Соусы/Начинки
    @FindBy(how = How.XPATH, using = "//div/main/section[1]/div[1]")
    private SelenideElement topSection;
    //локатор раздела "Булки"
    @FindBy(how = How.XPATH, using = "//span[text() = 'Булки']")
    private SelenideElement bunsSection;
    //локатор раздела "Соусы"
    @FindBy(how = How.XPATH, using = "//span[text() = 'Соусы']")
    private SelenideElement saucesSection;
    //локатор раздела "Начинки"
    @FindBy(how = How.XPATH, using = "//span[text() = 'Начинки']")
    private SelenideElement fillingsSection;

    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private SelenideElement bunsSectionText;
    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private SelenideElement saucesSectionText;
    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private SelenideElement fillingsSectionText;

    //метод нажатия на кнопку Войти в аккаунт
    public void clickLoginButton() {
        loginButton.click();
    }

    //метод нажатия на кнопку 'Личный кабинет'
    public void clickPersonalAreaButton() {
        personalAreaButton.click();
    }

    //метод проверки существования кнопки 'Оформить заказ'
    public boolean isCheckoutButtonExist() {
        checkoutButton.shouldBe(Condition.exist);
        return checkoutButton.isDisplayed();
    }

    public void isBunsTabOpen() {
        bunsSectionText.shouldBe(visible);
    }

    public void isSaucesTabWorks() {
        saucesSection.click();
        saucesSectionText.shouldBe(visible);
    }

    public void isFillingsTabWorks() {
        fillingsSection.click();
        fillingsSectionText.shouldBe(visible);
    }

    public void isBunsTabWorks() {
        bunsSection.click();
        isBunsTabOpen();
    }
}