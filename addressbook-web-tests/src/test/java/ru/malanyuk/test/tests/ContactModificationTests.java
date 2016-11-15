package ru.malanyuk.test.tests;

import org.testng.annotations.Test;
import ru.malanyuk.test.model.ContactData;

/**
 * Created by ahomia on 14.11.2016.
 */
public class ContactModificationTests extends TestBase {
    @Test

    public void testContactModification() {
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Marina", "Malaniuk", "Ahomia", "Artezio", "89873862557", "marina.malaniuk@gmail.com", "3", "January", "1992"));
        }
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Marina", "Malaniuk2", "Ahomia", "Artezio2", "89873862557", "marina.malaniuk@gmail.com", "3", "January", "1992"),false);
        app.getContactHelper().sumbitContactUpdating();

    }
}
