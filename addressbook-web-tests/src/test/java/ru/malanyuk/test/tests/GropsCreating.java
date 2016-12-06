package ru.malanyuk.test.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;
import ru.malanyuk.test.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GropsCreating extends TestBase {

    @Test
    public void testGropsCreating() {

        app.goTo().GroupPage();
        Groups before=app.group().all();
        GroupDate group=new GroupDate().withGroupName("malanyuk").withHeader( "mama").withFooter("mama2");
        app.group().create(group);
        assertThat(app.group().count(),equalTo(before.size()+1));
        Groups after=app.group().all();
       /* Comparator<? super GroupDate> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);*/
       group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
       // before.add(group);
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

    }

}
