package ru.job4j.array;

import java.util.Arrays;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int cell = 0; cell < board.length; cell++) {
            if (board[cell][cell] == 'X') {
                if (board[0][cell] == 'X' && board[1][cell] == 'X' && board[2][cell] == 'X' && board[3][cell] == 'X' && board[4][cell] == 'X') {
                    result = true;
                } else if (board[cell][0] == 'X' && board[cell][1] == 'X' && board[cell][2] == 'X' && board[cell][3] == 'X' && board[cell][4] == 'X') {
                    result = true;
                }
            }
            System.out.println(Arrays.toString(board[cell]));
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}