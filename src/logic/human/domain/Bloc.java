package logic.human.domain;

import logic.human.singleton.GridSingleton;

public class Bloc extends Structure {
    private final Point pivot;
    private final Point referencePoint;

    public Bloc(Point inPoint, int[][] grid) {
        this.referencePoint = inPoint;
        this.pivot = inPoint.getPivotPoint();
        checkForMissingValues(grid);
    }

    public Point getPivot() {
        return pivot;
    }

    public Point getReferencePoint() {
        return referencePoint;
    }

    protected void checkForMissingValues(int[][] grid) {
        for (int x = pivot.getX(); x < pivot.getX()+ GridSingleton.INSTANCE.getGridSize(); x++) {
            for (int y = pivot.getY(); y < pivot.getY()+GridSingleton.INSTANCE.getGridSize(); y++) {
                var value = grid[x][y];
                if (value == 0) {
                    missingPoints.add(new Point(x, y));
                }
                missingValues.remove(value);
                sum += value;
            }
        }
    }
}
