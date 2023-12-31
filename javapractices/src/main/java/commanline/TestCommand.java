package commanline;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name ="hello"
)
public class TestCommand  implements  Runnable{

    public static void main(String[] args) {
        CommandLine.run(new TestCommand(),args);
    }
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
