import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $("#userNumber").setValue("9505705298");
        $("#датарождения").setValue("");
        $("#сабджектс").setValue("");
        $("#хобби").setValue("");
        $("#uploadPicture").setValue("");
        $("#currenAddress").setValue("Russia");
        $("#селектштата").setValue("");
        $("#селектгорода").setValue("");
        $("#submit").click();

        $("#output").shouldHave(text("Sergei"),text("Kashtuev"), text("kashtuev@gmail.com"));
    }
}
