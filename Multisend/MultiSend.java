// Import some needed classes
import sun.net.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class MultiSend {
        public static void main(String[] args) throws Exception {
            // Which port should we send to
            Scanner inp = new Scanner(System.in);
            int port = 5000;
            // Which address
            String group = "224.0.0.3";
            // Which ttl
            int ttl = 1;

            // Create the socket but we don't bind it as we are only going to send data
            MulticastSocket s = new MulticastSocket(port);

            s.joinGroup(InetAddress.getByName(group));

            // Note that we don't have to join the multicast group if we are only
            // sending data and not receiving

                Runnable sendRunnable = new Runnable(){
                    public void run() {
                        try {
                            while(true) {
                                String input = inp.nextLine();
                                byte[] buf = input.getBytes();
                                DatagramPacket pack = new DatagramPacket(buf, buf.length,InetAddress.getByName(group), port);
                                s.send(pack);
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }   
                };

                Thread sendThread = new Thread(sendRunnable);
                sendThread.start();

                Runnable receiveRunnable = new Runnable(){
                    public void run() {
                        try {
                            while(true) {
                                byte buf[] = new byte[1024];
                                DatagramPacket pack = new DatagramPacket(buf, buf.length);
                                s.receive(pack);
                                // Finally, let us do something useful with the data we just received,
                                // like print it on stdout :-)
                                // System.out.println("Received data from: " + pack.getAddress().toString() +
                                //             ":" + pack.getPort() + " with length: " +
                                //             pack.getLength());
                                System.out.write(pack.getData(),0,pack.getLength());
                                System.out.println();
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }   
                };

                Thread receiveThread = new Thread(receiveRunnable);
                receiveThread.start();

            // Fill the buffer with some data
            // byte buf[] = new String("Akshay").getBytes();
            // // Create a DatagramPacket 
            // DatagramPacket pack = new DatagramPacket(buf, buf.length,
            // 					 InetAddress.getByName(group), port);
            // // Do a send. Note that send takes a byte for the ttl and not an int.
            // //s.send(pack,(byte)ttl);

            // s.send(pack);
            // s.setTimeToLive(100); 

            // And when we have finished sending data close the socket
        }
}
