package Person;


import Container.ContainerArray;
import Sorting.BubbleSort;
import Telecommunication.AbstractContract;
import Telecommunication.MobileConnection;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * @author DS
 */
public class Person {
    private final UUID id = UUID.randomUUID();
    private final String fullName;
    private final LocalDate dateOfBirth;
    private final short passportSeriesAndNumber;
    private final Sex sex;

    /**
     * @param fullName                Full Name
     * @param passportSeriesAndNumber Passport Series And Number
     * @param sex                     Sex
     * @param dateOfBirth             Date Of Birth
     */
    public Person(String fullName, short passportSeriesAndNumber, Sex sex, LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.passportSeriesAndNumber = passportSeriesAndNumber;
        this.sex = sex;
    }

    /**
     * @return Age of the person
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public UUID getID() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public short getPassportSeriesAndNumber() {
        return passportSeriesAndNumber;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getPassportSeriesAndNumber() == person.getPassportSeriesAndNumber() && Objects.equals(id, person.id) && Objects.equals(getFullName(), person.getFullName()) && Objects.equals(getDateOfBirth(), person.getDateOfBirth()) && getSex() == person.getSex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getFullName(), getDateOfBirth(), getPassportSeriesAndNumber(), getSex());
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportSeriesAndNumber=" + passportSeriesAndNumber +
                ", sex=" + sex +
                ", Age=" + getAge() +
                '}';
    }

    public static void main(String[] args) {
        ContainerArray containerArray = new ContainerArray();
        containerArray.add(new MobileConnection(LocalDate.of(2000, 10, 16),
                LocalDate.of(2001, 10, 16), 123456780, new Person("VDV",
                (short) 56789, Sex.Male, LocalDate.of(2001, 10, 17)),
                1, 2, 3));
        containerArray.add(new MobileConnection(LocalDate.of(2000, 10, 16),
                LocalDate.of(2001, 10, 16), 123456780, new Person("SDV",
                (short) 12345, Sex.Male, LocalDate.of(2001, 10, 17)),
                1, 2, 3));
        containerArray.add(new MobileConnection(LocalDate.of(2000, 10, 16),
                LocalDate.of(2001, 10, 16), 123456780, new Person("VDV",
                (short) 567897, Sex.Male, LocalDate.of(2001, 10, 17)),
                1, 2, 3));
        BubbleSort bubbleSort = new BubbleSort();
        Comparator<AbstractContract> comparator = Comparator.comparing(contract -> contract.getOwner().getFullName());
        bubbleSort.sort(comparator,containerArray);
        Predicate<AbstractContract> pr1 = abstractContract -> abstractContract.getOwner().getPassportSeriesAndNumber() == (short) 567897;
        Predicate<AbstractContract> pr2 = abstractContract -> abstractContract.getOwner().getFullName().equals("VDV");
        System.out.println(containerArray.searchContract(pr1.and(pr2)).toString());
    }
}
