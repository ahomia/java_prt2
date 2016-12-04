package ru.malanyuk.test.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

import java.util.List;

public class GroupDeleting extends TestBase{

    @Test
    public void GroupDeleting() {


        app.getNavigationHelper().goToGroupPage();

        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("malanyuk", "mama","mam2"));
        }
        List<GroupDate> before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
        List<GroupDate> after=app.getGroupHelper().getGroupList();

        before.remove(before.size()-1);
            Assert.assertEquals(before,after);



    }


}
