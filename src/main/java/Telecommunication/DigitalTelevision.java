package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
/**
 * @author DS
 */
public class DigitalTelevision extends AbstractContract {
    private String[] digitalСhannels;

    public DigitalTelevision(LocalDate startOfTheContract, LocalDate theEndOfTheContract,
                             int contractNumber, Person owner, String[] digitalChannels) {
        super(startOfTheContract, theEndOfTheContract, contractNumber, owner);
        digitalСhannels = digitalChannels;
    }

    public String[] getDigitalСhannels() {
        return digitalСhannels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DigitalTelevision)) return false;
        DigitalTelevision that = (DigitalTelevision) o;
        return getContractNumber() == that.getContractNumber() && Objects.equals(getID(), that.getID()) && Objects.equals(getStartOfTheContract(), that.getStartOfTheContract()) && Objects.equals(getTheEndOfTheContract(), that.getTheEndOfTheContract()) && Objects.equals(getOwner(), that.getOwner()) && Objects.equals(getDigitalСhannels(), that.getDigitalСhannels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getStartOfTheContract(), getTheEndOfTheContract(), getContractNumber(), getOwner(), getDigitalСhannels());
    }

    @Override
    public String toString() {
        return "DigitalTelevision{" +
                "ID=" + getID() +
                ", StartOfTheContract=" + getStartOfTheContract() +
                ", TheEndOfTheContract=" + getTheEndOfTheContract() +
                ", ContractNumber=" + getContractNumber() +
                ", Owner=" + getOwner() +
                ", digitalСhannels=" + digitalСhannels +
                '}';
    }
}
