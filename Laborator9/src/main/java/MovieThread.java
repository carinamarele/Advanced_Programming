
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieThread implements Runnable{
    private int id;

    public MovieThread(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private void displayMovies(int id) throws SQLException, PropertyVetoException {
        Connection connection = null;
        String selectSQL = "Select * from movies where id_movie = ?";
        PreparedStatement prepStmt = null;
        try {
            ComboPooledDataSource basicDS = ConnectionPool.getInstance().getComboPooledDataSource();
            connection = basicDS.getConnection();
            prepStmt = connection.prepareStatement(selectSQL);
            prepStmt.setInt(1, id);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                System.out.println("Id-ul : " + rs.getInt("id_movie") + " Titlu : "
                        + rs.getString("title") + " Release Date : " + rs.getString("release_date")+" Duration : "+rs.getInt("duration")+" Score : "+rs.getInt("score"));
            }
        } finally {
            if (prepStmt != null) {
                prepStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void run() {
        try {
            this.displayMovies(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}
