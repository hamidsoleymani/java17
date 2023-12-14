package com.boostmedia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeRepository {

    private static Employee jeff = new Employee(1, "Jeff Bezos", 100000.0d);
    private static Employee bill = new Employee(2, "Bill Gates", 200000.0d);
    private static Employee mark = new Employee(3, "Mark Zuckerberg", 300000.0d);
    private static Employee[] arrayOfEmps = {jeff, bill, mark};
    private  static Map<Integer, Employee> repo = Map.ofEntries(Map.entry(1, jeff), Map.entry(2, bill), Map.entry(3, mark));

    public EmployeeRepository() {
    }

    public static Stream<Employee> empAsStream() {
        return Stream.of(arrayOfEmps);
    }

    public static List<Employee> empAslist() {
        return Stream.of(arrayOfEmps).collect(Collectors.toList());
    }

    public static Employee findbyId(int id) {
        return repo.get(id);
    }
}
