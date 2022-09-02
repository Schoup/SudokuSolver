package logic.human.test;

import logic.human.domain.Column;

public class ColumnTest {
    private static final int[][] exColumn = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {2},
            {3},
            {5},
            {6},
            {0},
            {9}
    };

    public static void main(String[] args) {
        var col = new Column(0, exColumn);
        System.out.println(col.getColumnIndex());
        System.out.println(col.calculateMissingValue());
    }
}
