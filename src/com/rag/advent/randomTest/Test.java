package com.rag.advent.randomTest;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Test {

    public static void main(String[] args) {
        List<Person> list = new LinkedList<>();
        Person p = new Person("rag", LocalDate.of(2000, 8, 14), Person.Sex.MALE, "stifer", 22);
        list.add(p);
        p = new Person("marshall", LocalDate.of(2002, 8, 14), Person.Sex.MALE, "stifer", 22);
        list.add(p);
        p = new Person("Mathers", LocalDate.of(2002, 8, 14), Person.Sex.MALE, "stifer", 18);
        list.add(p);

        Stream<Person> stream1 = list.stream();
        Stream<Person> filter1 = stream1.filter(person -> person.age > 20);

        Stream<Person> stream2 = list.stream();
        Stream<Person> filter2 = stream2.filter(person -> person.age > 20);
        IntStream is = filter2.mapToInt(value -> value.getAge());

        int sum = is.sum();
        System.out.println(sum);
        String trees = "002220132213130200100332200140301325451123154323515145222525421135230113344411313343203012321310011";
        System.out.println(trees.length());
    }
}


class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate bday;
    Sex gender;
    String email;

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age = 0;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        bday = LocalDate.of(2000, 8, 14);
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(bday, curDate);
        int age = period.getYears();
        return age;
    }

    public void printPerson() {

    }

    public void printPersons(List<Person> person, CheckPerson tester) {

        for (Person p : person) {
            if (tester.test(p)) {
                System.out.println("HEY");
            }
        }
    }

    public Person() {

    }

    public Person(String name, LocalDate bday, Sex gender, String email, int age) {
        this.name = name;
        this.bday = bday;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }

    public void printPersons() {

    }

}

interface CheckPerson {
    boolean test(Person p);
}

class PersonEligible implements CheckPerson {
    public boolean test(Person p) {
        boolean state = false;
        if (p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25) {
            state = true;
        }
        return state;
    }
}