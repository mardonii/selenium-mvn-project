package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Traveloka {

    @Test
    public void go(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.traveloka.com");
        WebElement CarRental = driver.findElement(By.xpath("//div[@dir='auto' and text()= 'Car Rental']"));
        CarRental.click();
    }

    @Test
    public void get(){
        System.out.println("ini udah mulai");
        go();
        System.out.println("ini udah selesai");
    }
}
