package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Traveloka {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Random random = new Random();

    @Test
    public void go() {
        driver.manage().window().maximize();

        driver.get("https://www.traveloka.com");
        WebElement CarRental = driver.findElement(By.xpath("//div[@dir='auto' and text()= 'Car Rental']"));
        CarRental.click();
        WebElement addressInput = driver.findElement(By.xpath("//input[@placeholder='Enter city or region']"));
        addressInput.sendKeys("Jakarta");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='rental-search-form-location-input-dropdown']")));

        WebElement locationRec = driver.findElement(By.xpath("//div[@dir='auto' and contains(text(), 'Jakarta Special C')]"));
        locationRec.click();

        WebElement datePicker = driver.findElement(By.xpath("//input[@dir='auto' and contains(@value, 'March')]"));
        datePicker.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid= 'mds-calendar']")));

        int randomInt = random.nextInt(30) + 1;
        WebElement date = driver.findElement(By.xpath("//div[@data-testid= 'date-cell-" + randomInt + "-4-2024']"));
        date.click();

        WebElement btnSearch = driver.findElement(By.xpath("//div[@data-testid = 'rental-search-form-cta']/.."));
        btnSearch.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@role='heading' and contains(text(), 'Rental Without')]")));

    }

    @Test
    public void get() {
        System.out.println("ini udah mulai");
        go();
        System.out.println("ini udah selesai");
    }
}
