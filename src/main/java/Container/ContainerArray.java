package Container;

import Telecommunication.AbstractContract;

import java.util.UUID;

/**
 * @author DS
 */
public class ContainerArray {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private AbstractContract[] array = new AbstractContract[INIT_SIZE];
    private int pointer = 0;

    /**
     * 2)
     *
     * @param item  The element to add
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
     * @param index  The index of the item to remove
     */
    public void remove(int index) {
        if (pointer - index >= 0)
            System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
    }

    public int size() {
        return pointer;
    }

    /**
     * 4
     *
     * @param newLength  new length
     */
    private void resize(int newLength) {
        AbstractContract[] newArray = new AbstractContract[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public AbstractContract getByIndex(int index) {
        return array[index];
    }

    /**
     * 5
     *
     * @param id  ID
     * @return  Contract
     */
    public AbstractContract getByID(UUID id) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].getID() == id) {
                return array[i];
            }
        }
        return null;
    }

    /**
     * 6
     *
     * @param id  ID
     * @return  Has the deletion occurred or not
     */
    public boolean removeByID(UUID id) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].getID() == id) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean getResultCompare(String nameOne, String nameTwo) {
        return compareCharArray(nameOne, nameTwo);
    }

    public char[] getResultRemovingSpaces(String nameOne) {
        return removingSpaces(nameOne.toCharArray());
    }

    /**
     * Bubble Sort
     */
    public void sortByName() {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < pointer; i++) {
                if (compareCharArray(array[i].getOwner().getFullName(), array[i - 1].getOwner().getFullName())) {
                    swap(i, i - 1);
                    needIteration = true;
                }
            }
        }
    }

    /**
     * Swaps elements
     *
     * @param ind1  index one
     * @param ind2  index two
     */
    private void swap(int ind1, int ind2) {
        AbstractContract tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    /**
     * @param nameOne  Name one
     * @param nameTwo  Name Two
     * @return  The result of the character-by-character comparison
     */
    private boolean compareCharArray(String nameOne, String nameTwo) {
        char[] nameOneArray = removingSpaces(nameOne.toUpperCase().toCharArray());
        char[] nameTwoArray = removingSpaces(nameTwo.toUpperCase().toCharArray());
        int length = Math.min(nameOneArray.length, nameTwoArray.length);
        for (int i = 0; i < length; i++) {
            if (nameOneArray[i] > nameTwoArray[i]) {
                return false;
            } else {
                if (nameOneArray[i] < nameTwoArray[i]) {
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * Removing spaces from an array
     *
     * @param array  array
     * @return  Array without spaces
     */
    private char[] removingSpaces(char[] array) {
        String result = "";
        for (char c : array) {
            if (c != ' ') {
                result += c;
            }
        }
        return result.toCharArray();
    }

    /**
     * Completely clears the array
     */
    public void clear() {
        array = new AbstractContract[INIT_SIZE];
        pointer = 0;
    }
}


