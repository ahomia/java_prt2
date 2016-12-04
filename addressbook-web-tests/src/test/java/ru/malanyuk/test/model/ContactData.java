package ru.malanyuk.test.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String company;
    private final String mobile;
    private final String email;
    private final String bithdayDay;
    private final String bithdayMounth;
    private final String bithdayYear;
    private int id;

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public ContactData(int id, String firstname, String lastname, String nickname, String company, String mobile, String email, String bithdayDay, String bithdayMounth, String bithdayYear) {
        this.id=id;
        this.firstname = firstname;

        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.mobile = mobile;
        this.email = email;
        this.bithdayDay = bithdayDay;
        this.bithdayMounth = bithdayMounth;
        this.bithdayYear = bithdayYear;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public ContactData(String firstname, String lastname, String nickname, String company, String mobile, String email, String bithdayDay, String bithdayMounth, String bithdayYear) {
        this.id=Integer.MAX_VALUE;
        this.firstname = firstname;

        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.mobile = mobile;
        this.email = email;
        this.bithdayDay = bithdayDay;
        this.bithdayMounth = bithdayMounth;
        this.bithdayYear = bithdayYear;

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

    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }
}
