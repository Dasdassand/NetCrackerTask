package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class WiredInternet extends AbstractContract{

    private final int ConnectionSpeed;

    public WiredInternet(LocalDate startOfTheContract, LocalDate theEndOfTheContract,
                         int contractNumber, Person owner, int connectionSpeed) {
        super(startOfTheContract, theEndOfTheContract, contractNumber, owner);
        ConnectionSpeed = connectionSpeed;
    }


    public int getConnectionSpeed() {
        return ConnectionSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WiredInternet)) return false;
        WiredInternet that = (WiredInternet) o;
        return getContractNumber() == that.getContractNumber() && getConnectionSpeed() == that.getConnectionSpeed() && Objects.equals(getID(), that.getID()) && Objects.equals(getStartOfTheContract(), that.getStartOfTheContract()) && Objects.equals(getTheEndOfTheContract(), that.getTheEndOfTheContract()) && Objects.equals(getOwner(), that.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getStartOfTheContract(), getTheEndOfTheContract(), getContractNumber(), getOwner(), getConnectionSpeed());
    }

    @Override
    public String toString() {
        return "WiredInternet{" +
                "ID=" + getID() +
                ", StartOfTheContract=" + getStartOfTheContract() +
                ", TheEndOfTheContract=" + getTheEndOfTheContract() +
                ", ContractNumber=" + getContractNumber() +
                ", Owner=" + getOwner() +
                ", ConnectionSpeed=" + ConnectionSpeed +
                '}';
    }
}
