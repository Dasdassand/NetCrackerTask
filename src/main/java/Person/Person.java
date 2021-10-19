package Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;

public class Person {
    private final UUID ID = UUID.randomUUID();
    private final String FullName;
    private final LocalDate DateOfBirth;
    private final short PassportSeriesAndNumber;
    private final Sex sex;
    private int Age;

    public Person(String fullName, short passportSeriesAndNumber, Sex sex, LocalDate dateOfBirth) {
        FullName = fullName;
        DateOfBirth = dateOfBirth;
        PassportSeriesAndNumber = passportSeriesAndNumber;
        this.sex = sex;
        CalculateAge();
    }

    public UUID getID() {
        return ID;
    }

    public String getFullName() {
        return FullName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public short getPassportSeriesAndNumber() {
        return PassportSeriesAndNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return Age;
    }

    public void CalculateAge() {
        this.Age = Period.between(DateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person user = (Person) o;
        return PassportSeriesAndNumber == user.PassportSeriesAndNumber &&
                Age == user.Age && ID.equals(user.ID) && FullName.equals(user.FullName) &&
                DateOfBirth.equals(user.DateOfBirth) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, FullName, DateOfBirth, PassportSeriesAndNumber, sex, Age);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", FullName='" + FullName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", PassportSeriesAndNumber=" + PassportSeriesAndNumber +
                ", sex=" + sex +
                ", Age=" + Age +
                '}';
    }

    public static void main(String[] args) {

    }
}
