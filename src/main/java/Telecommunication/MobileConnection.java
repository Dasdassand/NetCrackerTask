package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class MobileConnection extends AbstractContract{


    private final int NumberOfMinutes;
    private final int NumberOfSMS;
    private final int NumberOfGBOfTraffic;

    public MobileConnection(LocalDate startOfTheContract, LocalDate theEndOfTheContract, int contractNumber, Person owner,
                            int numberOfMinutes, int numberOfSMS, int numberOfGBOfTraffic) {
        super(startOfTheContract, theEndOfTheContract, contractNumber, owner);
        NumberOfMinutes = numberOfMinutes;
        NumberOfSMS = numberOfSMS;
        NumberOfGBOfTraffic = numberOfGBOfTraffic;
    }

    public int getNumberOfMinutes() {
        return NumberOfMinutes;
    }

    public int getNumberOfSMS() {
        return NumberOfSMS;
    }

    public int getNumberOfGBOfTraffic() {
        return NumberOfGBOfTraffic;
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
                ", NumberOfMinutes=" + NumberOfMinutes +
                ", NumberOfSMS=" + NumberOfSMS +
                ", NumberOfGBOfTraffic=" + NumberOfGBOfTraffic +
                '}';
    }
}
