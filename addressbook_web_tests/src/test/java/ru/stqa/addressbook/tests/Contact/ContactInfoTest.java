package ru.stqa.addressbook.tests.Contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.tests.TestBase;

import java.util.Random;

public class ContactInfoTest extends TestBase {


    @Test
    void testEmailsAddressPhones() {

        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var contact = oldContacts.get(index);
        var phones = app.contacts().getPhones(contact);
        var address = app.contacts().getAddress(contact);
        var emails = app.contacts().getEmails(contact);
        app.contacts().initContactModification(contact);
        var phonesEditMode = app.contacts().getPhoneEditMode();
        var addressEditMode = app.contacts().getAddressEditMode();
        var emailsEditMode = app.contacts().getEmailsEditMode();

        Assertions.assertEquals(phones, phonesEditMode);
        Assertions.assertEquals(address, addressEditMode);
        Assertions.assertEquals(emails, emailsEditMode);
    }
//    @Test
//    void testPhones() {
//        var contacts = app.hbm().getContactList();
//        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
//                Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary())
//                        .filter(s -> s != null && !"".equals(s))
//                        .collect(Collectors.joining("\n"))
//        ));
//        var phones = app.contacts().getPhones();
//        Assertions.assertEquals(expected, phones);
//    }
//
//    @Test
//    void testEmails() {
//        var contacts = app.hbm().getContactList();
//        var contact = contacts.get(0);
//
//        var emails = app.contacts().getEmails(contact);
//        var expected = Stream.of(contact.email(), contact.email2(), contact.email3()).
//                filter(s -> s != null && !s.equals("")).
//                collect(Collectors.joining("\n"));
//
//        Assertions.assertEquals(expected, emails);
//
//    }
//
//    @Test
//    void testAddress() {
//        var contacts = app.hbm().getContactList();
//        var contact = contacts.get(0);
//
//        var address = app.contacts().getAddress(contact);
//        var expected = Stream.of(contact.address()).
//                filter(s -> s != null && !s.equals("")).
//                collect(Collectors.joining("\n"));
//
//        Assertions.assertEquals(expected, address);
//    }
}

