package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
/**
 * @author DS
 */
public abstract class AbstractContract {
    private final UUID id;
    private final LocalDate startOfTheContract;
    private final LocalDate theEndOfTheContract;
    private final int contractNumber;
    private final Person owner;

    /**
     * @param startOfTheContract Start of the Contract
     * @param theEndOfTheContract  The end of Contract
     * @param contractNumber  Contract Number
     * @param owner Owner
     */
    protected AbstractContract(LocalDate startOfTheContract, LocalDate theEndOfTheContract, int contractNumber, Person owner) {
        id = UUID.randomUUID();
        this.startOfTheContract = startOfTheContract;
        this.theEndOfTheContract = theEndOfTheContract;
        this.contractNumber = contractNumber;
        this.owner = owner;
    }

    public UUID getID() {
        return id;
    }

    public LocalDate getStartOfTheContract() {
        return startOfTheContract;
    }

    public LocalDate getTheEndOfTheContract() {
        return theEndOfTheContract;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public Person getOwner() {
        return owner;
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
                "id=" + id +
                ", startOfTheContract=" + startOfTheContract +
                ", theEndOfTheContract=" + theEndOfTheContract +
                ", contractNumber=" + contractNumber +
                ", owner=" + owner +
                '}';
    }
}
