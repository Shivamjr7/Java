package java8;

import java8.data.Player;

import java.util.Optional;

public class OptionalOrElseExample {


    public static void main(String[] args) {

        System.out.println("Or Else : " + orElse());
        System.out.println("Or Else get : " + orElse());
        System.out.println("Or Else  throw: " + orElse());

    }

   static  String orElse()
    {
        Optional<Player> player = Optional.ofNullable(Player.getSinglePlayerData());
        //Optional<Player> player = Optional.ofNullable(null);
        return player.map(Player::getName).orElse("Shivam");
    }

   static  String orElseGet()
    {
        Optional<Player> player = Optional.ofNullable(Player.getSinglePlayerData());
        //Optional<Player> player = Optional.ofNullable(null);

        //orElseGet takes a supplier
        return    player.map(Player::getName).orElseGet(()-> "Shivam");
    }

    static String orElseThrow()
    {
        Optional<Player> player = Optional.ofNullable(Player.getSinglePlayerData());
        //Optional<Player> player = Optional.ofNullable(null);

        //orElseGet throws takes a supplier
        return    player.map(Player::getName).orElseThrow(()->new RuntimeException("No Players found"));
    }



}
