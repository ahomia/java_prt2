package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before=app.contact().list();
        int index=before.size()-1;
        //ContactData contact=new ContactData().withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992");

        ContactData contact=new ContactData().withId(before.get(index).getId()).withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992");
        app.contact().modify(index, contact);
        List<ContactData> after=app.contact().list();
before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after,before);
    }


}
