package java8.streams.terminal;

import java8.data.Player;
import java8.streams.SortedExample;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsMappingExample {


    public static void main(String[] args) {


        List<String> names = Player.getPlayersData()
                .stream()
                .collect(Collectors.mapping(Player::getName, Collectors.toList()));


        List<Integer> age = Player.getPlayersData()
                .stream()
                .collect(Collectors.mapping(Player::getAge, Collectors.toList()));

       List<List<String>> gamesPlayed =  Player.getPlayersData()
                .stream()
                .collect(Collectors.mapping(Player::getGamesPlayed,Collectors.toList()));


    }


}




