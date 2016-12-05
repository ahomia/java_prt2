package ru.malanyuk.test.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by ahomia on 14.11.2016.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreConditions(){
        if(app.contact().list().size()==0){
            app.contact().create(new ContactData().withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992"));
        }
    }
    @Test

    public void testContactModification() {
        Contacts before=app.contact().all();
        ContactData modifyContact=before.iterator().next();
        //ContactData contact=new ContactData().withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992");

        ContactData contact=new ContactData().withId(modifyContact.getId()).withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992");
        app.contact().modify(contact);
        Contacts after=app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
       // before.remove(modifyContact);
        //before.add(contact);
       /* Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);*/
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));

    }


}
