package ru.malanyuk.test.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.malanyuk.test.model.GroupDate;
import ru.malanyuk.test.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupDeleting extends TestBase {
    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().GroupPage();

        if (app.db().groups().size() == 0) {
            app.group().create(new GroupDate().withGroupName("malanyuk").withHeader("mama").withFooter("mama2"));
        }
    }

    @Test
    public void GroupDeleting() {
        Groups before = app.db().groups();
        GroupDate deletedGroup = before.iterator().next();
        app.goTo().GroupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.db().groups();
        //before.remove(deletedGroup);
        assertThat(after, equalTo(
                before.without(deletedGroup)));


    }


}
