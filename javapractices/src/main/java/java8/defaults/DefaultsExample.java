package java8.defaults;

import java8.data.Player;

import java.util.Comparator;
import java.util.List;

public class DefaultsExample {


    //comparator chaining
    void sortPlayers(List<Player> playerList) {

        playerList
                .sort(Comparator.comparing(Player::getName).
                        thenComparing(Comparator.comparing(Player::getAge)));

    }
}
