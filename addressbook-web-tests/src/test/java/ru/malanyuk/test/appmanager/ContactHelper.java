package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.GroupDate;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by ahomia on 12.11.2016.
 */
public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData,boolean creating) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        selectDropdown(By.xpath("bday"),contactData.getBithdayDay());
        selectDropdown(By.name("bmonth"),contactData.getBithdayMounth());
        type(By.name("byear"), contactData.getBithdayYear());
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

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void confirmDeletingContact() {
        closeAlert();
    }


    public void editContact(int index) {

        wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
    }

    public void sumbitContactUpdating() {
        click(By.xpath("//*[@id='content']/*/input[@value='Update']"));
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
    public void goHomePage() {
        if(isElementPresent(By.id("maintable"))){

            return;
        }else{
            click(By.linkText("home"));
        }
    }

    public void createContact(ContactData contact) {
       initAddContact();
        fillContactForm(contact,false);
        sumbitContactCreating();
        goHomePage();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        //WebElement selected = wait.until(presenceOfElementLocated(By.name("entry")));
        List<ContactData> contact=new ArrayList<ContactData>();
        List<WebElement> elements=wd.findElements(By.xpath(".//*[@name='entry']"));;
        for (WebElement element: elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            ContactData person=new ContactData(id,firstname,lastname,null,null,null,null,null,null,null);
            contact.add(person);
        }
        return contact;
    }

}
