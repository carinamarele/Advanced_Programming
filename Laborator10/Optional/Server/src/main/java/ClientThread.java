import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private int serverIsStopped = 0;//serverul este pornit
    private Socket socket = null;
    private List<ClientThread> clients = new ArrayList<>();

    public ClientThread(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());

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

                    if (isLoggedIn != 0)
                    //daca este logat si dam exit ne vom deloga de la contul respectiv
                    {
                        Database database = null;
                        try {
                            database = Database.getInstance();
                            User_NetworkController user_networkController = new User_NetworkController(database);

                            user_networkController.updateLogged(person, 0);

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        isLoggedIn=0;
                    }
                    response = "Client stopped";
                    out.println(response);//Trimite catre client raspunsul la comanda
                    out.flush();//Sterge ce avea in buffer
                    //System.exit(1);//Inchide programul
                    serverIsStopped = 0; // retinem ca s-a oprit serverul

                    this.socket.close();//Inchide socketul

                } else if (request.equals("exit")) {


                    response = "Server exited";
                    out.println(response);
                    out.flush();
                    System.exit(1);
                    this.socket.close();

                } else if (request.equals("login") && isLoggedIn == 0) {


                    Database database = null;
                    try {
                        database = Database.getInstance();
                        User_NetworkController user_networkController = new User_NetworkController(database);
                        if (user_networkController.getLogged(person) == 0) {

                            int result = user_networkController.findByName(person, request);

                            if (result == 0) {
                                response = "The account you're trying to get into doesn't exists! Try register or verify the username";
                                out.println(response);
                                out.flush();
                            } else {
                                isLoggedIn = result;
                                user_networkController.updateLogged(person, 1);
                                response = "Congrats! You succesfully logged in!";
                                out.println(response);
                                out.flush();
                            }
                        } else {
                            response = "Someone is already in this account";
                            out.println(response);
                            out.flush();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                } else if (request.equals("login") && isLoggedIn != 0) {

                    response = "You already are connected to an account! Try another command";
                    out.println(response);
                    out.flush();
                } else if (request.equals("register") && isLoggedIn == 0) {


                    Database database = null;
                    try {
                        database = Database.getInstance();
                        User_NetworkController user_networkController = new User_NetworkController(database);

                        int result1 = user_networkController.getID();
                        if (user_networkController.verifyExistance(person) == 0) {

                            user_networkController.create(result1 + 1, person, 0);
                            response = "Congrats! You created your account!";
                            out.println(response);
                            out.flush();
                        } else {
                            response = "This account already exists! Try another username or login in!";
                            out.println(response);
                            out.flush();
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                } else if (request.equals("register") && isLoggedIn != 0) {
                    response = "You can't create another account when you've logged into another account!!";
                    out.println(response);
                    out.flush();
                } else if (request.equals("send") && isLoggedIn != 0) {

                    Database database = null;
                    try {
                        database = Database.getInstance();
                        MessagesController messagesController = new MessagesController(database);

                        messagesController.send(isLoggedIn, person);
                        response = "Message sent to all friends";
                        out.println(response);
                        out.flush();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                } else if (request.equals("friend")) {
                    int numberFriends = 0;
                    //in elements[1]---elements[lenght-1] avem numele persoanelor cu care vrem sa ne imprietenim
                    for (int i = 1; i < elements.length; i++) {
                        Database database = null;
                        try {
                            database = Database.getInstance();
                            RelationController relationController = new RelationController(database);

                            //numaram cate prietenii va avea, deoarece exista posibilitatea ca unele persoane sa nu existe sau sa fie deja prietene
                            numberFriends = numberFriends + relationController.friends(isLoggedIn, elements[i]);

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    response = "You've created " + numberFriends + " new friendships!";
                    out.println(response);
                    out.flush();


                } else if (request.equals("read") && isLoggedIn != 0) {

                    Database database = null;
                    try {
                        database = Database.getInstance();
                        MessagesController messagesController = new MessagesController(database);
                        response = messagesController.read(isLoggedIn);
                        if (messagesController.getNumberMessages() == 0)
                            response = "You don't have any messages from friends!";
                        out.println(response);
                        out.flush();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                } else {

                    // daca primim alta comanda decat cele stabilite
                    response = "Server received an invalid command..";
                    out.println(response);
                    out.flush();
                    System.out.println(response);
                    //this.socket.close();
                }
            }
        } catch (IOException exception) {

            System.out.println("ERROR, you've done something wrong: " + exception);
        }
    }


}
