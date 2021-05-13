public interface User_NetworkDAO {
 void create(int id_user, String name, int nr_friends);
 int getLogged(String name);
 int findByName(String name,String command);
 int getID();
 int verifyExistance(String name);
 void updateLogged(String name,int ok);
}
