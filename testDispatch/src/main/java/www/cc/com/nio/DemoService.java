/**
 * @author Administrator
 * @data 2019年1月23日上午11:21:17
 */
package www.cc.com.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author lc
 * @data 2019年1月23日上午11:21:17
 */
public class DemoService extends Thread {
    private ServerSocket serverSocket;
    public int getPort() {
        return serverSocket.getLocalPort();
    }
    
    /* (非 Javadoc) 
    * <p>Title: run</p> 
    * <p>Description: </p>  
    * @see java.lang.Thread#run() 
    */
    @Override
    public void run() {
        try {
             serverSocket = new ServerSocket(0);
             while (true) {
                 Socket socket = serverSocket.accept();
                 RequestHandler requestHandler = new RequestHandler(socket);
                 requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        DemoService demoService = new DemoService();
        demoService.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(),demoService.getPort());){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s->System.out.println(s));
        }
        
    }
    
    
    class RequestHandler extends Thread{
        private Socket socket;

        /** 
        * @Description: TODO
        * @param @param socket    
        * @throws 
        */
        public RequestHandler(Socket socket) {
            this.socket = socket;
        }
        
        /* (非 Javadoc) 
        * <p>Title: run</p> 
        * <p>Description: </p>  
        * @see java.lang.Thread#run() 
        */
        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(socket.getOutputStream());){
                out.println("hello world!");
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
    
    
}
