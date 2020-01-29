package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("username   password   email  age    education");
        User user = new User(input.nextLine(),input.nextLine(),input.nextLine(),input.nextInt(),input.nextLine());
        user.add();
    }

}
