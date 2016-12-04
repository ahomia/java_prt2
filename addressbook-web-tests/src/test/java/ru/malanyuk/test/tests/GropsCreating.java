package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.Comparator;
import java.util.List;

public class GropsCreating extends TestBase {

    @Test
    public void testGropsCreating() {

        app.goTo().GroupPage();
        List<GroupDate> before=app.group().list();
        GroupDate group=new GroupDate().withGroupName("malanyuk").withHeader( "mama").withFooter("mama2");
        app.group().create(group);
        List<GroupDate> after=app.group().list();
        Assert.assertEquals(after.size(),before.size()+1);
        before.add(group);
        Comparator<? super GroupDate> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }

}
