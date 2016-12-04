package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.GroupDate;

import java.util.List;

/**
 * Created by ahomia on 14.11.2016.
 */
public class ContactDeleting extends TestBase {
    @Test

    public void testContactDeleting() {

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Marina", "Malaniuk", "Ahomia", "Artezio", "89873862557", "marina.malaniuk@gmail.com", "3", "January", "1992"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().confirmDeletingContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        //Assert.assertEquals(after.size(),before.size()-1);
        before.remove(before.size() - 1);
        Assert.assertEquals(after, before);


    }
}
