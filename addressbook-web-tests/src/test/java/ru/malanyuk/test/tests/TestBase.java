package ru.malanyuk.test.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.malanyuk.test.appmanager.ApplicationManager;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;
import ru.malanyuk.test.model.GroupDate;
import ru.malanyuk.test.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ahomia on 11.11.2016.
 */
public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public void vetifyGroupListInUI() {
        if (Boolean.getBoolean("isVerifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupDate().withId(g.getId()).withGroupName(g.getGroupName()))
                    .collect(Collectors.toSet())));
        }


    }

    public void vetifyContactListInUI() {
        if (Boolean.getBoolean("isVerifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uiContacts = app.contact().all();
            assertThat(uiContacts, equalTo(dbContacts.stream().map((g) -> new ContactData().withId(g.getId())
                    .withFirstname(g.getFirstname()).withLastname(g.getLastname()).withAddress(g.getAddress())
                    .withAllEmails(ContactEmailTests.mergeEmails(g)).withAllPhones(ContactPhoneTests.mergePhones(g)))
                    .collect(Collectors.toSet())));
        }

    }


}
