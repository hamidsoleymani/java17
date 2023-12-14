package com.boostmedia;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionApi {

    public Set<Integer> findCommon(Collection<Integer> a, Collection<Integer> b) {
        Set<Integer> result = new HashSet<>();
        for (Integer i : a) {
            for (Integer j : b) {
                if (Objects.equals(i, j)) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    public Set<Integer> findCommon1(Collection<Integer> a, Collection<Integer> b) {
        return a.stream().filter(t -> b.contains(t)).collect(Collectors.toSet());
    }

    public Set<Integer> findCommon2(Collection<Integer> a, Collection<Integer> b) {
        Set<Integer> sa = new HashSet<>(a);
        Set<Integer> sb = new HashSet<>(b);
        boolean value = sa.retainAll(sb);
        return sa;
    }

    public Set<Integer> intersect(Set<Integer> a, Set<Integer> b) {
        Set<Integer> erg = new HashSet<>();
        boolean seen = false;
        for (Integer i : a) {
            for (Integer j : b) {
                if (Objects.equals(i, j)) {
                    seen = true;
                    break;
                } else {
                    seen = false;
                }
            }
            if (!seen) {
                erg.add(i);
            }
        }
        return erg;
    }

    public Set<Integer> intersect1(Set<Integer> a, Set<Integer> b) {
        Set<Integer> erg = new HashSet<>();
        for (Integer i : a) {
            if (!b.contains(i)) {
                erg.add(i);
            }
        }
        return erg;
    }

    public Set<Integer> union(Set<Integer> a, Set<Integer> b) {
        Set<Integer> erg = new HashSet<>(a);

        for (Integer j : b) {
            if (!erg.contains(j)) {
                erg.add(j);
            }
        }
        return erg;
    }

    public <T> List<T> revers(List<T> l){
        List<T> r = new ArrayList<>();
        int size = l.size();
        for(int i=size-1; i>=0; i--){
            r.add(l.get(i));
        }
       return r;
    }

    public <T> List<T> removeduplicate(List<T> l){
        HashSet<T> ts = new HashSet<>(l);
        return new ArrayList<>(ts);
    }

    public <T> List<T> removeduplicate2(List<T> l){
       List<T> erg = new ArrayList<>();
       for(T t: l){
           if(!erg.contains(t)){
               erg.add(t);
           }
       }
       return erg;
    }
}
