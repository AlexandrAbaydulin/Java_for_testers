package tests;

import model.GroupData;
import org.junit.jupiter.api.*;

public class GroupCreationsTests extends TestBase {

    // Создание Группы с заполненными полями
    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
    }

    // Создание Группы с пустыми полями
    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    // Создание Группы с заполенным полем Name
    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }
}
