package ru.job4j.array;

import java.util.Arrays;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int cell = 0; cell < board.length; cell++) {
            if (board[cell][cell] == 'X') {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][cell] == board[cell][cell] || board[cell][i] == board[cell][cell]) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
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
        System.out.println();
        char[][] notWin2 = {
                {'_', '_', '_', 'X', '_'},
                {'_', '_', '_', 'X', '_'},
                {'_', '_', '_', 'X', '_'},
                {'_', '_', '_', 'X', '_'},
                {'_', '_', '_', '_', 'X'},
        };
        boolean lose2 = isWin(notWin2);
        System.out.println("A board has a winner : " + lose2);
    }
}