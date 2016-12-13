package ru.malanyuk.test.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;

@XStreamAlias("contact")
@Entity
@javax.persistence.Table(name ="addressbook")
public class ContactData {

    @XStreamOmitField()
    @Id
    @Column(name="id")
    private int id = Integer.MAX_VALUE;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="nickname")
    private String nickname;
    @Column(name="company")
    private String company;
    @Column(name="home")
    @Type(type = "text")
    private String home;
    @Column(name="mobile")
    @Type(type = "text")
    private String mobile;
    @Column(name="work")
    @Type(type = "text")
    private String work;
    @Column(name="email")
    private String email;
    @Column(name="email2")
    private String email2;
    @Column(name="email3")
    private String email3;
    @Column(name="bday")
    @Type(type = "tinyint")
    private byte bithdayDay;
    @Column(name="bmounth")
    private String bithdayMounth;
    @Column(name="byear")
    private String bithdayYear;
    @Column(name="address")
    @Type(type = "text")
    private String address;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;
    @Column(name="photo")
    @Type(type = "text")
    private String photo;

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }


    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }


    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactData withAddress(String address) {
        this.address = address;
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

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWork(String work) {
        this.work = work;
        return this;
    }

    public String getHome() {
        return home;
    }

    public String getWork() {
        return work;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withBithdayDay(String bithdayDay) {
        this.bithdayDay = Byte.valueOf(bithdayDay);
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

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getBithdayDay() {
        return Byte.toString(bithdayDay);
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

    public String getAllPhones() {
        return allPhones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllEmails() {
        return allEmails;
    }

}
