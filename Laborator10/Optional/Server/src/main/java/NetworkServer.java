import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Clasa pentru creerea conexiunii cu clientul</p>
 */
public class NetworkServer {
    public static final int PORT=3764;
    Socket socket;
    private static List<ClientThread> clients=new ArrayList<>();
    public NetworkServer() throws IOException{
        ServerSocket socketServer =null;
        try{
            socketServer=new ServerSocket(PORT);
            socketServer.setSoTimeout(120000);//2 minute
            while(true){
                System.out.println("Server is waiting for client..");
                socket=socketServer.accept();// ascult clientul
                new ClientThread(socket).start();
            }
        } catch ( InterruptedIOException e ) {
            System.err.println( "Timed Out ( 2 minute )!");

        } catch (IOException exception){
            System.out.println("Upsi! You've done something wrong.."+exception);
        } finally {
            socketServer.close();
        }
    }
    public static List<ClientThread>getClients(){
        return clients;
    }
}
