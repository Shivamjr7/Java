package nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelExample {


    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.putInt(10);
        buffer.putInt(20);
        Path path = Paths.get("/Users/sjari/nio/File.txt");

        //Writing to file
        try (java.nio.channels.FileChannel channel = java.nio.channels.FileChannel.open(
                path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            buffer.flip();

            channel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Reading the file

        try (java.nio.channels.FileChannel channel = java.nio.channels.FileChannel.open(
                path, StandardOpenOption.CREATE, StandardOpenOption.READ)) {

            buffer.flip();
            IntBuffer buffer1 = buffer.asIntBuffer();
            while (buffer1.hasRemaining()) {
                System.out.println("contents of file : " + buffer1.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
