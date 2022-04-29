package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {

    public static void main(String[] args) {

        SortedExample object = new SortedExample();

        System.out.println("Sorting by name");
        System.out.println(object.sortByName(Player.getPlayers()));


        System.out.println("Sorting by Age");
        System.out.println(object.sortByAge(Player.getPlayers()));




    }

    public List<Player> sortByName(List<Player> players)
    {
        return players.stream()
                .sorted(Comparator.comparing(Player::getName))
                .collect(Collectors.toList());
    }

    public List<Player> sortByAge(List<Player> players)
    {
        return players.stream()
                .sorted(Comparator.comparing(Player::getAge))
                .collect(Collectors.toList());
    }


}


class Player {
    public String getName() {
        return name;
    }


    public  int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;


    Player(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public  static  List<Player> getPlayers() {
        return new ArrayList<>(

                Arrays.asList(
                        new Player("Ronaldo", 37),
                        new Player("Messi", 34),
                        new Player("Shivam",31)
                ));

    }
}
