package com.example.geektrust; 

import java.io.*;
import java.util.*;

import com.example.geektrust.service.CommandRunner;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            CommandRunner commandRunner = CommandRunner.getInstance();
            while (sc.hasNextLine()) {
                commandRunner.runCommand(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
        }
    }
}
