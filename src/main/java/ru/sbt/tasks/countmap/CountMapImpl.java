/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tasks.countmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HPBrick
 */
public class CountMapImpl<K> implements CountMap<K> {
    private final Map<K, Integer> counts;

    public CountMapImpl() {
        counts = new HashMap<>();
    }
    
    

    @Override
    public void add(K o) {
        counts.put(o, counts.getOrDefault(o, 0) + 1);
    }

    @Override
    public int getCount(K o) {
        return counts.getOrDefault(o, 0);
    }

    @Override
    public int remove(K o) {
        return counts.remove(o);
    }

    @Override
    public int size() {
       return counts.size();
    }

    @Override
    public void addAll(CountMap<? extends K> source) {
        source.toMap().forEach((key, value) -> 
            counts.put(key, counts.getOrDefault(key, 0) + value)
        );
    }

    @Override
    public Map<K, Integer> toMap() {
        return counts;        
    }

    @Override
    public void toMap(Map<? super K, Integer> destination) {
        destination.putAll(counts);
    }    
}
