package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GropsCreating extends TestBase {

    @Test
    public void testGropsCreating() {

        app.getNavigationHelper().goToGroupPage();
        List<GroupDate> before=app.getGroupHelper().getGroupList();
        GroupDate group=new GroupDate("malanyuk", "mama","mama2");
        app.getGroupHelper().createGroup(new GroupDate("malanyuk", "mama","mama2"));
        List<GroupDate> after=app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()+1);
        //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(group);
        Comparator<? super GroupDate> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }

}
