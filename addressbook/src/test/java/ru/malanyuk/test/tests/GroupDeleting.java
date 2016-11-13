package ru.malanyuk.test.tests;

import org.testng.annotations.Test;

public class GroupDeleting extends TestBase{

    @Test
    public void GroupDeleting() {

        app.getGroupHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
    }


}
