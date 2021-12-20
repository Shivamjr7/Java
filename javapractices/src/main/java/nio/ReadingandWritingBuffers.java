package nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ReadingandWritingBuffers {


    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024*1024); // 1MB

        System.out.println("Writing to buffer ....");

        buffer.putInt(10);
        buffer.putInt(20);

        System.out.println("posn :"+ buffer.position());
        System.out.println("limit :"+ buffer.limit());


        System.out.println("Reading from buffer ....");
        //important to flip the buffer before we read
        buffer.flip();


        IntBuffer intBuffer = buffer.asIntBuffer();




        System.out.println("posn :"+ buffer.position());
        System.out.println("limit :"+ buffer.limit());

        int value = intBuffer.get();

        System.out.println("value from buffer :"+ value);


    }
}
