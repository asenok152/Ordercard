import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
    WebDriver driver;
    private String input__control;

    @BeforeAll
    static void setDriverPath(){
    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
    }

    @BeforeEach
    void setUp(){
    driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown(){
    driver.quit();
    driver = null;
    }

    @Test
    void someTest(){
        driver.get("http://localhost:9999");
     //   Thread.sleep(L 5000);
        List<WebElement> elements = driver.findElements(By.className(input__control));
        elements.get(0).sendKeys("Василий");
        elements.get(1).sendKeys("+79270000000");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();
        String text = driver.findElement(By.className("alert-success")).getText();
        assertEquals("Ваша заявка успешно отправлена", text.trim());
    }
}
