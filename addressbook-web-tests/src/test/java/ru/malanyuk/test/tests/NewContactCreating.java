package ru.malanyuk.test.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;
import ru.malanyuk.test.model.Contacts;
import ru.malanyuk.test.model.GroupDate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class NewContactCreating extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list=new ArrayList<Object[]>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line=reader.readLine();
        while (line!=null){
            String[] split=line.split(";");
            list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1]).withNickname(split[2]).
                    withCompany(split[3]).withHome(split[4]).withMobile(split[5]).withWork(split[6]).withEmail(split[7]).
                    withBithdayDay(split[8]).withBithdayMounth(split[9]).withBithdayYear(split[10]).withAddress(split[11]).
                    withEmail2(split[12]).withEmail3(split[13]).withPhoto(new File(split[14]))});
            line=reader.readLine();
        }
        //list.add();
        return list.iterator();

    }
    @Test(dataProvider = "validContacts")
    public void NewContactCreating(ContactData contact) {
        Contacts before = app.contact().all();
        app.contact().initAddContact();
        app.contact().create(contact);
        // app.goTo().HomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
       /* Comparator<? super ContactData> byId=(c1, c2)->Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);*/
        //  contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
        //before.add(contact);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}
