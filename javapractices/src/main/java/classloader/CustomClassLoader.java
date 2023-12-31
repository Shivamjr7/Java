package classloader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader{

    private String classPath;

    CustomClassLoader(){

    }
    CustomClassLoader(String path){
        this.classPath = path;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte [] data  = loadClassData(name);
        return defineClass(name,data,0,data.length);
    }




    public byte[] loadClassData(String name) throws ClassNotFoundException {
        Path path = Paths.get(classPath , name.replace(".","/")+ ".class");
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        CustomClassLoader customClassLoader = new CustomClassLoader("/Users/sjari/projects/java/Java/javapractices/src/main/java");
        String className = "classloader.CustomClassLoader";

        Class<?> clazz = customClassLoader.findClass(className);
        System.out.println(clazz.getDeclaredMethods());


    }
}
