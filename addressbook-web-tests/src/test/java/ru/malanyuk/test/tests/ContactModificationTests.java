package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ahomia on 14.11.2016.
 */
public class ContactModificationTests extends TestBase {
    @Test

    public void testContactModification() {

        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Marina", "Malaniuk", "Ahomia", "Artezio", "89873862557", "marina.malaniuk@gmail.com", "3", "January", "1992"));
        }
        List<ContactData> before=app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size()-1);
        ContactData contact=new ContactData(before.get(before.size()-1).getId(),"Marina", "Malaniuk2", "Ahomia", "Artezio2", "89873862557", "marina.malaniuk@gmail.com", "3", "January", "1992");
        app.getContactHelper().fillContactForm(contact,false);
        app.getContactHelper().sumbitContactUpdating();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after=app.getContactHelper().getContactList();
before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after,before);
    }
}
