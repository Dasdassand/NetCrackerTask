package Telecommunication;

import Container.ContainerArray;
import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class DigitalTelevision {
    private final UUID ID;
    private final LocalDate StartOfTheContract;
    private final LocalDate TheEndOfTheContract;
    private final int ContractNumber;
    private final Person Owner;
    private ContainerArray<DigitalСhannels> digitalСhannels;

    public DigitalTelevision(LocalDate startOfTheContract, LocalDate theEndOfTheContract, int contractNumber, Person owner) {
        this.ID = UUID.randomUUID();
        StartOfTheContract = startOfTheContract;
        TheEndOfTheContract = theEndOfTheContract;
        ContractNumber = contractNumber;
        Owner = owner;
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

    public ContainerArray<DigitalСhannels> getDigitalСhannels() {
        return digitalСhannels;
    }

    public void addChannel(DigitalСhannels digitalСhannel) {
        digitalСhannels.add(digitalСhannel);
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
                "ID=" + ID +
                ", StartOfTheContract=" + StartOfTheContract +
                ", TheEndOfTheContract=" + TheEndOfTheContract +
                ", ContractNumber=" + ContractNumber +
                ", Owner=" + Owner +
                ", digitalСhannels=" + digitalСhannels +
                '}';
    }
}
