package java8.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private int age;

    private List<String> gamesPlayed;


    public List<String> getGamesPlayed() {
        return gamesPlayed;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGamesPlayed(List<String> gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    Player(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static List<Player> getPlayersData(){

        List<Player> players = new ArrayList<>();

        Player ronaldo = new Player("Ronaldo",37);
        Player messi = new Player("messi",34);
        Player shivam = new Player("shivam",31);
        Player asif = new Player("asif",32);
        Player abhinav = new Player("abhinav",31);


        ronaldo.setGamesPlayed(new ArrayList<>(Arrays.asList("football","badminton")));
        messi.setGamesPlayed(new ArrayList<>(Arrays.asList("football")));
        shivam.setGamesPlayed(new ArrayList<>(Arrays.asList("football","cricket")));
        asif.setGamesPlayed(new ArrayList<>(Arrays.asList("football")));
        abhinav.setGamesPlayed(new ArrayList<>(Arrays.asList("god of war")));


        players.add(ronaldo);
        players.add(messi);
        players.add(shivam);
        players.add(asif);
        players.add(abhinav);
        return  players;



    }


    public static Player getSinglePlayerData()
    {

        Player tenHag =  new Player("Ten Hag",41);
        tenHag.setGamesPlayed( new ArrayList<>(Arrays.asList("Football")));

        return tenHag;
    }

}
