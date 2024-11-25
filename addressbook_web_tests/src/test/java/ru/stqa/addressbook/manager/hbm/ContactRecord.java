package ru.stqa.addressbook.manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")

public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "address")
    public String address;

    @Column(name = "home")
    public String home;

    @Column(name = "mobile")
    public String mobile;

    @Column(name = "work")
    public String work;

    @Column(name = "email")
    public String email;

    @Column(name = "photo")
    public String photo;

    @Column(name = "phone2")
    public String phone2;

    @Column(name = "email2")
    public String email2;

    @Column(name = "email3")
    public String email3;

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String address,
                         String home, String mobile, String work, String email, String photo,
                         String secondary, String email2, String email3) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.photo = photo;
        this.phone2 = secondary;
        this.email2 = email2;
        this.email3 = email3;
    }
}