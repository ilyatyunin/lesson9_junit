package ru.betboom;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Web тесты для демонстрации работы JUnit")
public class GoogleWebTest {
    @BeforeEach
    void setup() {
        open("https://www.google.com/");
    }

//    @CsvSource({
//            "selenide, https://selenide.org",
//            "JUnit, https://junit.org"
//    })
    // OR
    @CsvFileSource(resources = "/successfulSearchTest.csv", delimiter = '|')
    @ParameterizedTest(name = "Для поискового запроса {0} в выдаче присутствует url: {1}")
    @Tag("WEB")
    @Tag("BLOCKER")
    void successfulSearchTest(String searchQuery, String expectedUrl) {
        $("[name=q]").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expectedUrl));
    }

    @Test
    @Tag("WEB")
    @Tag("BLOCKER")
    @DisplayName("Для поискового запроса 'JUnit' в выдаче присутствует url 'https://junit.org'")
    void successfulSearchJunitTest() {
        $("[name=q]").setValue("JUnit").pressEnter();
        $("[id=search]").shouldHave(text("https://junit.org"));
    }



    @ValueSource(strings = {
            "selenide",
            "junit"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} нажимается кнопка 'Мне повезёт!'")
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    @DisplayName("")
    void fartTest(String searchQuery) {
        $("[name=q]").setValue(searchQuery);
        $$("input[name='btnI']").filter(visible).
                first().
                click();
    }

}
