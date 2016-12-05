package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class NewContactCreating extends TestBase {

    @Test
    public void NewContactCreating() {

        Set<ContactData> before = app.contact().all();
        app.contact().initAddContact();
        ContactData contact=new ContactData().withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992");
        app.contact().create(contact);
       // app.goTo().HomePage();
        Set<ContactData> after = app.contact().all();

        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
       /* Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);*/
        contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(after,before);
    }


}
