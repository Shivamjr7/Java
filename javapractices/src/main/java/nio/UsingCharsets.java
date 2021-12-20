package nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UsingCharsets {


    public static void main(String[] args) throws IOException {

        Charset utf8 = StandardCharsets.UTF_8;
        Charset latin = StandardCharsets.ISO_8859_1;


        String word = "Today is a good day to do some nio operations";


        CharBuffer buffer = CharBuffer.allocate(1024 * 1024);
        buffer.put(word);
        buffer.flip();
        ByteBuffer byteBuffer = utf8.encode(buffer);

        //write to file
        Path path = Paths.get("/Users/sjari/nio/file2.txt");

        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            channel.write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("File size : " + Files.size(path));

        //clear the buffer since we are going to read in the same buffer

        byteBuffer.clear();

        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
            channel.read(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }


        byteBuffer.flip();


        CharBuffer charBuffer = utf8.decode(byteBuffer);

        String res = new String (charBuffer.array());
        System.out.println(res);
    }

}
