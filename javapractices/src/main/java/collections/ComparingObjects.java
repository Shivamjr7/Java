package collections;

import java.util.*;

public class ComparingObjects {


    public static void main(String[] args) {


        Person shivam = new Person("Shivam", 3);
        Person asif = new Person("Asif", 1);
        Person abhinav = new Person("Abhinav", 4);
        Person gaurav = new Person("Gaurav", 7);
        Person shrikant = new Person("Shrikant", 9);

        List<Person> personList = new ArrayList<>();
        personList.add(shivam);
        personList.add(asif);
        personList.add(abhinav);
        personList.add(gaurav);
        personList.add(shrikant);

        /**
         * Using comparable to sort
         */
        System.out.println("Before sorting :" + personList);
        //using comparable interface
        Collections.sort(personList);
        System.out.println("After sorting :" + personList);


        /**
         * using comparator to sort
         */
        System.out.println("After sorting using comparator :" + personList);
        // using comparator
        Collections.sort(personList, (person1, person2) -> {
            return person2.id - person1.id;
        });
        List<Person> newPersonList = new ArrayList<>(Arrays.asList(
                new Person("Mehandi", 111), new Person("Khanna", 28)
        ));


        /**
         * even simplified way
         */
        Comparator<Person> comparingbyNames = Comparator.comparing(Person::getName);
        Comparator<Person> comparingbyId = Comparator.comparing(Person::getId);


        newPersonList.sort(comparingbyId);
        System.out.println("comparing by id :" + newPersonList);

        newPersonList.sort(comparingbyNames);
        System.out.println("comparing by names :" + newPersonList);
    }
}


class Person implements Comparable<Person> {


    String name;

    public int getId() {
        return id;
    }

    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}