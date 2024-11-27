package ru.stqa.addressbook.manager;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    @Step
    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactPage();
    }

    @Step
    public void createContact(ContactData contact, GroupData group) {
        initContactCreation();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToContactPage();
    }

    @Step
    public void removeContactFromGroup(ContactData contact, GroupData group) {
        returnToContactPage();
        selectRemoveGroup(group);
        selectContact(contact);
        removeFromGroup();
        returnToContactPage();
    }

    @Step
    public void addContactToGroup(ContactData contact, GroupData group) {
        returnToContactPage();
        selectContact(contact);
        selectAddGroup(group);
        addToGroup();
        returnToContactPage();
    }

    private void addToGroup() {
        click(By.name("add"));
    }

    private void selectRemoveGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void selectAddGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void removeFromGroup() {
        click(By.name("remove"));
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    @Step
    public void modifyContact(ContactData contact, ContactData modifiedContact, int index) {
        returnToContactPage();
        selectContact(contact);
        initContactModification(index);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactPage();
    }

//    public void modifyContact(ContactData contact, ContactData modifiedContact, int index) {
//        selectContact(contact);
//        initContactModification(index);
//        fillContactFormMod(modifiedContact);
//        submitContactModification();
//        returnToContactPage();
//    }

    @Step
    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContacts();
        returnToContactPage();
    }

    @Step
    public void removeAllContact() {
        selectAllContact();
        removeSelectedContacts();
        returnToContactPage();
    }

    @Step
    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification(int index) {
        int teg_index = index + 2;
        click(By.xpath("//tr[" + teg_index + "]/td[8]/a/img[@alt='Edit']"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
    }

    private void fillContactFormMod(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
    }

    private void dropdownClick(By locator, String text) {
        click(locator);
        WebElement dropdown = manager.driver.findElement(locator);
        dropdown.findElement(By.xpath("//option[. = '" + text + "']")).click();
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContacts() {
        click(By.cssSelector(".left:nth-child(8) > input"));
    }

    private void returnToContactPage() {
        click(By.linkText("home"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void selectAllContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));

        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public int getCount() {
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        returnToContactPage();
//        var contacts = new ArrayList<ContactData>();
        var main_locators = manager.driver.findElements(By.cssSelector("tr:not(:first-child)"));
        return main_locators.stream()
                .map(locator -> {
                    var lastname = locator.findElement(By.cssSelector("td:nth-child(2)")).getText();
                    var firstname = locator.findElement(By.cssSelector("td:nth-child(3)")).getText();
                    var checkbox_locator = locator.findElement(By.name("selected[]"));
                    var id = checkbox_locator.getAttribute("value");
                    return new ContactData()
                            .withId(id)
                            .withFirstname(firstname)
                            .withLastname(lastname);
                })
                .collect(Collectors.toList());
//        for (var locator : main_locators) {
//            var lastname = locator.findElement(By.cssSelector("td:nth-child(2)")).getText();
//            var firstname = locator.findElement(By.cssSelector("td:nth-child(3)")).getText();
//            var checkbox_locator = locator.findElement(By.name("selected[]"));
//            var id = checkbox_locator.getAttribute("value");
//
//            contacts.add(new ContactData()
//                    .withId(id)
//                    .withFirstname(firstname)
//                    .withLastname(lastname));
//            //       .withPhoto("src/test/resources/images/avatar.png"));
//        }
//        return contacts;
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath
                        (String.format("//input[@id='%s']/../../td[5]", contact.id()))).
                getText();

    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath
                        (String.format("//input[@id='%s']/../../td[4]", contact.id()))).
                getText();
    }

    public String getPhoneEditMode() {
        var homeNumber = manager.driver.findElement(By.name("home")).getAttribute("value");
        var mobileNumber = manager.driver.findElement(By.name("mobile")).getAttribute("value");
        var workNumber = manager.driver.findElement(By.name("work")).getAttribute("value");
        return Stream.of(homeNumber, mobileNumber, workNumber)
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
    }

    public String getAddressEditMode() {
        var address = manager.driver.findElement(By.name("address")).getAttribute("value");
        return address;
    }

    public String getEmailsEditMode() {
        var email = manager.driver.findElement(By.name("email")).getAttribute("value");
        var email2 = manager.driver.findElement(By.name("email2")).getAttribute("value");
        var email3 = manager.driver.findElement(By.name("email3")).getAttribute("value");
        return Stream.of(email, email2, email3)
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
    }

    public void initContactModification(ContactData contact) {
        var elementId = manager.driver.findElement(By.id(contact.id()));
        var entry = elementId.findElement(By.xpath("../.."));
        var editButton = entry.findElement(By.cssSelector("td:nth-child(8)"));
        editButton.click();
    }
}
