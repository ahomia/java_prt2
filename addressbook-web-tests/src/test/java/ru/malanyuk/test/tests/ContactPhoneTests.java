package ru.malanyuk.test.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ahomia on 05.12.2016.
 */
public class ContactPhoneTests extends TestBase {
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
    public void testContactsPhone() {


        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        // assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
        //assertThat(contact.getWork(), equalTo(cleaned(contactInfoFromEditForm.getWork())));

    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
                .stream().filter((s) -> !s.equals("")).
                        map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
