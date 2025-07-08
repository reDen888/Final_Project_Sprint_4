package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OrderPage;
import pages.OrderStatusPage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdditionalTest extends BaseTest {

    // Доп. тест 1: Логотип Самоката
    @Test
    public void dop1_clickScooterLogoRedirectsToHomepage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickOrderButtonTop();
        mainPage.clickScooterLogo();
        assertEquals("Главная страница не открылась",
                "https://qa-scooter.praktikum-services.ru/",
                driver.getCurrentUrl());
    }

    // Доп. тест 2: Логотип Яндекса
    @Test
    public void dop2_clickYandexLogoOpensDzen() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickYandexLogo();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.urlContains("dzen.ru"));

        assertTrue("Страница Яндекса не открылась",
                driver.getCurrentUrl().contains("dzen.ru"));
    }

    // Доп. тест 3: Ошибки в форме заказа
    @Test
    public void dop3_checkOrderFormValidation() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickOrderButtonTop();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstPage("", "", "", "", "");

        assertTrue("Ошибка имени не отображается",
                driver.findElement(By.xpath("//div[text()='Введите корректное имя']")).isDisplayed());
    }

    // Доп. тест 4: Неверный номер заказа
    @Test
    public void dop4_checkInvalidOrderNumber() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.searchOrderStatus("000000");

        OrderStatusPage statusPage = new OrderStatusPage(driver);
        assertEquals("Сообщение об ошибке некорректно",
                "Заказ не найден",
                statusPage.getNotFoundMessage());
    }
}