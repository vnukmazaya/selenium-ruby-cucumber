package sortpackage;

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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class sortclass {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "E://WRK/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        //Выбрать раздел Мобильные телефоны
        driver.findElement(By.xpath("//a[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS' and text()='Мобильные телефоны']")).click();
        //Выбрать сортировку по цене
        driver.findElement(By.xpath("//a[@class='link link_theme_major n-filter-sorter__link i-bem link_js_inited' and text()='по цене']")).click();
        //Проверить, что элементы на странице отсортированы верно
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        int sumel = driver.findElements(By.xpath("//div[@class='price']")).size();
        System.out.println("Телефонов на странице найдено: "+sumel);
        for (int i = 0; i <= sumel-2; i++) {
            String mas = driver.findElements(By.xpath("//div[@class='price']")).get(i).getText();
            String mas1 = driver.findElements(By.xpath("//div[@class='price']")).get(i+1).getText();
            String sprice = mas.replaceFirst(" \u20BD", "");
            String sprice1 = mas1.replaceFirst(" \u20BD", "");
            int intprice = Integer.parseInt(sprice);
            int intprice1 = Integer.parseInt(sprice1);
            if (intprice<=intprice1) {
                System.out.println("OK: "+intprice+"<="+intprice1);
            }
            else {
                System.out.println("ERROR: "+intprice+">"+intprice1+" ?");
            }
        }
        System.out.println("TEST PASSED");
    }
    @AfterClass
    public static void exit() {
        driver.quit();
    }
}
