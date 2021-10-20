package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author DS
 */
public class MobileConnection extends AbstractContract {


    private final int numberOfMinutes;
    private final int numberOfSMS;
    private final int numberOfGBOfTraffic;

    public MobileConnection(LocalDate startOfTheContract, LocalDate theEndOfTheContract, int contractNumber, Person owner,
                            int numberOfMinutes, int numberOfSMS, int numberOfGBOfTraffic) {
        super(startOfTheContract, theEndOfTheContract, contractNumber, owner);
        this.numberOfMinutes = numberOfMinutes;
        this.numberOfSMS = numberOfSMS;
        this.numberOfGBOfTraffic = numberOfGBOfTraffic;
    }

    public int getNumberOfMinutes() {
        return numberOfMinutes;
    }

    public int getNumberOfSMS() {
        return numberOfSMS;
    }

    public int getNumberOfGBOfTraffic() {
        return numberOfGBOfTraffic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobileConnection)) return false;
        MobileConnection that = (MobileConnection) o;
        return getContractNumber() == that.getContractNumber() && getNumberOfMinutes() == that.getNumberOfMinutes() && getNumberOfSMS() == that.getNumberOfSMS() && getNumberOfGBOfTraffic() == that.getNumberOfGBOfTraffic() && Objects.equals(getID(), that.getID()) && Objects.equals(getStartOfTheContract(), that.getStartOfTheContract()) && Objects.equals(getTheEndOfTheContract(), that.getTheEndOfTheContract()) && Objects.equals(getOwner(), that.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getStartOfTheContract(), getTheEndOfTheContract(), getContractNumber(), getOwner(), getNumberOfMinutes(), getNumberOfSMS(), getNumberOfGBOfTraffic());
    }

    @Override
    public String toString() {
        return "MobileConnection{" +
                "ID=" + getID() +
                ", StartOfTheContract=" + getStartOfTheContract() +
                ", TheEndOfTheContract=" + getTheEndOfTheContract() +
                ", ContractNumber=" + getContractNumber() +
                ", Owner=" + getOwner() +
                ", NumberOfMinutes=" + numberOfMinutes +
                ", NumberOfSMS=" + numberOfSMS +
                ", NumberOfGBOfTraffic=" + numberOfGBOfTraffic +
                '}';
    }
}
