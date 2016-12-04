package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class NewContactCreating extends TestBase {

    @Test
    public void NewContactCreating() {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initAddContact();
        ContactData contact=new ContactData("Marina", "Malaniuk", "Ahomia", "Artezio", "89873862557", "marina.malaniuk@gmail.com", "3", "January", "1992");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after,before);
    }


}
