package logic.human.singleton;

import java.util.Arrays;

public enum GridSingleton {
    INSTANCE();

    private static final int GRID_SIZE = 3;
    private static final int ROW_COL_SIZE = 9;

    private final int[][] grid;

    private final int[][] GRID_TEST_EXAMPLE = {
            {0, 2, 3, 4, 5, 6, 7, 8, 9},
            {0, 0, 6, 7, 8, 9, 1, 2, 3},
            {0, 0, 0, 1, 2, 3, 4, 5, 6},

            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},

            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
    };

    private static final int[][] FULL_GRID = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},

            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},

            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
    };

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

    GridSingleton() {
        grid = Arrays.copyOf(GRID_EXERCISE, ROW_COL_SIZE);
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public int getGridSize() {
        return GRID_SIZE;
    }

    public int getRowSize() {
        return ROW_COL_SIZE;
    }

    public int getColSize() {
        return ROW_COL_SIZE;
    }
}
