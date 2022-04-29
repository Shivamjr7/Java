package java8.streams.terminal;

import java8.data.Player;

import java.util.stream.Collectors;

public class StreamsSumAvgExample {


    public static void main(String[] args) {

        System.out.println("Sum of player ages : "+sum());
        System.out.println("avg  of player ages : "+avg());

    }

    static int sum() {
        return
                Player.getPlayersData()
                        .stream()
                        .collect(Collectors.summingInt(Player::getAge));
    }

    static double avg()
    {
        return
                Player.getPlayersData()
                .stream()
                .collect(Collectors.averagingInt(Player::getAge));
    }


}
