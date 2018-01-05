package cc.zpfang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:
 * Created by fangzp on 2017-08-15.
 */
public class Client {
    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    public void start() throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("localhost", 6363));
        Selector selector = Selector.open();
        sc.register(selector, SelectionKey.OP_CONNECT);

        Scanner scanner = new Scanner(System.in);
        while (true){
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            System.out.println("keys=" + keys.size());
            Iterator<SelectionKey> keyIterable = keys.iterator();
            while (keyIterable.hasNext()){
                SelectionKey key = keyIterable.next();
                keyIterable.remove();
                if(key.isConnectable()){
                    sc.finishConnect();
                    sc.register(selector, SelectionKey.OP_WRITE);
                    System.out.println("server connected...");
                    break;
                }else if(key.isWritable()){
                    System.out.println("please input message:");
                    String message = scanner.nextLine();
                    writeBuffer.clear();
                    writeBuffer.put(message.getBytes());
                    writeBuffer.flip();
                    sc.write(writeBuffer);

                    int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
                    sc.register(selector, interestSet);
                    //sc.register(selector, SelectionKey.OP_WRITE);
                }else if(key.isReadable()){
                    System.out.println("receive message:");
                    SocketChannel client = (SocketChannel) key.channel();
                    readBuffer.clear();
                    int num = client.read(readBuffer);
                    System.out.println(new String(readBuffer.array(), 0, num));
                    sc.register(selector, SelectionKey.OP_WRITE);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Client().start();
    }
}
