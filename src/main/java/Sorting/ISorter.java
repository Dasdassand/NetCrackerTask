package Sorting;

import Container.ContainerArray;
import Telecommunication.AbstractContract;

import java.util.Comparator;

public interface ISorter {
     void sort(Comparator<AbstractContract> contractComparator, ContainerArray containerArray);
}
