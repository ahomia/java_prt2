package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ahomia on 14.11.2016.
 */
public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreConditions(){
        app.goTo().GroupPage();

        if(app.contact().list().size()==0){
            app.group().create(new GroupDate().withGroupName("malanyuk").withHeader( "mama").withFooter("mama2"));
        }
    }
    @Test
    public void testGroupModification() {
        List<GroupDate> before=app.group().list();
        int index=before.size()-1;
        GroupDate group=new GroupDate().withId(before.get(index).getId()).withGroupName("malanyuk").withHeader( "mama").withFooter("mama2");
        app.group().modify(index, group);
        List<GroupDate> after=app.group().list();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        before.add(group);
        Comparator<? super GroupDate> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after,before);
    }


}
