public interface RelationDAO {
    void insert(int id_user,int id_friend);
    int friends(int id_user,String name);
    int findFriendById(int id_user);
    int findFriendByName(String name);
}
