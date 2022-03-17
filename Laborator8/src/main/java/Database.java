
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    public Connection connection;

//ma conectez la baza de date oracle
    private Database() throws SQLException, FileNotFoundException{
        OracleDataSource ods=new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
        ods.setUser("student");
        ods.setPassword("STUDENT");

        connection=ods.getConnection();
        ScriptRunner sr =new ScriptRunner(connection);

        Reader reader=new BufferedReader(new FileReader("E:\\Labor_8\\src\\main\\resources\\database.sql"));

        sr.runScript(reader);
    }
//iau o instanta a bazei de date
    public static Database getInstance()  throws SQLException,FileNotFoundException{
        if(instance==null)
            instance=new Database();
        return instance;
    }

    public static void setInstance(Database instance) {
        Database.instance = instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
