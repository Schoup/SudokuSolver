package logic.human.domain;

import logic.human.domain.Row;

public class RowTest {

    private static final int[][] exRow = {
            {1, 2, 3, 4, 5, 6, 7, 0, 9}
    };

    public static void main(String[] args) {
        var row = new Row(0, exRow);
        System.out.println(row.getRowIndex());
        System.out.println(row.calculateMissingValue());
    }
}
