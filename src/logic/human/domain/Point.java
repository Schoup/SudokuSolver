package logic.human.domain;

import logic.human.singleton.GridSingleton;

import java.util.Objects;

public record Point (int x, int y) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point getPivotPoint() {
        return new Point(calculatePivotAx(getX()), calculatePivotAx(getY()));
    }

    private int calculatePivotAx(int inPointAx) {
        var offSet = inPointAx % GridSingleton.INSTANCE.getGridSize();
        if (offSet == 0) {
            return inPointAx;
        }
        return inPointAx - offSet;
    }
}
