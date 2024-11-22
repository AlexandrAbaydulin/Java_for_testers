package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {


    public WebDriver driver;

    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contacts;

    public void init(String browser) {
        if (driver == null) {
            if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            session().login("admin", "secret");
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public ContactHelper contacts() {
        if (contacts == null) {
            contacts = new ContactHelper(this);
        }
        return contacts;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).sendKeys(contact.title());
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).sendKeys(contact.company());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys(contact.home());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contact.email());
        driver.findElement(By.name("homepage")).click();
        driver.findElement(By.name("homepage")).sendKeys(contact.homepage());
        driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.bday() + "']")).click();
        }
        driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.bmonth() + "']")).click();
        }
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).sendKeys(contact.byear());
        driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.aday() + "']")).click();
        }
        driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.amonth() + "']")).click();
        }
        driver.findElement(By.name("ayear")).click();
        driver.findElement(By.name("ayear")).sendKeys(contact.ayear());
        driver.findElement(By.xpath("//div[@id=\'content\']/form/input[20]")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        driver.findElement(By.linkText("home")).click();
    }

}
