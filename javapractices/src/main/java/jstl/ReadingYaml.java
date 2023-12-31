package jstl;

import com.schibsted.spt.data.jslt.Parser;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ReadingYaml {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("/Users/sjari/projects/java/Java/javapractices/src/main/java/jstl/expr.yml");
        InputStream io = Files.newInputStream(path);
        Yaml yaml = new Yaml();
        Map<ExpressionConstants, String> map = yaml.load(io);









    }



}


enum ExpressionConstants {

    CAL_EXPR("calExpr");


    private final String value;


    ExpressionConstants(String value) {
        this.value = value;

    }

    private static final Map<String, ExpressionConstants> ENUM_MAP;


    // Build an immutable map of String name to enum pairs.
    // Any Map impl can be used.

    static {
        Map<String, ExpressionConstants> map = new ConcurrentHashMap<>();
        for (ExpressionConstants instance : ExpressionConstants.values()) {
            map.put(instance.getValue().toLowerCase(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static ExpressionConstants get(String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }

    public String getValue() {
        return value;
    }
}



