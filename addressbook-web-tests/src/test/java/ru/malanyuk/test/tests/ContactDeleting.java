package ru.malanyuk.test.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by ahomia on 14.11.2016.
 */
public class ContactDeleting extends TestBase {
    @BeforeMethod
    public void ensurePreConditions(){
        if(app.contact().list().size()==0){
            app.contact().create(new ContactData().
                    withFirstname("Marina").withLastname("Malaniuk").withNickname( "Ahomia").
                    withCompany("Artezio").withMobile("89873862557").withEmail("marina.malaniuk@gmail.com").
                    withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992"));
        }
    }
    @Test

    public void testContactDeleting() {


        Contacts before = app.contact().all();
        ContactData deletedContact=before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()-1));
        //Assert.assertEquals(after.size(),before.size()-1);
       // before.remove(deletedContact);
        assertThat(after, equalTo(
                before.without(deletedContact)));



    }


}
