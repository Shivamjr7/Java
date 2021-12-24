package exceptions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MultiCatchBlock {


    public static void main(String[] args) {


        //before java 1.7
        try {
            Files.createFile(Paths.get(URI.create("")));
            Thread.sleep(1000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        //after java 1.7
        // declare multiple exception in single block
        try
        {
            Files.createFile(Paths.get(URI.create("")));
            Thread.sleep(1000);
        }
        catch(IOException | InterruptedException  e)
        {
            // e is final
            // e = new InterruptedException();
        }



    }


}
