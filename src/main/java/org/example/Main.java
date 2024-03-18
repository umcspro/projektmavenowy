package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Utworz haslo:");
        String hashed = Hasher.hashPassword(sc.nextLine());
        System.out.println(hashed);
        try {
            PrintWriter pw = new PrintWriter("./pass.txt");
            pw.println(hashed);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Scanner scfile = new Scanner(new File("./pass.txt"));
            System.out.println("Test, podaj swoje haslo:");
            if (Hasher.hashPassword(sc.nextLine()).equals(scfile.nextLine())){
                System.out.println("haslo poprawne!");
            }
            else{
                System.out.println("bledne haslo!");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}