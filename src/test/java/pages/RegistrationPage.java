package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            mainHeader = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            birthDateInput = $("#dateOfBirthInput"),
            mobileNumberInput = $("#userNumber"),
            subjectsChoice = $("#subjectsInput"),
            chooseFileButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateChoice = $("#state"),
            cityChoice = $("#city"),
            submitButton = $("#submit"),
            filledModalForm = $(".modal-content");

    public void openPage() {
        open("/automation-practice-form");
        mainHeader.shouldHave(text("Practice Form"));
    }

     void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setGender(String gender) {
        $(byText(gender)).click();

    }

    public void setMobileNumber(String number) {
        mobileNumberInput.setValue(number);

    }

    public void setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setBirthDate(day, month, year);

    }

    public void selectSubject(String subject) {
        subjectsChoice.sendKeys("a");
        $(byText(subject)).click();
    }

    public void selectHobbies(String hobbyOne, String hobbyTwo) {
        $(byText(hobbyOne)).click();
        $(byText(hobbyTwo)).click();
    }

    public void uploadImage(String fileName) {
        chooseFileButton.uploadFromClasspath(fileName);
    }

    public void setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
    }

    public void selectState(String state) {
        stateChoice.scrollTo().click();
        $(byText(state)).click();
    }

    public void selectCity(String city) {
        cityChoice.click();
        $(byText(city)).click();
    }

    public void submitForm() {
        submitButton.click();
    }

    public void verifyForm(String label, String value) {
        filledModalForm.shouldBe(visible);
        filledModalForm.$(byText(label)).parent().shouldHave(text(value));
    }
}

