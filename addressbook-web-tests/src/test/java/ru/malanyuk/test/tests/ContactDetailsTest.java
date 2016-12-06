package ru.malanyuk.test.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ahomia on 06.12.2016.
 */
public class ContactDetailsTest extends TestBase {
    @BeforeMethod
    public void ensurePreConditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Marina").withLastname("Malaniuk").withNickname("Ahomia").
                            withCompany("Artezio").withHome("123").withMobile("89873862557").withWork("321").withEmail("marina.malaniuk@gmail.com").
                            withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992").withAddress("Saratov 410012").
                            withEmail2("marina.malaniuk2@gmail.com").withEmail3("marina.malaniuk3@gmail.com"));
        }
    }

    @Test
    public void testDetailsTest() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailsForm = app.contact().infoDetails(contact);
        ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
        assertThat(mergeDetails(contactInfoFromEditForm), equalTo(mergeDetails(contactInfoFromDetailsForm)));
        //assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
        // assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));
    }

    private String mergeDetails(ContactData contact) {
        return Arrays.asList(contact.getFirstname(),contact.getLastname()
                ,contact.getNickname(),contact.getCompany(),contact.getAddress(),contact.getHome()
                ,contact.getMobile(),contact.getWork(),contact.getEmail(),contact.getEmail2(),contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

}
