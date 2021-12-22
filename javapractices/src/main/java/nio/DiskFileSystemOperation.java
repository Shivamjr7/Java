package nio;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;

public class DiskFileSystemOperation {


    public static void main(String[] args) throws IOException, URISyntaxException {


        //2 types of file system provider provided by jdk - windows/macos and zip
        List<FileSystemProvider> fileSystemList = FileSystemProvider.installedProviders();
        fileSystemList.stream().forEach(System.out::println);


        FileSystemProvider macProvider = fileSystemList.get(0);
        System.out.println("Schema : " + macProvider.getScheme());
        // we can also get the default filesystem
        FileSystem fs = FileSystems.getDefault();


        Path path = Paths.get("/Users/sjari/dir1"); // this will take default file system and create
        Path path2 = Paths.get(URI.create("file:///Users/sjari/dir2")); // creates path from URI

        // creating directory
        System.out.println("Creating dirs ...");

        macProvider.createDirectory(path);
        macProvider.createDirectory(path2);


        FileSystem fileSystem = FileSystems.getFileSystem(URI.create("file:///"));

        //since iterable is created it is faster than list and provides improved performance
        Iterable<Path> rootDirs  = fileSystem.getRootDirectories();
        rootDirs.forEach(System.out::println);


        //file stores
        Iterable<FileStore> fileStores = fileSystem.getFileStores();
        fileStores.forEach(fileStore -> System.out.println(fileStore.type()));

    }

}
