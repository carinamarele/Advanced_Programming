import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private int serverIsStopped = 0;//serverul este pornit
    private Socket socket = null;
    private List<Client> clientiAplicatie = new ArrayList<>();
    private List<ClientThread> clients = new ArrayList<>();

    public ClientThread(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //voi adauga in lista de clienti cateva persoane pentru a proba daca loginul functioneaza

            Client newClient = new Client("Andrada");
            clientiAplicatie.add(newClient);
            //folosesc aceeasi variabila suprascriind-o
            newClient = new Client("Ilie");
            clientiAplicatie.add(newClient);
            newClient = new Client("Andrei");
            clientiAplicatie.add(newClient);
            newClient = new Client("Carina");
            clientiAplicatie.add(newClient);
            newClient = new Client("Bogdan");
            clientiAplicatie.add(newClient);
            int isLoggedIn = 0;// variabila pentru a verifica daca o persoana este logata

            while (!socket.isClosed()) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //verific daca serverul este oprit pentru a prelua clientii
                if (serverIsStopped == 0) {

                    this.clients = NetworkServer.getClients();

                    clients.add(this);//retin clientii

                } else if (serverIsStopped == 1 && clients.size() == 0) {//Daca serverul este oprit si nu mai am clienti inchid socketul
                    this.socket.close();
                }

                //citesc comanda trimisa de client
                String request = input.readLine();
                String response = null;//un string in care retin raspunsul pentru comanda trimisa de client

                String[] elements = null;//elements si person sunt folosite pentru a prelua niste nume dintr-o lista
                String person = null;


                if (request != null) {

                    //acum voi incerca sa despart comanda de numele utilizat folosind  split
                    elements = request.split(" ");
                    //cand imi gaseste spatia,delimitatorul meu va separa cuvintele
                    //in elements[0]=comanda si elements[1]=numele,etc

                    request = elements[0];//retin comanda pentru a putea vedea ce trimite clientul

                    if (elements.length > 1) {
                        person = elements[1];
                    }
                }

                System.out.println("Got from the client the request.. " + request);

                if (request.equals("stop")) {

                    response = "Server stopped";

                    out.println(response);//Trimite catre client raspunsul la comanda

                    out.flush();//Sterge ce avea in buffer

                    System.exit(1);//Inchide programul

                    serverIsStopped = 1; // retinem ca s-a oprit serverul

                    this.socket.close();//Inchide socketul

                } else if (request.equals("exit")) {

                    if (isLoggedIn != 0)
                        clientiAplicatie.get(isLoggedIn).setLogat(0); //daca este logat si dam exit ne vom deloga de la contul respectiv

                    response = "Server exited";

                    out.println(response);

                    out.flush();

                    System.exit(1);

                    this.socket.close();

                } else if (request.equals("login") && isLoggedIn == 0) {

                    for (int i = 0; i < clientiAplicatie.size(); i++) {

                        // verific daca exista numele in lista mea de conturi si daca il/o gasesc, ii retin pozitia
                        if (clientiAplicatie.get(i).getName().equals(person)) {
                            isLoggedIn = i;
                        }
                    }

                    if (isLoggedIn == 0) {

                        //Daca ramane 0 inseamna ca nu am gasit numele deci nu exista contul
                        response = "The account you're trying to get into doesn't exists! Try register or verify the username";

                        out.println(response);

                        out.flush();
                    } else {

                        //setam ca s-a logat si trimitem mesajul
                        clientiAplicatie.get(isLoggedIn).setLogat(1);

                        response = "Congrats! You succesfully logged in!";

                        out.println(response);

                        out.flush();
                    }
                } else if (request.equals("login") && isLoggedIn != 0) {

                    response = "You already are connected to an account! Try another comand";

                    out.println(response);

                    out.flush();
                } else if (request.equals("register")) {

                    response = "Functionality for 'register' will be done soon..";

                    out.println(response);

                    out.flush();

                } else if (request.equals("message")) {

                    response = "Functionality for 'message' will be done soon..";

                    out.println(response);

                    out.flush();

                } else if (request.equals("friend")) {

                    response = "Functionality for 'friend' will be done soon..";

                    out.println(response);

                    out.flush();

                } else {

                    // daca primim alta comanda decat cele stabilite
                    response = "Server received an invalid command..";

                    out.println(response);

                    out.flush();

                    System.out.println(response);

                    this.socket.close();
                }
            }
        } catch (IOException exception) {

            System.out.println("ERROR, you've done something wrong: " + exception);
        }
    }


}
