package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class WiredInternet {
    private final UUID ID;
    private final LocalDate StartOfTheContract;
    private final LocalDate TheEndOfTheContract;
    private final int ContractNumber;
    private final Person Owner;
    private final int ConnectionSpeed;

    public WiredInternet(LocalDate startOfTheContract, LocalDate theEndOfTheContract,
                         int contractNumber, Person owner, int connectionSpeed) {
        this.ID = UUID.randomUUID();
        StartOfTheContract = startOfTheContract;
        TheEndOfTheContract = theEndOfTheContract;
        ContractNumber = contractNumber;
        Owner = owner;
        ConnectionSpeed = connectionSpeed;
    }

    public UUID getID() {
        return ID;
    }

    public LocalDate getStartOfTheContract() {
        return StartOfTheContract;
    }

    public LocalDate getTheEndOfTheContract() {
        return TheEndOfTheContract;
    }

    public int getContractNumber() {
        return ContractNumber;
    }

    public Person getOwner() {
        return Owner;
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
                "ID=" + ID +
                ", StartOfTheContract=" + StartOfTheContract +
                ", TheEndOfTheContract=" + TheEndOfTheContract +
                ", ContractNumber=" + ContractNumber +
                ", Owner=" + Owner +
                ", ConnectionSpeed=" + ConnectionSpeed +
                '}';
    }
}
