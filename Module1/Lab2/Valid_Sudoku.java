package Module1.Lab2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Valid_Sudoku {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String inputBoard = "";
        for (int i = 0; i < size; i++) {
            inputBoard += scanner.nextLine();
        }

        int[][] board = parseInputBoard(inputBoard, size);

        System.out.println(validateSudoku(board) ? "YES" : "NO");

        scanner.close();
    }

    private static boolean validateSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubBox(board, i / 3 * 3, i % 3 * 3)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidRow(int[][] board, int row) {
        Set<Integer> seen = new HashSet<>();
        for (int num : board[row]) {
            if (num != 0 && !seen.add(num)) {
                return false; 
            }
        }
        return true;
    }

    private static boolean isValidColumn(int[][] board, int col) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            int num = board[i][col];
            if (num != 0 && !seen.add(num)) {
                return false; 
            }
        }
        return true;
    }

    private static boolean isValidSubBox(int[][] board, int startRow, int startCol) {
        Set<Integer> seen = new HashSet<>();
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                int num = board[i][j];
                if (num != 0 && !seen.add(num)) {
                    return false; 
                }
            }
        }
        return true;
    }

    private static int[][] parseInputBoard(String inputBoard, int size) {
        int[][] board = new int[size][size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char cellChar = inputBoard.charAt(index++);
                if (cellChar != '.') {
                    board[i][j] = Character.getNumericValue(cellChar);
                }
            }
        }
        return board;
    }
}