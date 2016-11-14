package ru.malanyuk.test.tests;

import org.testng.annotations.Test;

/**
 * Created by ahomia on 14.11.2016.
 */
public class ContactDeleting extends TestBase {
    @Test

    public void testContactDeleting(){
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().confirmDeletingContact();

    }
}
