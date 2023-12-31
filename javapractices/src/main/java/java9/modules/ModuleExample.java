package java9.modules;

public class ModuleExample {

    public static void main(String[] args) {

        ModuleLayer moduleLayer = ModuleLayer.boot();

        moduleLayer.modules()
                .stream()
                .forEach(System.out::println);


    }

}
