package Container;

import Telecommunication.AbstractContract;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * @author DS
 */
public class ContainerArray {
    private final static int INIT_SIZE = 16;
    private final static int CUT_RATE = 4;
    private AbstractContract[] array = new AbstractContract[INIT_SIZE];
    private int pointer = 0;

    /**
     * If, when adding a new element, the array reaches
     * its maximum size, then it is necessary to add an
     * element with the possibility of recreating the array
     *
     * @param item The element to add
     */
    public void add(AbstractContract item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    public AbstractContract getIndex(int index) {
        return array[index];
    }


    /**
     * If the occupied cells are 75% less than
     * the free ones removing the element with
     * a shift to the left and with the possibility
     * of decreasing the array
     *
     * @param index The index of the item to remove
     */
    public void remove(int index) {
        try {
            if (pointer - index >= 0)
                System.arraycopy(array, index + 1, array, index, pointer - index);
            array[pointer] = null;
            pointer--;
            if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
                resize(array.length / 2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleting an element by ID using enumeration and the remove(int index) method
     *
     * @param id ID
     * @return Has the deletion occurred or not
     */
    public boolean removeByID(UUID id) {
        try {
            for (int i = 0; i < pointer; i++) {
                if (array[i].getID() == id) {
                    remove(i);
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method of creating a new array with a given length
     *
     * @param newLength new length
     */
    private void resize(int newLength) {
        AbstractContract[] newArray = new AbstractContract[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public int size() {
        return pointer;
    }


    public AbstractContract getByIndex(int index) {
        return array[index];
    }

    /**
     * Search for an element by ID using a regular search
     *
     * @param id ID
     * @return Contract
     */
    public Optional<AbstractContract> getByID(UUID id) {
        Optional<AbstractContract> optional = Optional.empty();
        for (int i = 0; i < pointer; i++) {
            if (array[i].getID() == id) {
                optional = Optional.of(array[i]);
                break;
            }
        }
        return optional;
    }

    /**
     * Completely clears the array
     */
    public void clear() {
        array = new AbstractContract[INIT_SIZE];
        pointer = 0;
    }

    public AbstractContract[] getArray() {
        return array;
    }

    public Optional<AbstractContract> searchContract(Predicate<AbstractContract> predicate) {
        Optional<AbstractContract> optional = Optional.empty();
        for (AbstractContract abstractContract : array) {
            if (predicate.test(abstractContract)) {
                optional = Optional.of(abstractContract);
                break;
            }

        }
        return optional;
    }
}


