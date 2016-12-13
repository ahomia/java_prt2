package ru.malanyuk.test.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;
import ru.malanyuk.test.model.Groups;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GropsCreating extends TestBase {
Logger logger= LoggerFactory.getLogger(GropsCreating.class);
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
            String line = reader.readLine();
            String xml = "";
            while (line != null) {
                xml += line;
                String[] split = line.split(";");
                ///list.add(new Object[]{new GroupDate().withGroupName(split[0]).withHeader(split[1]).withFooter(split[2])});
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(GroupDate.class);
            List<GroupDate> groups = (List<GroupDate>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
            // list.add(new Object[]{new GroupDate().withGroupName("malanyuk").withHeader("mama").withFooter("mama2")});
            //return list.iterator();

        }

    }

    @Test(dataProvider = "validGroups")
    public void testGropsCreating(GroupDate group) {
        logger.info("start GroupCreating test");
        app.goTo().GroupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
       /* Comparator<? super GroupDate> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);*/
        //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        // before.add(group);
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        logger.info("stop GroupCreating test");


    }

}
