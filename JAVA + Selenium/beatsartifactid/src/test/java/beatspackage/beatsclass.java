package beatspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.Robot;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class beatsclass {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "E://WRK/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void openpage() {
        //Открываем яндекс
        driver.get("https://yandex.ru");
        //Открываем маркет
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@data-id='market']")).click();
        //Выбрать раздел Электроника
        driver.findElement(By.xpath("//a[@href='/catalog/54440']")).click();
        //Выбрать раздел Наушники
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath( "//a[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS' and text()='Наушники и Bluetooth-гарнитуры']")).click();

        //Перейти в расширенный поиск
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath( "//span[@class='_28j8Lq95ZZ']")).click();

        //Задать параметр поиска от 5000 рублей.
        driver.findElement(By.xpath( "//input[@name='glf-pricefrom-var']")).sendKeys("5000");

        //Выбрать производителя Beats
        driver.findElement(By.xpath( "//label[@for='glf-7893318-8455647']")).click();

        //Нажать кнопку Применить.
        driver.findElement(By.xpath( "//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")).click();

        // Проверить, что элементов на странице 12.
        int sumel1 = driver.findElements(By.xpath("//div[@date-rate>0]")).size();
        if (sumel1 != 12) {
            System.out.print("ERROR(not 12,");
            System.out.println(sumel1+" Наушников найдено)");
        }
        else {
            System.out.println(sumel1+"Наушников найдено)");
        }

        // Запомнить первый элемент в списке.Найти и проверить,
        WebElement firstel = driver.findElements(By.xpath("//div[@date-rate>0]")).get(0);
        firstel.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String text12 = driver.findElement(By.xpath("//div[@class='n-title__text']")).getText();
        driver.findElement(By.xpath("//input[@id='header-search']")).sendKeys(text12);
        driver.findElement(By.xpath("//button[@role='button' and @type ='submit']")).click();
        WebElement firstel1 = driver.findElements(By.xpath("//div[@date-rate>0]")).get(0);
        firstel1.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String text13 = driver.findElement(By.xpath("//div[@class='n-title__text']")).getText();
        boolean ravenstvo = text12.equals(text13);
        if (ravenstvo) {
            System.out.print("TEST DONE");
        }
        else {
            System.out.print("ERROR (requests is not equal)");
        }
    }
//    @AfterClass
//    public static void exit() {
//        driver.quit();
//    }

}
    