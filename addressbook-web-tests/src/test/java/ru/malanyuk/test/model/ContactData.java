package ru.malanyuk.test.model;

public class ContactData {
    private String firstname;
    private String lastname;
    private String nickname;
    private String company;
    private String mobile;
    private String email;
    private String bithdayDay;
    private String bithdayMounth;
    private String bithdayYear;
    private int id = Integer.MAX_VALUE;

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withBithdayDay(String bithdayDay) {
        this.bithdayDay = bithdayDay;
        return this;
    }

    public ContactData withBithdayMounth(String bithdayMounth) {
        this.bithdayMounth = bithdayMounth;
        return this;
    }

    public ContactData withBithdayYear(String bithdayYear) {
        this.bithdayYear = bithdayYear;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getBithdayDay() {
        return bithdayDay;
    }

    public String getBithdayMounth() {
        return bithdayMounth;
    }

    public String getBithdayYear() {
        return bithdayYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
