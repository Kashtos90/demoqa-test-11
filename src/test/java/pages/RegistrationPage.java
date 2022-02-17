package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement mainHeader = $(".main-header");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement birthDateInput = $("#dateOfBirthInput");
    private SelenideElement mobileNumberInput = $("#userNumber");
    private SelenideElement subjectsChoice = $("#subjectsInput");
    private SelenideElement chooseFileButton = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateChoice = $("#state");
    private SelenideElement cityChoice = $("#city");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement filledModalForm = $(".modal-content");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        mainHeader.shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setMobileNumber(String number) {
        mobileNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setBirthDate(day, month, year);
        return this;
    }

    public RegistrationPage selectSubject(String subject) {
        subjectsChoice.sendKeys("a");
        $(byText(subject)).click();
        return this;
    }

    public RegistrationPage selectHobbies(String hobbyOne, String hobbyTwo) {
        $(byText(hobbyOne)).click();
        $(byText(hobbyTwo)).click();
        return this;
    }

    public RegistrationPage uploadImage(String fileName) {
        chooseFileButton.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectState(String state) {
        stateChoice.scrollTo().click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityChoice.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyForm(String label, String value) {
        filledModalForm.shouldBe(visible);
        filledModalForm.$(byText(label)).parent().shouldHave(text(value));
        return this;
    }
}

