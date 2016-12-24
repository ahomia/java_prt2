package ru.malanyuk.test.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;
import ru.malanyuk.test.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class NewContactCreating extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String line = reader.readLine();
            String xml = "";
            while (line != null) {
                xml += line;
                String[] split = line.split(";");
                ///list.add(new Object[]{new GroupDate().withGroupName(split[0]).withHeader(split[1]).withFooter(split[2])});
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> groups = (List<ContactData>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validContacts")
    public void NewContactCreating(ContactData contact) {

        app.goTo().HomePage();
        Contacts before = app.db().contacts();
        app.contact().initAddContact();
        app.contact().create(contact);
        // app.goTo().HomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
       /* Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);*/
        //  contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
        //before.add(contact);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        vetifyContactListInUI();
    }

}
