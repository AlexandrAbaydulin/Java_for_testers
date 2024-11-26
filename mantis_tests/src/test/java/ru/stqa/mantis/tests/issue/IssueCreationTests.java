package ru.stqa.mantis.tests.issue;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.IssueData;
import ru.stqa.mantis.tests.TestBase;

public class IssueCreationTests extends TestBase {

    // REST API
//    @Test
//    void canCreateIssue() {
//        app.rest().createIssue(new IssueData()
//                .withSummary(CommonFunctions.randomString(10))
//                .withDescription(CommonFunctions.randomString(50))
//                .withProject(1L));
//    }

    // SOAP API
    @Test
    void canCreateIssue() {
        app.soap().createIssue(new IssueData()
                .withSummary(CommonFunctions.randomString(10))
                .withDescription(CommonFunctions.randomString(50))
                .withProject(1L));
    }
}
