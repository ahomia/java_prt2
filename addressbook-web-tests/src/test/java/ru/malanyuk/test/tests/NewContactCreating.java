package ru.malanyuk.test.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class NewContactCreating extends TestBase {

    @Test
    public void NewContactCreating() {

       Contacts before = app.contact().all();
        app.contact().initAddContact();
        ContactData contact=new ContactData().withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").
                withCompany("Artezio").withHome("123").withMobile("89873862557").withWork("321").withEmail("marina.malaniuk@gmail.com").
                withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992").withAddress("Saratov").
                withEmail2("marina.malaniuk2@gmail.com").withEmail3("marina.malaniuk3@gmail.com");
        app.contact().create(contact);
       // app.goTo().HomePage();
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
       /* Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);*/
      //  contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
       //before.add(contact);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
    }


}
