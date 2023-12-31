import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ReadProp {

    public static void main(String[] args) throws IOException {

        List<String> props  = new ArrayList<>();
        Properties prop = readPropertiesFile("/Users/sjari/projects/java/Java/javapractices/src/main/java/test.properties");



        prop.entrySet().stream().forEach(e->{

            String key = (String) e.getKey();
//            if(((String) e.getKey()).startsWith("endpoint"))
            props.add(e.getKey()+"="+e.getValue());
        });
        System.out.println();

        Collections.sort(props);
        props.forEach(System.out::println);
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
