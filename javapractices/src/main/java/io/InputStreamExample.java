package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputStreamExample {


    public static void main(String[] args) throws IOException {

        Path path = Paths.get("file.txt");
        //creating input stream
        InputStream is = Files.newInputStream(path);



    }
}
