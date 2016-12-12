package ru.malanyuk.test.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.malanyuk.test.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahomia on 07.12.2016.
 */
public class GroupDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    @Parameter(names = "-d", description = "format")
    public String format;


    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
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
        List<GroupDate> groups = generateGroups(count);
        if (format.equals("csv")) {
            saveAsCSV(groups, new File(file));
        } else if (format.equals("xml")) {
            saveAsXML(groups, new File(file));
        } else {
            System.out.println("Unrecognized format");
        }
    }

    private void saveAsXML(List<GroupDate> groups, File file) throws IOException {
        XStream xsrteam = new XStream();
        xsrteam.processAnnotations(GroupDate.class);
        String xml = xsrteam.toXML(groups);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);

        }
    }

    private void saveAsCSV(List<GroupDate> groups, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (GroupDate group : groups) {
                writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getFooter(), group.getFooter()));
            }
        }
    }

    private List<GroupDate> generateGroups(int count) {
        List<GroupDate> groups = new ArrayList<GroupDate>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupDate().withGroupName(String.format("test %s", i)).withHeader(String.format("header %s", i))
                    .withFooter(String.format("footer %s", i)));
        }
        return groups;
    }

}
