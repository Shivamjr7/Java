package jstl;

import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TestJSTL {

    public static void main(String[] args) throws IOException {



        Path path = Paths.get("/Users/sjari/projects/java/Java/javapractices/src/main/java/jstl/expr.txt");
        InputStream io =  Files.newInputStream(path);

        String rawValues = IOUtils.toString(io, StandardCharsets.UTF_8);


        Map<String,String> map = new HashMap<>();
        String[] entries = rawValues.split("&");


        for (String entry : entries) {
            String[] keyValue = entry.split("=");
            map.put(keyValue[0],keyValue[1]);
        }


        Map<String , Expression> expressionMap = new HashMap<>();
        map.
                forEach((k, v) -> {
                    expressionMap.put(k,
                            Parser.compileString(v));
                });

        System.out.println("compiled successfully");

        expressionMap.entrySet()
                .forEach(e ->{
                    System.out.println("key : "+ e.getKey());
                    System.out.println("value : "+ e.getValue());
                });



    }

}
