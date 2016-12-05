package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GropsCreating extends TestBase {

    @Test
    public void testGropsCreating() {

        app.goTo().GroupPage();
        Set<GroupDate> before=app.group().all();
        GroupDate group=new GroupDate().withGroupName("malanyuk").withHeader( "mama").withFooter("mama2");
        app.group().create(group);
        Set<GroupDate> after=app.group().all();
        Assert.assertEquals(after.size(),before.size()+1);

       /* Comparator<? super GroupDate> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);*/
       group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before,after);

    }

}
