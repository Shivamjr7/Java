package nio;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class ZipFileOperations {


    public static void main(String[] args) {

        URI zip = URI.create("jar:file:///Users/sjari/nio/archive.zip");

        Map<String, String> options = new HashMap<>();
        options.put("create", "true");

        try (FileSystem zipfs = FileSystems.newFileSystem(zip, options)) {
            //copy a file to inside zip file
            Path source = Paths.get("/Users/sjari/nio/file2.txt");


            //creating dir within zip
            zipfs.provider().createDirectory(zipfs.getPath("files/"));


            //target path we should get from zipfs.getPath
            Path target = zipfs.getPath("files/newfile.txt");

            //copy the file
            Files.copy(source, target);


            //creating a file and writing using output stream
            Path bin = zipfs.getPath("bin");
            Path binFile = zipfs.getPath("bin/file3.txt");


            zipfs.provider().createDirectory(bin);

            OutputStream os = zipfs.provider().newOutputStream(binFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
            DataOutputStream dataOutputStream = new DataOutputStream(os);

            dataOutputStream.writeInt(10);
            dataOutputStream.writeInt(20);
            dataOutputStream.writeInt(30);

            dataOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
