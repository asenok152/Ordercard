import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestClass {
    @BeforeEach
    void setUp() {
        Selenide.open("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        getWebDriver().quit();
    }

    @Test
    void someTest() {
        List<WebElement> elements = getWebDriver().findElements(By.className("input__control"));
        elements.get(0).sendKeys("Петров Василий");
        elements.get(1).sendKeys("+79270000000");
        getWebDriver().findElement(By.className("checkbox__box")).click();
        getWebDriver().findElement(By.className("button")).click();
        String text = getWebDriver().findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
}
