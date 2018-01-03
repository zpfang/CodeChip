package cc.zpfang.nio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Description:
 * Created by fangzp on 2017-08-21.
 */
public class SocketDemo {

    public void start(String host, int port){
        Socket socket = new Socket();


        try {
            String path = "";
            SocketAddress remote = new InetSocketAddress(host, port);
            socket.setSoTimeout(50000);
            socket.connect(remote);

            PrintWriter writer = getWriter(socket);
            writer.write(HttpUtil.compositeRequest(host, path));
            System.out.println(HttpUtil.compositeRequest(host, path));
            writer.flush();

            String msg;
            BufferedReader reader = getReader(socket);
            while ((msg = reader.readLine()) != null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(in));
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter(new OutputStreamWriter(out));
    }

    public static void main(String[] args) {
        new SocketDemo().start("www.baidu.com", 80);
    }
}
