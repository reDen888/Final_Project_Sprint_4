package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    // Локаторы
    private final By cookieButton = By.id("rcc-confirm-button"); // Кнопка согласия с куки
    private final By orderButtonTop = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g']"); // Верхняя кнопка заказа
    private final By orderButtonBottom = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']"); // Нижняя кнопка заказа
    private final By faqQuestion = By.xpath("//div[@data-accordion-component='AccordionItem']"); // Вопросы FAQ
    private final By faqAnswer = By.xpath("//div[@data-accordion-component='AccordionItemPanel']"); // Ответы FAQ
    private final By scooterLogo = By.xpath("//a[@class='Header_LogoScooter__3lsAR']"); // Логотип Самоката
    private final By yandexLogo = By.xpath("//a[@class='Header_LogoYandex__3TSOI']"); // Логотип Яндекса
    private final By orderStatusInput = By.xpath("//input[@placeholder='Введите номер заказа']"); // Поле статуса заказа
    private final By goButton = By.xpath("//button[text()='Go!']"); // Кнопка поиска заказа

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void clickFaqQuestion(int index) {
        driver.findElements(faqQuestion).get(index).click();
    }

    public String getFaqAnswer(int index) {
        return driver.findElements(faqAnswer).get(index).getText();
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void searchOrderStatus(String orderNumber) {
        driver.findElement(orderStatusInput).sendKeys(orderNumber);
        driver.findElement(goButton).click();
    }
}