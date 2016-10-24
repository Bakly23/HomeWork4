/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tasks.collectionutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author HPBrick
 */
public class CollectionUtilsTest {

    @Test
    public void testAdds() {
        List<Number> numberList = new ArrayList(Arrays.asList(2.5, 2.3f, 199999L, 19));
        CollectionUtils.add(numberList, 3.1);
        assertEquals(numberList, Arrays.asList(2.5, 2.3f, 199999L, 19, 3.1));
        List<Double> doubleList = Arrays.asList(2.5, 3.6);
        CollectionUtils.addAll(doubleList, numberList);
        assertEquals(numberList, Arrays.asList(2.5, 2.3f, 199999L, 19, 3.1, 2.5, 3.6));
    }

    @Test
    public void testLimitAndContains() {
        List<Number> numberList = Arrays.asList(2.5, 2.3f, 199999L, 19);
        List<Number> limited = CollectionUtils.limit(numberList, 2);
        assertTrue(CollectionUtils.containsAny(numberList, Arrays.asList(2.5, 2.7)));
        assertTrue(CollectionUtils.containsAll(numberList, Arrays.asList(2.5, 2.3f)));
        assertEquals(limited, Arrays.asList(2.5, 2.3f));
    }

    @Test
    public void testRemoveAll() {
        List<Number> numberList = new ArrayList(
                Arrays.asList(2.5, 2.9, 3.1, 2.3f, 199999L, 19));
        List<Double> doubleList = Arrays.asList(2.5, 2.9);
        CollectionUtils.removeAll(numberList, doubleList);
        assertEquals(numberList, Arrays.asList(3.1, 2.3f, 199999L, 19));
    }

    @Test
    public void testRangeComparable() {
        List<Double> doubleList = Arrays.asList(2.5, 2.9, 3.1, 5.6, 7.4, 8.1);
        List<Double> rangedList = CollectionUtils.range(doubleList, 2.9, 5.6);
        assertEquals(rangedList, Arrays.asList(2.9, 3.1, 5.6));
    }

    @Test
    public void testRangeComparator() {
        List<Number> doubleList = Arrays.asList(2.5, 2.9, 3, 3.1, 31, 5, 5.6, 6, 7.4f, 10, 8.1);
        List<Number> rangedList = CollectionUtils.range(doubleList, 2.9, 5.6, (Comparator<Number>) (o1, o2) -> {
            if (o1.longValue() == o2.longValue()) {
                return Double.compare(o1.doubleValue(), o2.doubleValue());
            } else {
                return Long.compare(o1.longValue(), o2.longValue());
            }
        });
        assertEquals(rangedList, Arrays.asList(2.9, 3, 3.1, 5, 5.6));
    }

}
