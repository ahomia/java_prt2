package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ahomia on 14.11.2016.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();

        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("malanyuk", "mama","mama2"));
        }
        List<GroupDate> before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupDate group=new GroupDate(before.get(before.size()-1).getId(),"malanyu2k", "m2","mm");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupPage();
        List<GroupDate> after=app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(before.size()-1);
        before.add(group);
        Comparator<? super GroupDate> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after,before);
    }
}
