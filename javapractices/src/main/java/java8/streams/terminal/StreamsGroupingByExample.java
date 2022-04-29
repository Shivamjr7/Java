package java8.streams.terminal;

import java8.data.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsGroupingByExample {


    public static void main(String[] args) {

        System.out.println(customizedGroupBy());;
    }


    static Map<String, List<Player>> customizedGroupBy() {
        return Player.getPlayersData()
                .stream()
                .collect(Collectors.groupingBy(player -> player.getName().startsWith("a") ? "groupA" : "groupB"));
    }

}
