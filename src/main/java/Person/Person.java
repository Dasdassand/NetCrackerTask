package Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;

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
     * @param fullName  Full Name
     * @param passportSeriesAndNumber  Passport Series And Number
     * @param sex  Sex
     * @param dateOfBirth  Date Of Birth
     */
    public Person(String fullName, short passportSeriesAndNumber, Sex sex, LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.passportSeriesAndNumber = passportSeriesAndNumber;
        this.sex = sex;
    }

    /**
     *
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

    }
}
