import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CompareOverride {


    public static void main(String[] args) throws IOException {

        Map<String, String> appMap = new HashMap<>();
        Map<String, String> appOMap = new HashMap<>();

        //read app.properties
        Properties appProp = readPropertiesFile("/Users/sjari/projects/java/Java/javapractices/src/main/java/app.properties");
        Properties appOverRide = readPropertiesFile("/Users/sjari/projects/java/Java/javapractices/src/main/java/app-override.properties");

        appProp.entrySet().stream().forEach(e->{
            appMap.put(e.getKey().toString().trim(), e.getValue().toString().trim());
        });


        appOverRide.entrySet().stream().forEach(e->{
            appOMap.put(e.getKey().toString().trim(), e.getValue().toString().trim());
        });


        for(Map.Entry<String , String> entry: appOMap.entrySet())
        {

            String key = entry.getKey();
            String val = entry.getValue();
            if(appMap.containsKey(key) && val.equals(appMap.get(key)) )
            {
                System.out.println("----------------------------");
                System.out.println("key : "+ key);
                System.out.println("val in app override : " + val);
                System.out.println("val in app.prop : " + appMap.get(key));
                System.out.println("----------------------------");
            }
        }


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
