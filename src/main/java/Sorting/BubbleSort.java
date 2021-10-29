package Sorting;

import Container.ContainerArray;
import Telecommunication.AbstractContract;

import java.util.Comparator;

public class BubbleSort implements ISorter {
    @Override
    public void sort(Comparator<AbstractContract> contractComparator, ContainerArray containerArray) {
        AbstractContract[] array = containerArray.getArray();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < containerArray.size(); i++) {
                if (contractComparator.compare(array[i], array[i - 1]) > 0) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
        }
    }

    private void swap(AbstractContract[] array, int ind1, int ind2) {
        AbstractContract tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

}
