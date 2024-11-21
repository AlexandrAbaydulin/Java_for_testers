package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTest extends TestBase {

    // Создание контакта
    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData(
                "firstname",
                "middlename",
                "lastname",
                "nickname",
                "title",
                "company",
                "address",
                "home",
                "email",
                "homepage",
                "19",
                "April",
                "1993",
                "16",
                "April",
                "2024"));
    }

    // Создание контакта с пустыми полями
    @Test
    public void canCreateContactWithEmptyName() {
        app.contacts().createContact(new ContactData());
    }

    // Создание контакта с Firstname
    @Test
    public void canCreateContactWithFirstnameOnly() {
        app.contacts().createContact(new ContactData().withFirstname("name"));
    }

    // Создание контакта с Lastnam
    @Test
    public void canCreateContactWithLastnameOnly() {
        app.contacts().createContact(new ContactData().withLastname("family"));
    }

    // Создание контакта с Address
    @Test
    public void canCreateContactWithAddressOnly() {
        app.contacts().createContact(new ContactData().withAddress("city"));
    }

    // Создание контакта с Email
    @Test
    public void canCreateContactWithEmailOnly() {
        app.contacts().createContact(new ContactData().withEmail("mail@mail.com"));
    }

    // Создание контакта с Home
    @Test
    public void canCreateContactWithHomeNumberOnly() {
        app.contacts().createContact(new ContactData().withHome("65456"));
    }
}