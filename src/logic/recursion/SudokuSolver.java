package logic.recursion;

import java.util.Arrays;

public class SudokuSolver {
    private static final int GRID_SIZE = 9;

    private final int[][] GRID_EXERCISE = {
            {1, 0, 0, 0, 0, 0, 0, 0, 6},
            {0, 0, 6, 0, 2, 0, 7, 0, 0},
            {7, 8, 9, 4, 5, 0, 1, 0, 3},

            {0, 0, 0, 8, 0, 7, 0, 0, 4},
            {0, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 9, 0, 0, 0, 4, 2, 0, 1},

            {3, 1, 2, 9, 7, 0, 0, 4, 0},
            {0, 4, 0, 0, 1, 2, 0, 7, 8},
            {9, 0, 8, 0, 0, 0, 0, 0, 0}
    };

    public void solve() {
        long before = System.currentTimeMillis();
        int[][] grid = Arrays.copyOf(GRID_EXERCISE, GRID_SIZE);
        if (fillGrid(grid)) {
            long after = System.currentTimeMillis();
            System.out.println("Time needed to solve sudoku: " + (after-before) + " milliseconds" );
            System.out.println("Soduko successfully solved!!");
            for(var row : grid) {
                for (var col : row) {
                    System.out.print(col + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Sudoku can not be solved.");
        }
    }

    private boolean isValuePresentInRow(int[][] grid, int value, int rowIndex) {
        for (int y = 0; y < GRID_SIZE; y++) {
            if (grid[rowIndex][y] == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValuePresentInCol(int[][] grid, int value, int colIndex) {
        for (int x = 0; x < GRID_SIZE; x++) {
            if (grid[x][colIndex] == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValuePresentInBloc(int[][] grid, int value, int rowIndex, int colIndex) {
        var pivotX = rowIndex - (rowIndex % 3);
        var pivotY = colIndex - (colIndex % 3);
        for (int x = pivotX; x < pivotX + 3; x++) {
            for (int y = pivotY; y < pivotY + 3; y++) {
                if (grid[x][y] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValuePossible(int[][] grid, int value, int rowIndex, int colIndex) {
        return !isValuePresentInRow(grid, value, rowIndex) &&
                !isValuePresentInCol(grid, value, colIndex) &&
                !isValuePresentInBloc(grid, value, rowIndex, colIndex);
    }

    public boolean fillGrid(int[][] grid) {
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                for (int i = 1; i <= GRID_SIZE; i++) {
                    if (grid[x][y] == 0) {
                        if (isValuePossible(grid, i, x, y)) {
                            grid[x][y] = i;
                            if(!fillGrid(grid)){
                                grid[x][y] = 0;
                            }
                        }
                    }
                }
                if (grid[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
