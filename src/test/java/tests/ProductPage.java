package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ProductPage extends BaseTest{
    public static JavascriptExecutor js;

    @Test
    public void runTest() throws InterruptedException {

        int randomProductIndex = new Random().nextInt(28);
        driver.findElement(By.cssSelector(".products-container > li:nth-child(" + randomProductIndex + ")")).click();

        js = ((JavascriptExecutor) driver);
        js.executeScript("window.scroll(0,550)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@class='wis-clsbtn-98395']")).click();
        driver.findElement(By.id("add-to-basket")).click();

        WebElement element = driver.findElement(By.cssSelector("#sp-price"));
        String productPrice = element.getAttribute("value");
        System.out.println("Seçilen ürünün fiyatı : " +productPrice);

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Sepete Git']")).click();

        WebElement element1 = driver.findElement(By.cssSelector(".data-salePrice"));
        String basketPrice = element1.getAttribute("value");
        System.out.println("Sepetteki ürünün fiyatı : " +basketPrice);

        Thread.sleep(500);
        driver.findElement(By.cssSelector("select.amount>:nth-child(2)")).click();

        Thread.sleep(2000);
        driver.findElement(By.className("btn-delete")).click();

       }
}

