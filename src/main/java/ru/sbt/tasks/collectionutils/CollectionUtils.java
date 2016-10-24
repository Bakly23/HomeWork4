/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tasks.collectionutils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author HPBrick
 */
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        return source.indexOf(o);
    }

    public static<T> List<T> limit(List<T> source, int size) {
        return new ArrayList<>(source.subList(0, size));
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<T> c1, List<? extends T> c2) {
        return c1.stream().anyMatch((e) -> c2.contains(e));
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max. 
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<? super T>> List<T> 
        range(List<T> list, T min, T max) {
        return list.stream()
                .filter(e -> e.compareTo(min) >= 0 && e.compareTo(max) <= 0)
                .collect(Collectors.toList());
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max. 
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List<T> range(List<T> list, T min, T max,
            Comparator<? super T> comparator) {
        return list.stream()
                .filter(e -> {
                    return comparator.compare(e, min) >= 0
                            && comparator.compare(e, max) <= 0;
                })
                .collect(Collectors.toList());
    }

}
 