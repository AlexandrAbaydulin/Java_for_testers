package ru.stqa.addressbook.tests.Contact;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class ContactRemovalTest extends TestBase {


    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData(
                    "",
                    "",
                    ""));
        }
//получить количество контактов. что бы сравнить с новым количеством
        // int contactCount = app.contacts().getCount();
//--------------------------------------------------------------------
//получение списка контактов с интерфейса
//        var oldContact = app.contacts().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldContact.size());
//        app.contacts().removeContact(oldContact.get(index));
//        var newContact = app.contacts().getList();
//--------------------------------------------------------------------
//получение списка групп с БД
//        var oldContacts = app.jdbc().getContactList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldContacts.size());
//        app.contacts().removeContact(oldContacts.get(index));
//        var newContacts = app.jdbc().getContactList();
//Получение списков с использованием Hibernate
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
//получить количество контактов. что бы сравнить со старым количеством
        // int newContactCount = app.contacts().getCount();
//--------------------------------------------------------------------
        Assertions.assertEquals(newContacts, expectedList);
    }

//    @Test
//    public void canRemoveContact() {
//        if (!app.contacts().isContactPresent()) {
//            app.contacts().createContact(
//                    new ContactData()
//                            .withFirstname(CommonFunctions.randomString(10))
//                            .withLastname(CommonFunctions.randomString(10)));
//        }
//        var oldContact = app.contacts().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldContact.size());
//        app.contacts().removeContact(oldContact.get(index));
//        var newContact = app.contacts().getList();
//        var expectedList = new ArrayList<>(oldContact);
//        expectedList.remove(index);
//        Assertions.assertEquals(newContact, expectedList);
//    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(
                    new ContactData()
                            .withFirstname(CommonFunctions.randomString(10))
                            .withLastname(CommonFunctions.randomString(10)));
        }
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.contacts().getCount());
    }

    @Test
    void canRemoveContactFromGroup() {
        Allure.step("Checking precondition", step -> {
            if (app.hbm().getGroupCount() == 0) {
                app.hbm().createGroup(new GroupData()
                        .withName(CommonFunctions.randomString(10))
                        .withHeader(CommonFunctions.randomString(10))
                        .withFooter(CommonFunctions.randomString(10)));
            }
        });
        var group = app.groups().getList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        if (oldRelated.isEmpty()) {
            var contact = new ContactData()
                    .withFirstname(CommonFunctions.randomString(10))
                    .withLastname(CommonFunctions.randomString(10));
            app.contacts().createContact(contact, group);
            oldRelated = app.hbm().getContactsInGroup(group);
        }
        var rnd = new Random();
        var index = rnd.nextInt(oldRelated.size());
        app.contacts().removeContactFromGroup(oldRelated.get(index), group);
        var newRelated = app.hbm().getContactsInGroup(group);
        var expectedList = new ArrayList<>(oldRelated);
        expectedList.remove(index);
        Allure.step("Validating results", step -> {
            Assertions.assertEquals(Set.copyOf(newRelated), Set.copyOf(expectedList));
        });
    }
}

