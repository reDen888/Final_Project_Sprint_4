package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    // Локаторы первой страницы заказа (Для кого самокат)
    private final By nameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    // Локаторы второй страницы заказа (Про аренду)
    private final By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriod = By.xpath("//div[text()='* Срок аренды']");
    private final By colorBlack = By.id("black");
    private final By colorGrey = By.id("grey");
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By confirmButton = By.xpath("//button[text()='Да']");
    private final By successMessage = By.xpath("//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstPage(String name, String surname, String address, String metro, String phone) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroInput).click();
        driver.findElement(By.xpath(String.format("//div[text()='%s']", metro))).click();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    public void fillSecondPage(String date, String period, String color, String comment) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(String.format("//div[text()='%s']", period))).click();

        if (color.equals("чёрный жемчуг")) {
            driver.findElement(colorBlack).click();
        } else {
            driver.findElement(colorGrey).click();
        }

        driver.findElement(commentInput).sendKeys(comment);
        driver.findElement(orderButton).click();
        driver.findElement(confirmButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }
}