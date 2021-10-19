package Telecommunication;

import Person.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class MobileConnection {
    /**
     * Все типы контрактов имеют поля
     * <p>
     * ID
     * Дата начала контракта
     * Дата окончания контракта
     * Номер контракта
     * Владелец контракта(Сущность Человек)
     * <p>
     * Кроме того
     * <p>
     * Контракт на мобильную связь имеет свойства(количество минут, смс и Гб трафика)
     * Контракт на проводной интернет - скорость соединения
     * Контракт на цифровое телевидение - пакет каналов
     */
    private final UUID ID;
    private final LocalDate StartOfTheContract;
    private final LocalDate TheEndOfTheContract;
    private final int ContractNumber;
    private final Person Owner;
    private final int NumberOfMinutes;
    private final int NumberOfSMS;
    private final int NumberOfGBOfTraffic;

    public MobileConnection(LocalDate startOfTheContract, LocalDate theEndOfTheContract, int contractNumber,
                            Person owner, int numberOfMinutes, int numberOfSMS, int numberOfGBOfTraffic) {
        this.ID = UUID.randomUUID();
        StartOfTheContract = startOfTheContract;
        TheEndOfTheContract = theEndOfTheContract;
        ContractNumber = contractNumber;
        Owner = owner;
        NumberOfMinutes = numberOfMinutes;
        NumberOfSMS = numberOfSMS;
        NumberOfGBOfTraffic = numberOfGBOfTraffic;
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
                "ID=" + ID +
                ", StartOfTheContract=" + StartOfTheContract +
                ", TheEndOfTheContract=" + TheEndOfTheContract +
                ", ContractNumber=" + ContractNumber +
                ", Owner=" + Owner +
                ", NumberOfMinutes=" + NumberOfMinutes +
                ", NumberOfSMS=" + NumberOfSMS +
                ", NumberOfGBOfTraffic=" + NumberOfGBOfTraffic +
                '}';
    }
}
