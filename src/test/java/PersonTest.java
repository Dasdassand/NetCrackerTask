import org.junit.Assert;
import Person.*;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author DS
 */
public class PersonTest {
    Person person = new Person("Savelev Denis Alexeevitch", (short) 1234567890,
            Sex.Male, LocalDate.of(2001, 10, 17));


    /**
     * getAge Method Test
     */
    @Test
    public void testGetAge() {
        Assert.assertEquals("TestAge failed", 20, person.getAge());
    }
}

