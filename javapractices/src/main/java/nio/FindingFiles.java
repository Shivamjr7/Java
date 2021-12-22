package nio;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FindingFiles {


    public static void main(String[] args) throws IOException {

        Path path = Paths.get(URI.create("file:///Users/sjari/Downloads/Personal"));
        boolean isDirExists = Files.exists(path);

        System.out.println("Dir exists");

        //finding files
        Stream<Path> pathStream = Files.find(path, Integer.MAX_VALUE, (p, attribute) -> true);

        //no of files
        System.out.println("No of files present :"+ pathStream.count());

        //finding only jpg file
        Stream<Path> findjpg = Files.find(path, Integer.MAX_VALUE, (p, attribute) -> p.toString().endsWith(".jpg"));
        System.out.println("No of jpg files present :"+ findjpg.count());

        Stream<Path> findDirs = Files.find(path, Integer.MAX_VALUE, (p, attribute) -> attribute.isDirectory());
        System.out.println("No of dir  present :"+ findDirs.count());


    }
}
