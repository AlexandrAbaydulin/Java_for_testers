package ru.stqa.mantis.tests.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.tests.TestBase;

public class LoginTests extends TestBase {

    @Test
    void canLogin() {
        app.http().login("administrator", "root");
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
