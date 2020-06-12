package rohit.leetcode;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

import static rohit.leetcode.ArraySortUsingComparator.Employee.*;

/**
 * Created by rohit on 12/6/20.
 */
public class ArraySortUsingComparator {
    class Employee{
        String name;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", dob=" + dob +
                    '}';
        }

        public LocalDate getDob() {
            return dob;
        }

        int age;
        LocalDate dob;

        public Employee(String name, int age, LocalDate dob){
            this.name = name;
            this.age = age;
            this.dob = dob;
        }


    }

    public static void main(String[] args) {
        ArraySortUsingComparator arraySortUsingComparator = new ArraySortUsingComparator();


        Employee[] employees = new Employee[5];
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        employees[0] = arraySortUsingComparator.new Employee("B",4, LocalDate.parse("07/03/2016",FOMATTER));
        employees[1] = arraySortUsingComparator.new Employee("A",2, LocalDate.parse("07/03/2018",FOMATTER));
        employees[2] = arraySortUsingComparator.new Employee("X",3, LocalDate.parse("07/03/2017",FOMATTER));
        employees[3] = arraySortUsingComparator.new Employee("C",5, LocalDate.parse("07/03/2015",FOMATTER));
        employees[4] = arraySortUsingComparator.new Employee("H",1, LocalDate.parse("07/03/2019",FOMATTER));

        //Arrays.stream(employees).forEach(System.out::println);

        Arrays.sort(employees, Comparator.comparingInt(a -> a.age));

        Arrays.stream(employees).forEach(System.out::println);
        Arrays.sort(employees, (a,b) -> (a.getName().compareTo(b.getName())));
        Arrays.stream(employees).forEach(System.out::println);
        Arrays.sort(employees, (a,b) -> (a.getDob().compareTo(b.getDob())));
        Arrays.stream(employees).forEach(System.out::println);
    }
}
