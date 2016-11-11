package ru.malanyuk.test;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String company;
    private final String mobile;
    private final String email;
    private final int bithdayDay;
    private final int bithdayMounth;
    private final String bithdayYear;

    public ContactData(String firstname, String lastname, String nickname, String company, String mobile, String email, int bithdayDay, int bithdayMounth, String bithdayYear) {
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

    public int getBithdayDay() {
        return bithdayDay;
    }

    public int getBithdayMounth() {
        return bithdayMounth;
    }

    public String getBithdayYear() {
        return bithdayYear;
    }
}
