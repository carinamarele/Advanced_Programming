import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <p>Comenzile pe care le poate utiliza clientul</p>
 * <p>Stabilesc acelasi port ca serverul si iau adresa IPV4 pentru a putea face conexiunea</p>
 * <p> Prin out.printl(request) trimit catre server comanda pe care vrea clientul sa o efectueze</p>
 * <p> In response preiau ce imi trimite serverul raspuns si dupa il afisez</p>
 *
 * @author Carina
 */
public class Commands {
    public static void main(String[] args) throws IOException {
        String serverAdress = "192.168.0.100";
        int PORT = 3761;
        System.out.println("Welcome! You have the next commands you can use:");
        System.out.println("login      [nume]");
        System.out.println("register   [nume]");
        System.out.println("friend     [prieten1] [prieten2] ..");
        System.out.println("message    [to_who]");
        System.out.println("stop");
        System.out.println("exit");
        System.out.println("Type your next command:");
        System.out.println("");

        try (
                Socket socket = new Socket(serverAdress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            while (!socket.isClosed()) {
                BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader serverOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = clientInput.readLine();
                String[] elements = request.split(" ");

                String response;
                if (elements[0].equals("exit")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                    socket.close();
                } else if (elements[0].equals("stop")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                    socket.close();
                } else if (elements[0].equals("login")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else if (elements[0].equals("register")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else if (elements[0].equals("friend")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else if (elements[0].equals("message")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                }
            }
        } catch (UnknownHostException exception) {
            System.err.println("No server is listening.." + exception);
        }
    }
}


