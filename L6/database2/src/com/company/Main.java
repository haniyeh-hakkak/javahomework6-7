package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("name  family   work  id    mellocode    salary   age");
        Employee employee = new Employee(input.nextLine(),input.nextLine(),input.nextLine(),input.nextInt(),input.nextInt(), input.nextDouble(), input.nextInt());
        employee.add();
    }
}
