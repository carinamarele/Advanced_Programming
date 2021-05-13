import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelationController implements RelationDAO{
    Database database;
    int numberAppearences=0;
    public RelationController(Database database){ this.database=database;}

    //adaugarea unei noi relatii intre 2 oameni
    @Override
    public void insert(int id_user, int id_friend) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("insert into relation(id_user,id_friend) values (?,?)");
            statement.setInt(1, id_user);
            statement.setInt(2, id_friend);
            statement.execute();

            statement.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
//verificam daca numele exista in db si dupa verificam daca exista deja relatie intre cele 2 persoane, daca nu vom adauga cele 2 relatii user->friend, friend->user

    @Override
    public int friends(int id_user, String name) {
        int id = findFriendByName(name);
        int numberFriends=0;
        if (id != 0) {
            if(findFriendById(id)==0){
            numberFriends++;
            insert(id_user, id);
            insert(id, id_user);}
        }
        return numberFriends;
    }


//verificam cati prieteni are o persoana
    @Override
    public int findFriendById(int id_user) {
        int numberAppearences=0;
        try {
            PreparedStatement statement = database.connection.prepareStatement("select id_friend from relation where id_user=?");
            statement.setInt(1, id_user);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                numberAppearences++;

            }
            resultSet.close();
            statement.close();

        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return numberAppearences;
    }
//returneaza 0 daca nu exista, 1 daca exista in db
    @Override
    public int findFriendByName(String name) {
        int id=0;
        Relation userNetwork;
        try {
            PreparedStatement statement = database.connection.prepareStatement("select id_user from user_network where name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                numberAppearences++;
                id=resultSet.getInt("id_user");
            }
            resultSet.close();
            statement.close();
            if (numberAppearences == 0) return id;
            else
                return id;
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return id;
    }
}
