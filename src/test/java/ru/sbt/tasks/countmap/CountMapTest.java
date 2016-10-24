/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tasks.countmap;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author HPBrick
 */
public class CountMapTest {
    @Test
    public void testAddGetCountRemoveAndSize() {
        CountMap<String> map = new CountMapImpl<>();
        map.add("aaa");
        map.add("aaa");
        map.add("bbb");
        map.add("Ccc");
        map.add("Aaa");
        assertEquals(map.getCount("aaa"), 2);
        assertEquals(map.remove("aaa"), 2);
        assertEquals(map.getCount("aaa"), 0);
        assertEquals(map.size(), 3);
    }
    
    @Test
    public void testAddAll() {
        CountMap<CharSequence> map = new CountMapImpl<>();
        map.add("aaa");
        map.add("aaa");
        map.add("bbb");
        map.add("Ccc");
        map.add("Aaa");
        CountMap<String> source = new CountMapImpl<>();
        source.add("aaa");
        source.add("bbb");
        source.add("ddd");
        map.addAll(source);
        assertEquals(map.getCount("aaa"), 3);
        assertEquals(map.getCount("ddd"), 1);        
    }
    
    @Test
    public void testToMap() {
        CountMap<Number> map = new CountMapImpl<>();
        map.add(1);
        map.add(1);
        map.add(2.3);
        assertEquals((int) map.toMap().get(1), (int) 2);    
    }
    
    @Test
    public void testToMapDestination() {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(1);
        map.add(1);
        map.add(23);
        Map<Number, Integer> numberCount = new HashMap<>();
        map.toMap(numberCount);
        assertEquals((int) numberCount.get(1), (int) 2);    
    }
}
