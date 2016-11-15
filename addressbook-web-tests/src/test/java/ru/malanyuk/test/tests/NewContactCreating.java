package ru.malanyuk.test.tests;

import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;

public class NewContactCreating extends TestBase{

    @Test
    public void NewContactCreating() {

        app.getContactHelper().initAddContact();
        app.getContactHelper().createContact(new ContactData("Marina", "Malaniuk", "Ahomia", "Artezio", "89873862557", "marina.malaniuk@gmail.com", "3", "January", "1992"));

    }


}
