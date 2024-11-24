package ru.stqa.addressbook.model;

public record ContactData(String id, String firstname, String lastname) {

    public ContactData() {
        this(
                "" ,
                "",
                "");
    }

    public ContactData withId(String id) {
        return new ContactData(
                id,
                this.firstname,
                this.lastname);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(
                this.id,
                firstname,
                this.lastname);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(
                this.id,
                this.firstname,
                lastname);
    }
}