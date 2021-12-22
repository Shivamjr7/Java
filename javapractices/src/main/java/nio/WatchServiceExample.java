package nio;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.List;

/**
 * Example of how we can use watch service to listen to all events going on in a directory
 */
public class WatchServiceExample {

    public static void main(String[] args) throws IOException , InterruptedException {


        Path path = Paths.get(URI.create("file:///Users/sjari/watchservice"));

        FileSystem fs = path.getFileSystem();

        WatchService service = fs.newWatchService();
        WatchKey key = path.register(service,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        //if dir is deleted key becomes invalid
        while(key.isValid())
        {
            //this is a blocking method
            //As soon as events available this method will return and will be able to execute some code
           WatchKey key2 =  service.take();

         List<WatchEvent<?>> events =  key2.pollEvents();

         for(WatchEvent<?> event :events)
         {
             //if too many events are generated than our system can handle
             if(event.kind()==StandardWatchEventKinds.OVERFLOW)
             {
                continue;
             }
             else if(event.kind() == StandardWatchEventKinds.ENTRY_CREATE)
             {
                 Path path1 = (Path) event.context();
                 System.out.println("File creation : "+path1+" - "+Files.probeContentType(path1));
             }
             else if(event.kind() == StandardWatchEventKinds.ENTRY_DELETE)
             {
                 Path path1 = (Path) event.context();
                 System.out.println("File deleted : "+path1+" - "+Files.probeContentType(path1));
             }
             else if(event.kind() == StandardWatchEventKinds.ENTRY_MODIFY)
             {
                 Path path1 = (Path) event.context();
                 System.out.println("File modified : "+path1+" - "+Files.probeContentType(path1));
             }
         }
         //reset the key otherwise we would not get more events
         key2.reset();
        }
        System.out.println("key is invalid : Please check if your directory exists");

    }
}
