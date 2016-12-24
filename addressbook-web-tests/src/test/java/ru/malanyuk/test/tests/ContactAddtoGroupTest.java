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
 * Created by ahomia on 18.12.2016.
 */
public class ContactAddtoGroupTest extends TestBase {
    @BeforeMethod
    public void ensurePreConditions() {
        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            app.contact().create(new ContactData().
                    withFirstname("Marina").withLastname("Malaniuk").withNickname("Ahomia").
                    withCompany("Artezio").withHome("123").withMobile("89873862557").withWork("321").withEmail("marina.malaniuk@gmail.com").
                    withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992").withAddress("Saratov 410012").
                    withEmail2("marina.malaniuk2@gmail.com").withEmail3("marina.malaniuk3@gmail.com")
                    .withPhoto(new File("src/test/resources/Screenshot_26.png")));

            if (app.db().groups().size() == 0) {
                app.goTo().GroupPage();
                app.group().create(new GroupDate().withGroupName("malanyuk").withHeader("mama").withFooter("mama2"));
            }
        }
    }

    @Test
    public void addContactToGroupTest() {
        app.goTo().HomePage();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        Boolean contactInGroup = false;
        ContactData selectedContact;
        GroupDate selectedGroup;
        int before=0;
        int after=0;
        for (ContactData contact : contacts) {
            if (contactInGroup == false) {
                for (GroupDate group : groups) {
                    if (contactInGroup == false) {
                        Groups contactInGroups = contact.getGroups();
                        if (contactInGroups.size() != 0) {
                            for (GroupDate groupContact : contactInGroups) {
                                if (group != groupContact) {

                                    selectedContact = contact;
                                    selectedGroup=group;
                                    before= selectedContact.getGroups().size();
                                    app.contact().addContactInGroup(selectedContact,selectedGroup);
                                    contactInGroup = true;
                                    after=selectedContact.getGroups().size();


                                }
                            }
                        } else {
                            selectedContact = contact;
                            selectedGroup=group;
                            before= selectedContact.getGroups().size();
                            app.contact().addContactInGroup(selectedContact,selectedGroup);
                            contactInGroup = true;
                            after=selectedContact.getGroups().size();

                        }
                    }
                }
            }
        }
        Assert.assertEquals(before, after + 1);

    }

}
