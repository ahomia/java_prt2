package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.List;

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
        List<GroupDate> before=app.group().list();
        int index=before.size()-1;
        app.group().delete(index);
        List<GroupDate> after=app.group().list();

        before.remove(index);
            Assert.assertEquals(before,after);



    }



}
