package model;

public record ContactData(String id,String firstname, String middlename, String lastname, String nickname, String title,
                          String company, String address, String home, String email, String homepage, String bday,
                          String bmonth, String byear, String aday, String amonth, String ayear, String photo) {

    public ContactData() {
        this(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "-",
                "-",
                "",
                "-",
                "-",
                "",
                "");
    }

    public ContactData withId(String id) {
        return new ContactData(
                id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(
                this.id,
                firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
        this.photo);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withAddress(String address) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withEmail(String email) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withHome(String home) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }


    public ContactData withMiddlename(String middlename) {
        return new ContactData(
                this.id,
                this.firstname,
                middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withTitle(String title) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withCompany(String company) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withHomepage(String homepage) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withBday(String bday) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withAday(String aday) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withBmonth(String bmonth) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withAmonth(String amonth) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withByear(String byear) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                byear,
                this.aday,
                this.amonth,
                this.ayear,
                this.photo);
    }

    public ContactData withAyear(String ayear) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                ayear,
                this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(
                this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear,
                photo);
    }
}