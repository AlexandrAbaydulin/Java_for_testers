package ru.stqa.mantis.tests.other;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.tests.TestBase;

public class JamesTests extends TestBase {

    @Test
    void canCreateUsers() {
        app.jamesCli().addUser(
                String.format("%s@localhost", CommonFunctions.randomString(8)),
                "password");
    }
}
