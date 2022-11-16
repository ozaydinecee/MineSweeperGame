package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Please enter game row number");
        int row=input.nextInt();
        System.out.println("Please enter game column number");
        int col=input.nextInt();

        MineSweeper game =new MineSweeper(row,col);
        game.run();



    }
}
