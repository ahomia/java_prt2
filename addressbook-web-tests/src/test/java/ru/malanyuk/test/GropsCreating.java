package ru.malanyuk.test;

import org.testng.annotations.Test;

public class GropsCreating extends TestBase {

    @Test
    public void testGropsCreating() {

        goToGroupPage();
        initGroupCreating();
        fillGroupForm(new GroupDate("marina", "malanyuk", "m1"));
        submitGroupCreating();
        returnGroupPage();
    }

}
