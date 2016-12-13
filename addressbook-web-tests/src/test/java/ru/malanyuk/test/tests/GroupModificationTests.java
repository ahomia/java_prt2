package ru.malanyuk.test.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;
import ru.malanyuk.test.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by ahomia on 14.11.2016.
 */
public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreConditions() {


        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupDate().withGroupName("malanyuk").withHeader("mama").withFooter("mama2"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupDate modifyGroup = before.iterator().next();
        GroupDate group = new GroupDate().withId(modifyGroup.getId()).withGroupName("malanyuk").withHeader("mama").withFooter("mama2");
        app.goTo().GroupPage();
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        //before.remove(modifyGroup);
        //before.add(group);
       /* Comparator<? super GroupDate> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);*/
        assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));

    }


}
