package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        registrationPage.setFirstName("Sergei")
                        .setLastName("Kashtuev")
                        .setEmail("29061990a@gmail.com")
                        .setGender("Male")
                        .setMobileNumber("9515705298")
                        .setBirthDate("29","January","1990")
                        .selectSubject("English")
                        .selectHobbies("Music")
                        .uploadImage("mexico.jpg")
                        .setCurrentAddress("Russia")
                        .selectState("NCR")
                        .selectCity("Delhi")
                        .submitForm()

                .verifyForm("Student Name", "Sergei Kashtuev")
                .verifyForm("Student Email", "29061990a@gmail.com")
                .verifyForm("Gender", "Male")
                .verifyForm("Mobile", "9515705298")
                .verifyForm("Date of Birth", "29 January,1990")
                .verifyForm("Subjects", "English")
                .verifyForm("Hobbies", "Music")
                .verifyForm("Picture", "mexico.jpg")
                .verifyForm("Address", "Russia")
                .verifyForm("State and City", "NCR Delhi");

    }
}

