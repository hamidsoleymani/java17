package com.boostmedia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CollectionApiTest {

    Collection<Integer> a = new ArrayList<>();

    Collection<Integer> b = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(4);
        a.add(7);
        a.add(8);

        b.add(7);
        b.add(7);
        b.add(3);
        b.add(2);
        b.add(9);
    }

    @Test
    public void findCommon() {
        CollectionApi api = new CollectionApi();
        Set<Integer> common = api.findCommon(a, b);
        assertEquals(common, Set.of(2, 7));
        common = api.findCommon1(a, b);
        assertEquals(common, Set.of(2, 7));
        common = api.findCommon2(a, b);
        assertEquals(common, Set.of(2, 7));
    }

    @Test
    public void setOperation() {
        CollectionApi api = new CollectionApi();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        b.add(2);
        b.add(4);
        b.add(6);
        b.add(7);
        Set<Integer> expected = Set.of(1, 3, 5);
        Set<Integer> actual = api.intersect(a, b);
        assertEquals(expected, actual);
        actual = api.intersect1(a, b);
        assertEquals(expected, actual);

        Set<Integer> expected2 = Set.of(6, 7);
        actual = api.intersect(b, a);
        assertEquals(expected2, actual);

        Set<Integer> union = api.union(a, b);

        assertEquals(List.of(4,3,2,1), api.revers(List.of(1, 2, 3, 4)));
        assertEquals(List.of("d","c","b","a"), api.revers(List.of("a","b","c","d")));
        List<Integer> removeduplicate = api.removeduplicate(List.of(1, 1, 2, 3, 4, 1, 2, 3));
        assertEquals(List.of(1, 2, 3, 4), removeduplicate);
         removeduplicate = api.removeduplicate2(List.of(1, 1, 2, 3, 4, 1, 2, 3));
        assertEquals(List.of(1, 2, 3, 4), removeduplicate);
    }
}
