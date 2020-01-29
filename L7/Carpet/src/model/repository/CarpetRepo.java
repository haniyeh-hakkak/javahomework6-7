package model.repository;

import model.entity.CarpetEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarpetRepo implements AutoCloseable{
        private Connection connection;
        private PreparedStatement preparedStatement;

        public CarpetRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "haniyeh", "myjava123");
        connection.setAutoCommit (false);

    }

    public void insert(CarpetEnt carpetEnt) throws Exception{
        preparedStatement=connection.prepareStatement ("INSERT INTO carpet(id, model, tarakom, shaane,price) VALUES (?,?,?,?,?)");
        preparedStatement.setLong (1,carpetEnt.getId());
        preparedStatement.setString (2,carpetEnt.getModel());
        preparedStatement.setInt (3,carpetEnt.getTarakom());
        preparedStatement.setInt (4,carpetEnt.getShaane());
        preparedStatement.setInt (5,carpetEnt.getPrice());

        preparedStatement.executeUpdate ();
    }
    public void update (CarpetEnt carpetEnt) throws Exception{
        preparedStatement=connection.prepareStatement ("UPDATE carpet SET model =?, tarakom=?,shaane=?,price=? where id=? ");
        preparedStatement.setString (1,carpetEnt.getModel ());
        preparedStatement.setInt (2,carpetEnt.getTarakom ());
        preparedStatement.setInt (3,carpetEnt.getShaane ());
        preparedStatement.setInt (3,carpetEnt.getPrice ());
        preparedStatement.setLong (4,carpetEnt.getId ());
        preparedStatement.executeUpdate ();
    }
    public void delete(long id) throws Exception{
        preparedStatement=connection.prepareStatement ("DELETE FROM carpet WHERE id=?");
        preparedStatement.setLong (1,id);
        preparedStatement.executeUpdate ();
    }

    public List<CarpetEnt> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM carpet");
                ResultSet resultSet=preparedStatement.executeQuery ();
        List<CarpetEnt> carpetEntList=new ArrayList<>();
        while (resultSet.next ()){
            CarpetEnt carpetEnt=new CarpetEnt();
            carpetEnt.setId (resultSet.getLong ("id"));
            carpetEnt.setModel (resultSet.getString ("model"));
            carpetEnt.setTarakom (resultSet.getInt ("tarakom"));
            carpetEnt.setShaane (resultSet.getInt ("shaane"));
            carpetEnt.setPrice (resultSet.getInt ("price"));
            carpetEntList.add (carpetEnt);
        }
        return carpetEntList;
    }
    public void commit() throws Exception{
            connection.commit ();
    }
    public void rollback() throws Exception{
        connection.rollback ();
    }
    public void close() throws Exception{
        preparedStatement.close ();
        connection.close ();
    }
}
