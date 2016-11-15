package ru.malanyuk.test.tests;

import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;

public class GropsCreating extends TestBase {

    @Test
    public void testGropsCreating() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupDate("marina", "malanyuk", "mama"));

    }

}
