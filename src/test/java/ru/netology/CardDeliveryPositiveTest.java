package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$$;

public class CardDeliveryPositiveTest {
    int days = 4;
    MeetingDate meetingDate = new MeetingDate();

    @BeforeEach
    void setup() {
        open("http://localhost:9999/");
    }

    @Test
    public void ShouldSendForm() {
        SelenideElement form = $("[data-test-id=app-card-delivery]");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(meetingDate.generateDate(days));
        $("[data-test-id='name'] input").setValue("Зубенко Михаил");
        $("[data-test-id='phone'] input").setValue("+79887829686");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на " + meetingDate.generateDate(days)), Duration.ofSeconds(15));
    }
}
