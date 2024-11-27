package ru.stqa.addressbook.tests.Contact;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.tests.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ContactCreationTest extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();

        // Чтение файла построчно FileReader("groups.json")
//        var json = "";
//        try (var reader = new FileReader("groups.json");
//            var breader = new BufferedReader(reader)
//        ) {
//            var line = breader.readLine();
//            while(line != null) {
//                json = json + line;
//                line = breader.readLine();
//            }
//        }
        // Чтение файла целиком Files.readString(Paths.get("groups.json")
        //var json = Files.readString(Paths.get("groups.json"));
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }

    public static Stream<ContactData> randomContacts() {
        Supplier<ContactData> randomContact = () -> new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10));
        return Stream.generate(randomContact).limit(3);
    }

    @ParameterizedTest
    @MethodSource("randomContacts")
    public void canCreateSingleContact(ContactData contact) {
//        var oldContacts = app.jdbc().getContactList();
//        app.contacts().createContact(contact);
//        var newContacts = app.jdbc().getContactList();
        //Получение списка контактов с применением Hibernate
        var oldContacts = app.jdbc().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.jdbc().getContactList();

        var extraContacts = newContacts.stream().filter(g -> !oldContacts.contains(g)).toList();
        var newId = extraContacts.get(0).id();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newId));
        Assertions.assertEquals(Set.copyOf(newContacts), Set.copyOf(expectedList));
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);

        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact
                .withId(newContacts.get(newContacts.size() - 1).id())
        );
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }


//    @ParameterizedTest
//    @MethodSource("contactProvider")
//    public void canCreateMultipleContact(ContactData contact) {
//        var oldContacts = app.contacts().getList();
//        app.contacts().createContact(contact);
//        var newContacts = app.contacts().getList();
//        Comparator<ContactData> compareById = (o1, o2) -> {
//            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
//        };
//        newContacts.sort(compareById);
//
//        var expectedList = new ArrayList<>(oldContacts);
//
//        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()));
//
//        expectedList.sort(compareById);
//        Assertions.assertEquals(newContacts, expectedList);
//    }

    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10));
        app.contacts().createContact(contact);
    }

    @Test
    void canCreateContactInGroup() {
        var contact = new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData()
                    .withName(CommonFunctions.randomString(10))
                    .withHeader(CommonFunctions.randomString(10))
                    .withFooter(CommonFunctions.randomString(10)));
        }
        var group = app.groups().getList().get(0);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        var maxId = newRelated.get(newRelated.size() - 1).id();
        var expectedList = new ArrayList<>(oldRelated);
        expectedList.add(contact.withId(maxId));
        Assertions.assertEquals(newRelated, expectedList);
    }

    @Test
    void canAddExistContactToGroup() {
        var indicator = 0; //переменная индикатор
        if (app.hbm().getGroupCount() == 0) { //если групп нет, то создаем новую группу
            app.hbm().createGroup(new GroupData()
                    .withName(CommonFunctions.randomString(10))
                    .withHeader(CommonFunctions.randomString(10))
                    .withFooter(CommonFunctions.randomString(10)));
        }
        if (app.hbm().getContactCount() == 0) { // если нет контактов, вообще, то создаем контакт
            app.hbm().createContact(new ContactData()
                    .withFirstname(CommonFunctions.randomString(5))
                    .withLastname(CommonFunctions.randomString(5)));
        }
        var first_group = app.hbm().getGroupList().get(0); // получаем первую группу с индексом 0
        var oldRelated = app.hbm().getContactsInGroup(first_group); //список контактов в группе до добавления нового контакта
        var newRelated = oldRelated;
        var expectedList = new ArrayList<>(oldRelated);

        var allGroups = app.hbm().getGroupList(); //получаем список групп
        var allContacts = app.hbm().getContactList(); // получаем список контактов

        for (var group : allGroups) {
            if (indicator == 1) {
                break;
            }
            for (var contact : allContacts) {
                if (!app.hbm().getContactsInGroup(group).contains(contact)) {
                    oldRelated = app.hbm().getContactsInGroup(group); //список контактов в группе до добавления нового контакта
                    app.contacts().addContactToGroup(contact, group);//добавляем контакт в группу
                    newRelated = app.hbm().getContactsInGroup(group);
                    expectedList = new ArrayList<>(oldRelated);
                    expectedList.add(contact);
                    indicator = 1;
                    break;
                }
            }
        }
        if (indicator == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstname(CommonFunctions.randomString(5))
                    .withLastname(CommonFunctions.randomString(5)));
            allContacts = app.hbm().getContactList(); // получаем список контактов
            var index = allContacts.size();
            var newContact = app.hbm().getContactList().get(index - 1);
            app.contacts().addContactToGroup(newContact, first_group);//добавляем контакт в группу
            newRelated = app.hbm().getContactsInGroup(first_group);
            expectedList.add(newContact);
        }
        Assertions.assertEquals(Set.copyOf(newRelated), Set.copyOf(expectedList));
    }
}