package com.example.doremi;

import com.example.doremi.controller.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                String commands[] = sc.nextLine().split(" ");

                Controller.route(commands);
            }
            sc.close();
        } catch (IOException e) {
        }
    }
}
