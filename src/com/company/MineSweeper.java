package com.company;

import java.util.Scanner;

public class MineSweeper {
    int row;
    int col;
    int size=row*col;
    String [][] mineBoard;
    int [][] gameBoard;

    public MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.mineBoard=new String[this.row][this.col];
        this.gameBoard=new int[this.row][this.col];
    }
     void run(){
         createGameTable(mineBoard);
         adminBoard(mineBoard);
         playGame();

    }

    private void playGame() {
        int counter=0;
        Scanner input = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("Mayin Tarlası Oyununa Hoş Geldiniz!");
        while(true) {
            System.out.println("-----------------------------------");
            playerBoard(gameBoard);
            System.out.println("Enter row location:");
            int rowNum = input.nextInt();
            System.out.println("Enter column location:");
            int colNum = input.nextInt();

            if(rowNum<0 || rowNum>row-1){
                System.out.println("Invalid coordinate");
                continue;

            }
            else if(colNum<0 || colNum>col-1){
                System.out.println("Invalid coordinate");
                continue;

            }

           else if(mineBoard[rowNum][colNum]=="* "){
                System.out.println("yandın");
                break;
           }
           else {
                checkMineNumber(rowNum,colNum);
                counter++;
                if(counter==((row*col)-(row*col/4))){
                    System.out.println("You won");
                    break;
                }
           }
        }
    }

    public void checkMineNumber(int rowNumber,int columnNumber) {
        gameBoard[rowNumber][columnNumber]++;
        if(mineBoard[rowNumber][columnNumber]=="- "){
            if((columnNumber<col-1) && (mineBoard[rowNumber][columnNumber+1]=="* ")){
                gameBoard[rowNumber][columnNumber]++;
                System.out.println(gameBoard[rowNumber][columnNumber]++);
            }
            if((rowNumber<row-1) && (mineBoard[rowNumber+1][columnNumber]=="* ")){
                gameBoard[rowNumber][columnNumber]++;
            }
            if((rowNumber>0) && (mineBoard[rowNumber-1][columnNumber]=="* ")){
                gameBoard[rowNumber][columnNumber]++;
            }
            if((columnNumber>0) && (mineBoard[rowNumber][columnNumber-1]=="* ")){
                gameBoard[rowNumber][columnNumber]++;
            }
        }
    }


    /**
     * Game map
     * */

    void createGameTable(String[][] mineBoard){
        System.out.println("Mayın Tarlası Düzeni:");
        int mineNumber=(this.row*this.col)/4;
         //mine numbers according to game table size
        for(int i =0;i <mineBoard.length;i++){
            for(int j=0;j<mineBoard[i].length;j++){
                int random= (int) (Math.random()*100);  //if random smaller than 50, adds mine on the game table
                if(random<=50 && mineNumber!=0 ){
                    mineBoard[i][j]="* ";
                    mineNumber--;
                }
                else {
                    mineBoard[i][j]="- ";
                }
            }

        }


        }


    void adminBoard(String[][] mineBoard){
        for(int i=0;i<mineBoard.length;i++){
            for(int j=0;j<mineBoard[i].length;j++){
                System.out.print(mineBoard[i][j]);
            }
            System.out.println();
        }
    }

    void playerBoard(int[][] gameBoard){
        for(int i=0;i<gameBoard.length;i++){
            for(int j=0;j<gameBoard[i].length;j++){

                if(gameBoard[i][j]>=0){
                    System.out.print(gameBoard[i][j]);
                }
                else{
                    System.out.print("- ");
                }

            }
            System.out.println();
        }
    }



    }


