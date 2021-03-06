import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void succesFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Sergei");
        $("#lastName").setValue("Kashtuev");
        $("#userEmail").setValue("kashtuev@gmail.com");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("9515705298");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1990");
        $$(".react-datepicker__day").find(text("29")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("mexico.jpg");
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Sergei"), text("Kashtuev"), text("kashtuev@gmail.com"),
                text("Male"), text("9515705298"), text("January"), text("1990"),
                text("29"),text("English"),text("mexico.jpg"),text("Russia"),text("NCR"),text("Delhi"));
    }
}
