package manager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactPage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("email"), contact.email());
        type(By.name("homepage"), contact.homepage());
        dropdownClick(By.xpath("//select[@name='bday']"), contact.bday());
        dropdownClick(By.xpath("//select[@name='bmonth']"), contact.bmonth());
        type(By.name("byear"), contact.byear());
        dropdownClick(By.xpath("//select[@name='aday']"), contact.aday());
        dropdownClick(By.xpath("//select[@name='amonth']"), contact.amonth());
        type(By.name("ayear"), contact.ayear());
    }

    private void dropdownClick(By locator, String text) {
        click(locator);
        WebElement dropdown = manager.driver.findElement(locator);
        dropdown.findElement(By.xpath("//option[. = '" + text + "']")).click();
    }

    public void removeContact() {
        selectContact();
        removeSelectedContacts();
        returnToContactPage();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void returnToContactPage() {
        click(By.linkText("home"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }


}