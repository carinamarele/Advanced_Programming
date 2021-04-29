import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Clasa pentru creerea conexiunii cu clientul</p>
 */
public class NetworkServer {
    public static final int PORT=3761;
    private static List<ClientThread> clients=new ArrayList<>();
    public NetworkServer() throws IOException{
        ServerSocket socketServer =null;
        try{
            socketServer=new ServerSocket(PORT);
            while(true){
                System.out.println("Server is waiting for client..");
                Socket socket=socketServer.accept();// ascult clientul
                new ClientThread(socket).start();
            }
        } catch (IOException exception){
            System.out.println("Upsi! You've done something wrong.."+exception);
        } finally {
            socketServer.close();;
        }
    }
    public static List<ClientThread>getClients(){
        return clients;
    }
}
