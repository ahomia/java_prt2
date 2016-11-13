package ru.malanyuk.test.tests;

import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

public class GropsCreating extends TestBase {

    @Test
    public void testGropsCreating() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreating();
        app.getGroupHelper().fillGroupForm(new GroupDate("marina", "malanyuk", "m1"));
        app.getGroupHelper().submitGroupCreating();
        app.getGroupHelper().returnGroupPage();
    }

}
