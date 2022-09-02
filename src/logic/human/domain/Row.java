package logic.human.domain;

import logic.human.singleton.GridSingleton;

public class Row extends Structure {
    private final int rowIndex;

    public Row(int rowIndex, int[][] grid) {
        this.rowIndex = rowIndex;
        checkForMissingValues(grid);
    }

    public int getRowIndex() {
        return rowIndex;
    }

    @Override
    protected void checkForMissingValues(int[][] grid) {
        var row = grid[rowIndex];
        for (int y = 0; y < GridSingleton.INSTANCE.getRowSize(); y++) {
            var value = row[y];
            if (value == 0) {
                missingPoints.add(new Point(rowIndex, y));
            }
            missingValues.remove(value);
            sum += value;
        }
    }
}
