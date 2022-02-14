package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstJUnitTests {

    @BeforeEach
    void before() {
        System.out.println("здрасьте");
        Selenide.open("https://google.com");
    }

    @AfterEach
    void after() {
        System.out.println("забор покрасьте");
        Selenide.closeWebDriver();
    }

    @Test
    void textTest() {
        // поиск по тексту
    }

    @Test
    void videoTest() {
        // поиск видео
    }
}
