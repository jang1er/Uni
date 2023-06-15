package de.uulm.sp.oop.sokoban;

import de.uulm.sp.pvs.util.Sokoban;

import java.util.Scanner;

public class Main {


    public static void main ( String[] args){
        Sokoban game = new Sokoban();

        // setup game board
        char[][] board = new char[7][];
        board[0] = "#######".toCharArray();
        board[1] = "#.....#".toCharArray();
        board[2] = "#..$..#".toCharArray();
        board[3] = "#.$@$.#".toCharArray();
        board[4] = "#..$..#".toCharArray();
        board[5] = "#.....#".toCharArray();
        board[6] = "#######".toCharArray();

        Scanner input = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println(game.sokobanToString(board));
            System.out.println("Next move [n/e/s/w or x to exit]:");
            String move = input.next().toLowerCase();
            switch (move){
                case"n":
                    game.moveNorth(board);
                    break;
                case"e":
                    game.moveEast(board);
                    break;
                case "s":
                    game.moveSouth(board);
                    break;
                case "w":
                    game.moveWest(board);
                    break;
                default:
                    System.out.println("not a valid input :(");
            }
        }
    }

}
