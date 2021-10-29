package Sorting;

import Container.ContainerArray;
import Telecommunication.AbstractContract;

import java.util.Comparator;

public class MergeSort implements ISorter {
    @Override
    public void sort(Comparator<AbstractContract> contractComparator, ContainerArray containerArray) {
        mergeSort(contractComparator, containerArray.getArray(), 0, containerArray.size() - 1);
    }

    public static void mergeSort(Comparator<AbstractContract> contractComparator, AbstractContract[] source, int left, int right) {
        int delimiter = left + ((right - left) / 2) + 1;
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(contractComparator, source, left, delimiter - 1);
            mergeSort(contractComparator, source, delimiter, right);
        }
        AbstractContract[] buffer = new AbstractContract[right - left + 1];
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            if (delimiter > right || (contractComparator.compare(source[cursor], source[delimiter]) > 0)) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }
}
