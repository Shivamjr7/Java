package java8;

/**
 * We can pass methods to functions
 *
 * void someMethod(){}
 *
 * Function myFunc = someMethod()
 * considering the myFunc takes no arg and returns void
 * @author Shivam Jari
 */
public class FunctionsAsData {

    public static void main(String[] args) {

        boolean loadGame = true;
        GameLoader loader = new GameLoader(loadGame);
        loader.function.apply();

    }
}

@FunctionalInterface
interface NoArgFunction<T>
{
    T apply();
}

class GameLoader{

    public final NoArgFunction<Game> function;

    GameLoader(boolean loadgame)
    {
        // passing other methods to functions
        this.function = loadgame ? this::loadRealGame :this::loadFakeGame;
    }


    private Game loadRealGame()
    {
        System.out.println("Returning a real game...");
        return new Game("FIFA 19",200.99);
    }

    private Game loadFakeGame()
    {
        System.out.println("Returning a fake game...");
        return new Game("GTA",1999.99);
    }
}

class Game{

    Game(String name , Double price)
    {
        this.name = name;
        this.price = price;

    }
    private String name;
    private Double price;
}
