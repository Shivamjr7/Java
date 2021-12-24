package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TryWithResources {


    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("Hello this is try with resources");


        //Filechannel implements auto closable  so can be used in try with resources
        // channel will be closed

        //fliping so it reads from 0 posn to write to channel
        charBuffer.flip();

        try (FileChannel channel = FileChannel.open(Paths.get("/Users/sjari/nio/file5.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buf = StandardCharsets.UTF_8.encode(charBuffer);
            channel.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
