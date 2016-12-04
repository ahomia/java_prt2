package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class NewContactCreating extends TestBase {

    @Test
    public void NewContactCreating() {

        List<ContactData> before = app.contact().list();
        app.contact().initAddContact();
        ContactData contact=new ContactData().withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992");
        app.contact().create(contact);
       // app.goTo().HomePage();
        List<ContactData> after = app.contact().list();

        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after,before);
    }


}
