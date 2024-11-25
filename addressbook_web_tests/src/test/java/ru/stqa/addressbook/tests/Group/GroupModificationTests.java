package ru.stqa.addressbook.tests.Group;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "", "", ""));
        }
//Получение списка групп из интерфейса
//        var oldGroups = app.groups().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldGroups.size());
//        var testData = new GroupData().withName("modified");
//        app.groups().modifyGroup(oldGroups.get(index), testData);
//        var newGroups = app.groups().getList();
//--------------------------------------------------------------------
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("mt_" + CommonFunctions.randomString(10));
        app.groups().modifyGroup(oldGroups.get(index), testData);
        var newGroups = app.hbm().getGroupList();

        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));

        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));
    }
}