package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Employee {
    String name;
    String family;
    String work;
    int age;
    int id;
    int mellicode;
    double salary;

    public Employee(String nextLine, String nextLine1, String nextLine2, int nextInt, int nextInt1, double nextDouble, int nextInt2) {
    }

    //    public Employee(String name, String faName, String duty, int id, int idMeli, double salary, int age) {
//        this.name = name;
//        this.faName = faName;
//        this.duty = duty;
//        this.age = age;
//        this.id = id;
//        this.idMeli = idMeli;
//        this.salary = salary;
//    }
    public  void add(){
        try {

            Connection connection =
                    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "haniyeh", "myjava123");
            PreparedStatement insert =
                    connection.prepareStatement("insert into Employee (name,family,work,id,mellocode,salary,age) values (?,?,?,?,?,?,?)");
            insert.setString(1, name);
            insert.setString(2, family);
            insert.setString(3, work);
            insert.setInt(4, id);
            insert.setInt(5, mellicode);
            insert.setDouble(6,salary);
            insert.setInt(7, age);
            insert.executeUpdate();
            insert.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}