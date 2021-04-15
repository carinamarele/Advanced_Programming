package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class GenreController {
        private Connection con;

        public GenreController(Connection con) {
            this.con = con;
        }

        public void create(int id_genre, String name) {
            try {
                PreparedStatement pstm = con.prepareStatement("Insert into genres (id_genre, name) values(?,?)");
                pstm.setInt(1, id_genre);
                pstm.setString(2, name);
                pstm.execute();
                pstm.close();
            } catch (SQLException e) {
                System.out.println("Nu s-a putut realiza adaugarea unui nou artist");
                e.printStackTrace();
            }
        }

        public String getNameById(int id_genre) {
            String genreName = new String();
            try {
                PreparedStatement pstm = con.prepareStatement("Select * from genre where id_genre = ?");
                pstm.setInt(1, id_genre);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    genreName = rs.getString("name");
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println("Nu s-a putut gasi artistul");
                e.printStackTrace();
            }
            return genreName;
        }

        public void findByName(String name) {
            try {
                PreparedStatement pstm = con.prepareStatement("Select * from genre where name = ?");
                pstm.setString(1, name);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    String genreName = rs.getString("name");
                    int id_genre = rs.getInt("id_genre");
                    System.out.println("Genul" + genreName + " cu id-ul:" + id_genre);
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println("Nu s-a putut gasi artistul");
                e.printStackTrace();
            }
        }

        public int getMinId() {
            int minId = 1;
            try {
                PreparedStatement pstm = con.prepareStatement("Select min(id_genre) from genres");
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    minId = rs.getInt(1);
                }

                rs.close();

            } catch (SQLException e) {
                System.out.println("Nu s-a putut realiza adaugarea unui nou gen");
                e.printStackTrace();
            }
            return minId;
        }


        public int getMaxId() {
            int minId = 1;
            try {
                PreparedStatement pstm = con.prepareStatement("Select max(id_genre) from genres");
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    minId = rs.getInt(1);
                }

                rs.close();

            } catch (SQLException e) {
                System.out.println("Nu s-a putut realiza adaugarea unui nou gen");
                e.printStackTrace();
            }
            return minId;
        }
    }

