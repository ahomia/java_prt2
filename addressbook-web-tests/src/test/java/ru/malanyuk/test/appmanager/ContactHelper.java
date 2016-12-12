package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.support.ui.Select;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;
import ru.malanyuk.test.model.GroupDate;
import ru.malanyuk.test.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by ahomia on 12.11.2016.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creating) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("address"), contactData.getAddress());
        attach(By.name("photo"), contactData.getPhoto());
        selectDropdown(By.xpath("bday"), contactData.getBithdayDay());
        selectDropdown(By.name("bmonth"), contactData.getBithdayMounth());
        type(By.name("byear"), contactData.getBithdayYear());
    }


    public void gotoHomePage() {

        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void initAddContact() {

        click(By.linkText("add new"));
    }

    public void sumbitContactCreating() {
        click(By.xpath("//*[@id='content']/*/input[@value='Enter']"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void confirmDeletingContact() {
        closeAlert();
    }


    public void editContact(int index) {

        wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
    }

    public void editContactById(int id) {

        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void sumbitContactUpdating() {
        click(By.xpath("//*[@id='content']/*/input[@value='Update']"));
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        initAddContact();
        fillContactForm(contact, false);
        sumbitContactCreating();
        contactCashe = null;
        gotoHomePage();
    }

    public void modify(int index, ContactData contact) {
        editContact(index);
        fillContactForm(contact, false);
        sumbitContactUpdating();
        gotoHomePage();
    }

    public void modify(ContactData contact) {
        editContactById(contact.getId());
        fillContactForm(contact, false);
        sumbitContactUpdating();
        contactCashe = null;
        gotoHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        confirmDeletingContact();
        gotoHomePage();
        ;
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        confirmDeletingContact();
        contactCashe = null;
        gotoHomePage();
    }

    public int count() {

        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        //WebElement selected = wait.until(presenceOfElementLocated(By.name("entry")));
        List<ContactData> contact = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
        ;
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            contact.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contact;
    }

    private Contacts contactCashe = null;

    public Contacts all() {
        if (contactCashe != null) {
            return new Contacts(contactCashe);
        }
        //WebElement selected = wait.until(presenceOfElementLocated(By.name("entry")));
        contactCashe = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
        for (WebElement element : elements) {
            List<WebElement> cells = wd.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String adress = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contactCashe.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).
                    withAllPhones(allPhones).withAddress(adress).withAllEmails(allEmails));
        }
        return new Contacts(contactCashe);
    }


    public ContactData infoFormEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String company = wd.findElement(By.name("company")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
                withHome(home).withMobile(mobile).withWork(work).withEmail(email).withEmail2(email2)
                .withEmail3(email3).withAddress(address).withNickname(nickname).withCompany(company);

    }

    public ContactData infoDetails(ContactData contact) {
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", contact.getId()))).click();
        String[] info = wd.findElement(By.id("content")).getText()
                .replaceAll("\\n+\\s*", "\n").replaceFirst(" ", "\n").split("\n");
        info[5]=info[5].replaceAll("\\s","").replaceAll("\n","").replaceAll("[:]","").replaceAll("[HMW]","");
        info[6]=info[6].replaceAll("\\s","").replaceAll("\n","").replaceAll("[:]","").replaceAll("[HMW]","");
        info[7]=info[7].replaceAll("\\s","").replaceAll("\n","").replaceAll("[:]","").replaceAll("[HMW]","");
        String email = wd.findElement(By.xpath("//div/div[4]/a[1]")).getText();
        String email2 = wd.findElement(By.xpath("//div/div[4]/a[2]")).getText();
        String email3 = wd.findElement(By.xpath("//div/div[4]/a[3]")).getText();
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(info[0]).withLastname(info[1])
                .withNickname(info[2]).withCompany(info[3]).withAddress(info[4]).withHome(info[5])
                .withMobile(info[6]).withWork(info[7]).withEmail(email).withEmail2(email2).withEmail3(email3);
    }
}
