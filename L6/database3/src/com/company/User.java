package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    String username;
    String password;
    String email;
    int age;
    String education;

    public User(String nextLine, String nextLine1, String nextLine2, int nextInt, String nextLine3) {
    }

    public void  add(){

        try {

            Connection connection =
                    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "parvar", "oracle123");
            PreparedStatement insret =
                    connection.prepareStatement("insert into InfUser (username,password,email,age,education) values (?,?,?,?,?)");
            insret.setString(1, this.username);
            insret.setString(2, this.password);
            insret.setString(3, this.email);
            insret.setInt(4, this.age);
            insret.setString(5, this.education);
            insret.executeUpdate();
            insret.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}