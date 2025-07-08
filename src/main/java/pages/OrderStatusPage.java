package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage {
    private final WebDriver driver;
    private final By notFoundMessage = By.xpath("//div[contains(text(), 'Заказ не найден')]");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNotFoundMessage() {
        return driver.findElement(notFoundMessage).getText();
    }
}