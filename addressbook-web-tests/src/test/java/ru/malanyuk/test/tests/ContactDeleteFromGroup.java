package ru.malanyuk.test.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;
import ru.malanyuk.test.model.GroupDate;
import ru.malanyuk.test.model.Groups;

import java.io.File;

/**
 * Created by ahomia on 24.12.2016.
 */
public class ContactDeleteFromGroup extends TestBase {
    @BeforeMethod
    public void ensurePreConditions() {
        Boolean addContactInGroup = false;
        if (app.db().contacts().size() == 0){
            app.goTo().HomePage();
            app.contact().create(new ContactData().
                    withFirstname("Marina").withLastname("Malaniuk").withNickname("Ahomia").
                    withCompany("Artezio").withHome("123").withMobile("89873862557").withWork("321").withEmail("marina.malaniuk@gmail.com").
                    withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992").withAddress("Saratov 410012").
                    withEmail2("marina.malaniuk2@gmail.com").withEmail3("marina.malaniuk3@gmail.com")
                    .withPhoto(new File("src/test/resources/Screenshot_26.png")));
            if (app.db().groups().size() != 0){
                addContactInGroup = true;
            }else {
                app.goTo().GroupPage();
                app.group().create(new GroupDate().withGroupName("mama"));
                addContactInGroup = true;
            }
        }
        if (app.db().groups().size() == 0){
            app.goTo().GroupPage();
            app.group().create(new GroupDate().withGroupName("mama"));
            if (app.db().contacts().size() != 0){
                addContactInGroup = true;
            } else {
                app.goTo().HomePage();
                app.contact().create(new ContactData().
                        withFirstname("Marina").withLastname("Malaniuk").withNickname("Ahomia").
                        withCompany("Artezio").withHome("123").withMobile("89873862557").withWork("321").withEmail("marina.malaniuk@gmail.com").
                        withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992").withAddress("Saratov 410012").
                        withEmail2("marina.malaniuk2@gmail.com").withEmail3("marina.malaniuk3@gmail.com")
                        .withPhoto(new File("src/test/resources/Screenshot_26.png")));
                addContactInGroup = true;
            }
        }
        if (addContactInGroup == true){
            ContactData contact = app.db().contacts().iterator().next();
            GroupDate group = app.db().groups().iterator().next();
            app.contact().addContactInGroup(contact,group);

        }


        }

    @Test
    public void testDeleteContactOffGroup () {
        app.goTo().HomePage();
        Contacts contacts = app.db().contacts();
        Boolean isDeleted = false;
        ContactData selectedContact=null;
        int before = 0;
        for (ContactData contact: contacts) {
            if (isDeleted == false) {
                if (contact.getGroups().size() != 0) {
                    before = contact.getGroups().size();
                    GroupDate group = contact.getGroups().iterator().next();
                    app.contact().deleteContactOffGroup(contact, group);
                    isDeleted = true;
                    selectedContact = contact;
                }
            }
        }

        Assert.assertEquals(selectedContact.getGroups().size(), before - 1);
    }
}
