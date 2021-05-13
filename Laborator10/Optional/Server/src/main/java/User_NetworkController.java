import org.apache.ibatis.jdbc.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_NetworkController implements User_NetworkDAO{
    Database database;
    public int id_logat=0;
    public User_NetworkController(Database database){ this.database=database;}

    //adaugam in tabela user_network un nou utilizator
    @Override
    public void create(int id_user, String name, int nr_friends) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("insert into user_network (id_user,name,logged) values (?,?,?)");
            statement.setInt(1, id_user);
            statement.setString(2, name);
            statement.setInt(3,nr_friends);
            statement.execute();
            System.out.println("User saved");
            statement.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
//verificam daca este logat
    @Override
    public int getLogged(String name) {
        int id=0;
        try {
            PreparedStatement statement = database.connection.prepareStatement("select logged from user_network where name=?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id=resultSet.getInt("logged");
            }
            resultSet.close();
            statement.close();

        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return id;
    }
//retinem id_userul pentru utilizatorul cu numele name
    @Override
    public int findByName(String name,String command)  throws NullPointerException {
        List<User_Network> users = new ArrayList<>();
        User_Network userNetwork;
        try {
            String response = null;
            PreparedStatement statement = database.connection.prepareStatement("select * from user_network where name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id_logat=resultSet.getInt(1);
                userNetwork= new User_Network(resultSet.getInt(1),name, resultSet.getInt(3));
                users.add(userNetwork);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        if (users.size() == 0) return 0;
        else
            return id_logat;
    }


//verificam existenta in db
    @Override
    public int getID() throws NullPointerException {
        int id=0;
        try {
            PreparedStatement statement = database.connection.prepareStatement("select count(*) as total from user_network");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id=resultSet.getInt("total");
            }
            resultSet.close();
            statement.close();

        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return id;
    }
//returneaza 1 daca exista, 0 daca nu exista in baza de date
    @Override
    public int verifyExistance(String name) {
      int ok=0;
        try {
            PreparedStatement statement = database.connection.prepareStatement("select count(*) as total from user_network where name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if(resultSet.getInt("total")!=0) ok=1;
            }
            resultSet.close();
            statement.close();

        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return ok;
    }
//cand se deconecteaza un client, se modifica in baza de date pentru a ne putea conecta din nou printr-un alt client
    @Override
    public void updateLogged(String name,int ok) {
        try{
            PreparedStatement statement=database.connection.prepareStatement("update user_network set logged=? where name=?");
            statement.setInt(1,ok);
            statement.setString(2,name);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getId_logat() {
        return id_logat;
    }

    public void setId_logat(int id_logat) {
        this.id_logat = id_logat;
    }
}
