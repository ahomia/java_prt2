package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Set<GroupDate> before=app.group().all();
        GroupDate modifyGroup=before.iterator().next();
        GroupDate group=new GroupDate().withId(modifyGroup.getId()).withGroupName("malanyuk").withHeader( "mama").withFooter("mama2");
        app.group().modify(group);
        Set<GroupDate> after=app.group().all();
        Assert.assertEquals(after.size(),before.size());
        before.remove(modifyGroup);
        before.add(group);
       /* Comparator<? super GroupDate> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);*/
        Assert.assertEquals(after,before);
    }


}
