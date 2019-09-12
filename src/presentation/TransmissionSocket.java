package presentation;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransmissionSocket {

    String hostName;
    int portNumber;

    Socket socket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    BufferedReader stdIn = null;


    public void commencerDiscussion(String hostName, int portNumber){
        Socket socket = null;
        try{

            socket = new Socket(hostName, portNumber);

            out =
                    new PrintWriter(socket.getOutputStream(), true);
            in =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));

            /*String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }*/

        }catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            //Si une exception de ce type est levée
            //c'est que le port n'est pas ouvert ou n'est pas autorisé
        }
        /*finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    socket = null;
                }
            }
        }*/
    }

    public void send(String message){
        System.out.println(message);
        out.println(message);
    }

    public TransmissionSocket(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }


}
