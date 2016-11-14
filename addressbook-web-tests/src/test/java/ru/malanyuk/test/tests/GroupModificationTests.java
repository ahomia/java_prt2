package ru.malanyuk.test.tests;

import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

/**
 * Created by ahomia on 14.11.2016.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupDate("marina2", "malanyu2k", "m2"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupPage();
    }
}
