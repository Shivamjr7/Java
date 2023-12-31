import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CompareRC {


    public static void main(String[] args) throws IOException {

        Map<String, String> appMap = new HashMap<>();
        Map<String, String> rcMap = new HashMap<>();

        //read app.properties
        Properties appProp = readPropertiesFile("/Users/sjari/projects/java/Java/javapractices/src/main/java/app.properties");
        Properties rcProp = readPropertiesFile("/Users/sjari/projects/java/Java/javapractices/src/main/java/rc.properties");

        appProp.entrySet().stream().forEach(e->{
            appMap.put(e.getKey().toString().trim(), e.getValue().toString().trim());
        });


        rcProp.entrySet().stream().forEach(e->{
            rcMap.put(e.getKey().toString().trim(), e.getValue().toString().trim());
        });


        // keys present with different value
//        for(Map.Entry<String , String> entry: rcMap.entrySet())
//        {
//
//            String key = entry.getKey();
//            String val = entry.getValue();
//            if(appMap.containsKey(key) && !val.equals(appMap.get(key)))
//            {
//                System.out.println("----------------------------");
//                System.out.println("key : "+ key);
//                System.out.println("val in RC : " + val);
//                System.out.println("val in app.prop : " + appMap.get(key));
//                System.out.println("----------------------------");
//            }
//        }

        System.out.println("--------------------------");

//        // keys present in rc not in app
        for(Map.Entry<String , String> entry: rcMap.entrySet())
        {

            String key = entry.getKey();
            String val = entry.getValue();
            if(!appMap.containsKey(key))
            {
                System.out.println("----------------------------");
                System.out.println("key : "+ key);
                System.out.println("val in RC : " + val);
                System.out.println(key+"="+val);
                System.out.println("val in app.prop : " + appMap.get(key));
                System.out.println("----------------------------");
            }
        }
//
//        System.out.println("--------------------------");


        //

//        for(Map.Entry<String, String> rcmapentry: rcMap.entrySet())
//        {
//            String key = rcmapentry.getKey();
//            String val = rcmapentry.getValue();
//            appMap.put(key,val);
//
//        }
//
//
//        for(Map.Entry<String , String> entry: appMap.entrySet()) {
//
//            String key = entry.getKey();
//            String val = entry.getValue();
//            System.out.println("----------------------------");
//            System.out.println("key : " + key);
//            System.out.println("val in RC : " + val);
//            System.out.println("val in app.prop : " + appMap.get(key));
//            System.out.println("----------------------------");
//        }



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
