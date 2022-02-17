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
    String firstName = "Sergei";
    String lastName = "Kashtuev";
    String email = "29061990a@gmail.com";
    String gender = "Male";
    String number = "9515705298";
    String day = "29";
    String month = "January";
    String year = "1990";
    String subject = "English";
    String hobby = "Music";
    String picture = "mexico.jpg";
    String address = "Russia";
    String state = "NCR";
    String city = "Delhi";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        registrationPage.setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setGender(gender)
                        .setMobileNumber(number)
                        .setBirthDate(day,month,year)
                        .selectSubject(subject)
                        .selectHobbies(hobby)
                        .uploadImage(picture)
                        .setCurrentAddress(address)
                        .selectState(state)
                        .selectCity(city)
                        .submitForm()

                .verifyForm("Student Name", firstName+""+lastName)
                .verifyForm("Student Email", email)
                .verifyForm("Gender", gender)
                .verifyForm("Mobile", number)
                .verifyForm("Date of Birth", day + month + year)
                .verifyForm("Subjects", subject)
                .verifyForm("Hobbies", hobby)
                .verifyForm("Picture", picture)
                .verifyForm("Address", address)
                .verifyForm("State and City", state + city);

    }
}

