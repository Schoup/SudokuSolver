package logic.human.domain;

import logic.human.singleton.GridSingleton;

public class Column extends Structure {
    private final int columnIndex;

    public Column(int columnIndex, int[][] grid) {
        this.columnIndex = columnIndex;
        checkForMissingValues(grid);
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    @Override
    protected void checkForMissingValues(int[][] grid) {
        for (int x = 0; x < GridSingleton.INSTANCE.getColSize(); x++) {
            var value = grid[x][columnIndex];
            if (value == 0) {
                missingPoints.add(new Point(x, columnIndex));
            }
            missingValues.remove(value);
            sum += value;
        }
    }
}
