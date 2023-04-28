package ru.betboom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Демонстрационные тесты для лекции 9 по JUnit5")
public class SimpleTest {
    @Test
    @DisplayName("Демонстрационный тест для лекции 9 по JUnit5")
    @Disabled("RED-1020")
    void simpleTest() {
        Assertions.assertEquals(3,2 + 1, "Результат работы выражения не равен 3");
        Assertions.assertTrue("ilya@mail.ru".matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")); // соответствует шаблону email-адреса

    }
}
