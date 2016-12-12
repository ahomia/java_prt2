package ru.malanyuk.test.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.malanyuk.test.model.ContactData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahomia on 09.12.2016.
 */
public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Contact count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    @Parameter(names = "-d", description = "format")
    public String format;


    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander JCommander = new JCommander(generator);
        try {
            JCommander.parse(args);

        } catch (ParameterException ex) {
            JCommander.usage();
            return;
        }

        generator.run();

    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCSV(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXML(contacts, new File(file));

        } else {
            System.out.println("Unrecognized format");
        }
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xsrteam = new XStream();
        xsrteam.processAnnotations(ContactData.class);
        String xml = xsrteam.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);

        }
    }

    private void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactData contact : contacts) {
                String f = contact.getPhoto().getAbsolutePath();
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                        contact.getFirstname(), contact.getLastname(), contact.getNickname(),
                        contact.getCompany(), contact.getHome(), contact.getMobile(), contact.getWork(),
                        contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getAddress(), contact.getBithdayDay(),
                        contact.getBithdayMounth(), contact.getBithdayYear(), contact.getPhoto().getPath()));

            }
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("Marina %s", i)).withLastname(String.format("Malaniuk %s", i))
                    .withNickname("Ahomia").withCompany("Artezio").withHome("123").withMobile("89873862557").withWork("321")
                    .withEmail("marina.malaniuk@gmail.com").withBithdayDay("3").withBithdayMounth("January").withBithdayYear("1992")
                    .withAddress("Saratov").withEmail2("marina.malaniuk2@gmail.com").withEmail3("marina.malaniuk3@gmail.com")
                    .withPhoto(new File("src/test/resources/Screenshot_26.png")));
        }
        return contacts;
    }
}
