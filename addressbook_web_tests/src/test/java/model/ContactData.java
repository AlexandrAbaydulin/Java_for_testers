package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String title,
                          String company, String address, String home, String email, String homepage, String bday,
                          String bmonth, String byear, String aday, String amonth, String ayear) {

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
                "-",
                "-",
                "",
                "-",
                "-",
                "");
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withAddress(String address) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withEmail(String email) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withHome(String home) {
        return new ContactData(
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
                this.ayear);
    }


    public ContactData withMiddlename(String middlename) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withTitle(String title) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withCompany(String company) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withHomepage(String homepage) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withBday(String bday) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withAday(String aday) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withBmonth(String bmonth) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withAmonth(String amonth) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withByear(String byear) {
        return new ContactData(
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
                this.ayear);
    }

    public ContactData withAyear(String ayear) {
        return new ContactData(
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
                ayear);
    }
}