package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.malanyuk.test.model.ContactData;

/**
 * Created by ahomia on 12.11.2016.
 */
public class ContactHelper extends HelperBase{

private WebDriver wd;
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.className("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        selectDropdown(contactData.getBithdayDay());
        selectDropdown(contactData.getBithdayMounth());
        type(By.name("byear"), contactData.getBithdayYear());
    }



    public void initAddContact() {

        click(By.linkText("add new"));
    }

    public void sumbitContactCreating() {
        click(By.xpath("//*[@id='content']/*/input[@value='Enter']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void confirmDeletingContact() {
        closeAlert();
    }


    public void editContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void sumbitContactUpdating() {
        click(By.xpath("//*[@id='content']/*/input[@value='Update']"));
    }
}
