package ru.stqa.addressbook.tests.Contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTest extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(
                    new ContactData()
                            .withFirstname(CommonFunctions.randomString(10))
                            .withLastname(CommonFunctions.randomString(10))
                            .withPhoto(randomFile("src/test/resources/images")));
        }
        var oldContact = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        app.contacts().removeContact(oldContact.get(index));
        var newContact = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.remove(index);
        Assertions.assertEquals(newContact, expectedList);
    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(
                    new ContactData()
                            .withFirstname(CommonFunctions.randomString(10))
                            .withLastname(CommonFunctions.randomString(10))
                            .withPhoto(randomFile("src/test/resources/images")));
        }
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}
