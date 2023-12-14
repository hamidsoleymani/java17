package com.boostmedia;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Streamtest {


    List<Integer> listInt = List.of(4, 5, 6);
    List<Integer> ids = List.of(1, 2, 3);
    Consumer<Employee> c = System.out::println;
    Consumer<String> s = System.out::println;
    Consumer<Integer> i = System.out::println;
    @Test
    public void toArray() {

        EmployeeRepository.empAsStream().forEach(c);
        List<Employee> list = EmployeeRepository.empAslist();
        list.stream().forEach(c);
        list.stream().map(e -> e.getName()).forEach(s);
        list.stream().forEach(e -> e.salaryIncrement(1.0));
        list.stream().forEach(c);
        //

        Stream<Employee> employeeStream = listInt.stream().map(i -> new Employee(i, "", i * 5));
        employeeStream.forEach(c);

        List<Employee> collect = ids.stream().map(i -> EmployeeRepository.findbyId(i)).collect(Collectors.toList());
        List<Employee> collect2 = ids.stream().map(EmployeeRepository::findbyId).toList();

        collect.forEach(c);

        List<Employee> collect1 = EmployeeRepository.empAsStream().filter(e -> e.getId() > 1).collect(Collectors.toList());
        assertEquals(collect1.size(), 2);
        Optional<Employee> first = Optional.ofNullable(EmployeeRepository.empAsStream().findFirst().orElseThrow(IllegalArgumentException::new));
        assertEquals(first.get().getId(), 1);

        Employee employee1 = EmployeeRepository.empAsStream().filter(e -> e.getSalary() > 5_000_000_000.0d).findFirst().orElse(null);

        Employee[] array = EmployeeRepository.empAsStream().toArray(Employee[]::new);

        // Employee employee = EmployeeRepository.empAsStream().filter(e -> e.getSalary() > 5_000_000_000.0d).findFirst().orElseThrow();
    }
    @Test
    public void test(){
        EmployeeRepository.empAsStream().sorted((e1,e2)-> e1.getName().compareTo(e2.getName())).forEach(c);
        EmployeeRepository.empAsStream().sorted(Comparator.comparing(Employee::getName)).forEach(c);
        EmployeeRepository.empAsStream().filter(e-> e.getId()> 2).peek(System.out::println).toList();
        listInt.stream().sorted(Comparator.comparingInt(a -> a)).forEach(i);
        listInt.stream().sorted((a,b)->b-a).forEach(i);
        Integer i1 = listInt.stream().max((a, b) -> a - b).get();
        Integer i2 = listInt.stream().min(Comparator.comparingInt(a -> a)).get();
        System.out.println("max: "+i1);
        System.out.println("min: "+i2);
        Optional<Employee> max = EmployeeRepository.empAsStream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(max.get());
    }
}
