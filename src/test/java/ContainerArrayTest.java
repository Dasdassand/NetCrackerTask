import Container.ContainerArray;
import Person.*;
import Telecommunication.DigitalTelevision;
import Telecommunication.MobileConnection;
import Telecommunication.WiredInternet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.util.UUID;

/**
 * @author DS
 */
public class ContainerArrayTest {
    ContainerArray containerArray = new ContainerArray();

    /**
     * Add Method
     */
    @Before
    public void addElements() {
        for (int i = 0; i < 16; i++) {
            containerArray.add(new MobileConnection(LocalDate.of(2000, 10, 16),
                    LocalDate.of(2001, 10, 16), 123456780, new Person("SDV",
                    (short) 12345, Sex.Male, LocalDate.of(2001, 10, 17)),
                    1, 2, 3));
        }
        Assert.assertEquals("Add failed", 16, containerArray.size());
    }

    /**
     * Testing removal methods
     */
    @Test
    public void testRemove() {
        UUID tmpID = containerArray.getByIndex(containerArray.size() - 1).getID();
        containerArray.remove(containerArray.size() - 1);
        Assert.assertNull("TestRemove failed", containerArray.getByID(tmpID));
        tmpID = containerArray.getIndex(containerArray.size() - 1).getID();
        containerArray.removeByID(tmpID);
        Assert.assertNull("TestRemoveByID failed", containerArray.getByID(tmpID));

    }

    /**
     * Testing methods for determining the size of an array
     */
    @Test
    public void testSize() {
        Assert.assertEquals("TestSizeCreate failed", 16, containerArray.size());
        containerArray.add(new MobileConnection(LocalDate.of(2000, 10, 16),
                LocalDate.of(2001, 10, 16), 123456780, new Person("SDV",
                (short) 12345, Sex.Male, LocalDate.of(2001, 10, 17)),
                1, 2, 3));
        Assert.assertEquals("TestSizeAdd failed", 17, containerArray.size());
        for (int i = 0; i < 8; i++) {
            containerArray.remove(i);
        }
        Assert.assertEquals("TestSizeRemove failed", 9, containerArray.size());
    }


    /**
     * Test for correct addition
     */
    @Test
    public void TestAdd() {
        containerArray.clear();
        containerArray.add(new MobileConnection(LocalDate.of(2000, 10, 16),
                LocalDate.of(2001, 10, 16), 123456780, new Person("SDV",
                (short) 12345, Sex.Male, LocalDate.of(2001, 10, 17)),
                1, 2, 3));
        containerArray.add(new DigitalTelevision(LocalDate.of(2000, 10, 16),
                LocalDate.of(2001, 10, 16), 123456780, new Person("SDV",
                (short) 12345, Sex.Male, LocalDate.of(2001, 10, 17)), new String[]{"TV-1", "TV-2", "TV-3"}));
        containerArray.add(new WiredInternet(LocalDate.of(2000, 10, 16),
                LocalDate.of(2001, 10, 16), 123456780, new Person("SDV",
                (short) 12345, Sex.Male, LocalDate.of(2001, 10, 17)), 100));
        Assert.assertTrue("", containerArray.getByIndex(0) instanceof MobileConnection);
        Assert.assertTrue("", containerArray.getByIndex(1) instanceof DigitalTelevision);
        Assert.assertTrue("", containerArray.getByIndex(2) instanceof WiredInternet);
    }
}
