package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractContract {
    private final UUID ID;
    private final LocalDate StartOfTheContract;
    private final LocalDate TheEndOfTheContract;
    private final int ContractNumber;
    private final Person Owner;

    /**
     *
     * @param startOfTheContract
     * @param theEndOfTheContract
     * @param contractNumber
     * @param owner
     */
    protected AbstractContract(LocalDate startOfTheContract, LocalDate theEndOfTheContract, int contractNumber, Person owner) {
        ID = UUID.randomUUID();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractContract)) return false;
        AbstractContract that = (AbstractContract) o;
        return getContractNumber() == that.getContractNumber() && Objects.equals(getID(), that.getID()) && Objects.equals(getStartOfTheContract(), that.getStartOfTheContract()) && Objects.equals(getTheEndOfTheContract(), that.getTheEndOfTheContract()) && Objects.equals(getOwner(), that.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getStartOfTheContract(), getTheEndOfTheContract(), getContractNumber(), getOwner());
    }

    @Override
    public String toString() {
        return "AbstractContract{" +
                "ID=" + ID +
                ", StartOfTheContract=" + StartOfTheContract +
                ", TheEndOfTheContract=" + TheEndOfTheContract +
                ", ContractNumber=" + ContractNumber +
                ", Owner=" + Owner +
                '}';
    }
}
