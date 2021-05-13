import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagesController implements MessagesDAO{
    Database database;
    private int numberMessages=0;

    public MessagesController(Database database) {this.database=database; }
//trimiterea mesajelor, vom folosi functia insert pentru a adauga in tabela, intrucat in id_friend vom avea o lista de id uri
    @Override
    public void send(int id_user,String message) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("select id_friend from relation where id_user=?");
            statement.setInt(1, id_user);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())
            {
                insert(resultSet.getInt(1),message);
            }
            resultSet.close();
            //statement.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
//afisarea mesajelor pentru un utilizator
    @Override
    public String read(int id_user) {
        String response="";
        try {
            response="The messages for Id User "+id_user+" are: ";
            PreparedStatement statement = database.connection.prepareStatement("select messages from messages where id_user=?");
            statement.setInt(1, id_user);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                numberMessages++;
                response=response+resultSet.getString("messages")+" - ";
            }
            resultSet.close();
            statement.close();

        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return response;


    }
//functie pentru adaugarea unui mesaj in db catre prieteni, in acest tabel retin pentru fiecare persoana ce mesaje are
    @Override
    public void insert(int id_user,String message) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("insert into messages(id_user,messages) values (?,?)");
            statement.setInt(1, id_user);
            statement.setString(2, message);
            statement.execute();

            statement.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    public int getNumberMessages() {
        return numberMessages;
    }

    public void setNumberMessages(int numberMessages) {
        this.numberMessages = numberMessages;
    }
}
