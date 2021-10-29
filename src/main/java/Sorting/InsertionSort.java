package Sorting;

import Container.ContainerArray;
import Telecommunication.AbstractContract;

import java.util.Comparator;

public class InsertionSort implements ISorter {
    @Override
    public void sort(Comparator<AbstractContract> contractComparator, ContainerArray containerArray) {
        AbstractContract[] array = containerArray.getArray();
        for (int left = 0; left < containerArray.size(); left++) {
            AbstractContract value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (contractComparator.compare(value, array[i]) > 0) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }

}

