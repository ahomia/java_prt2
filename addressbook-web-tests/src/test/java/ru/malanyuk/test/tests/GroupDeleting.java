package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.List;
import java.util.Set;

public class GroupDeleting extends TestBase{
    @BeforeMethod
    public void ensurePreConditions(){
        app.goTo().GroupPage();

        if(app.contact().list().size()==0){
            app.group().create(new GroupDate().withGroupName("malanyuk").withHeader( "mama").withFooter("mama2"));
        }
    }

    @Test
    public void GroupDeleting() {
        Set<GroupDate> before=app.group().all();
        GroupDate deletedGroup=before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupDate> after=app.group().all();

        before.remove(deletedGroup);
            Assert.assertEquals(before,after);



    }



}
