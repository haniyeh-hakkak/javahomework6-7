package model.repository;

import model.entity.CarEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarRepo implements AutoCloseable{
        private Connection connection;
        private PreparedStatement preparedStatement;

        public CarRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "haniyeh", "myjava123");
        connection.setAutoCommit (false);

    }

    public void insert(CarEnt carEnt) throws Exception{
        preparedStatement=connection.prepareStatement ("INSERT INTO car(id, name, color, price, gearbox ) VALUES (?,?,?,?,?)");
        preparedStatement.setLong (1,carEnt.getId());
        preparedStatement.setString (2,carEnt.getName());
        preparedStatement.setString (3,carEnt.getColor());
        preparedStatement.setLong (4,carEnt.getPrice());
        preparedStatement.setString (5,carEnt.getGearbox());

        preparedStatement.executeUpdate ();
    }
    public void update (CarEnt carEnt) throws Exception{
        preparedStatement=connection.prepareStatement ("UPDATE car SET name =?, color=?,price=?,gearbox=? where id=? ");
        preparedStatement.setString (1,carEnt.getName ());
        preparedStatement.setString (2,carEnt.getColor ());
        preparedStatement.setInt (3,carEnt.getPrice ());
        preparedStatement.setString (4,carEnt.getGearbox ());
        preparedStatement.setLong (5,carEnt.getId ());
        preparedStatement.executeUpdate ();
    }
    public void delete(long id) throws Exception{
        preparedStatement=connection.prepareStatement ("DELETE FROM car WHERE id=?");
        preparedStatement.setLong (1,id);
        preparedStatement.executeUpdate ();
    }

    public List<CarEnt> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM car");
                ResultSet resultSet=preparedStatement.executeQuery ();
        List<CarEnt> carEntList=new ArrayList<>();
        while (resultSet.next ()){
            CarEnt carEnt=new CarEnt();
            carEnt.setId (resultSet.getLong ("id"));
            carEnt.setName (resultSet.getString ("name"));
            carEnt.setColor (resultSet.getString ("color"));
            carEnt.setprice (resultSet.getInt ("price"));
            carEnt.setGearbox(resultSet.getString ("gearbox"));
            carEntList.add (carEnt);
        }
        return carEntList;
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
