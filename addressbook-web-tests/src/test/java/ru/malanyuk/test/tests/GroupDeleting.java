package ru.malanyuk.test.tests;

import org.testng.annotations.Test;

public class GroupDeleting extends TestBase{

    @Test
    public void GroupDeleting() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
    }


}
