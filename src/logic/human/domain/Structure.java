package logic.human.domain;

import logic.human.domain.Point;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Structure {
    private static final int MAX_SUM = 45;
    protected List<Point> missingPoints = new ArrayList<>();
    protected Set<Integer> missingValues = IntStream.rangeClosed(1, 9)
            .boxed()
            .collect(Collectors.toSet());
    protected int sum = 0;

    protected abstract void checkForMissingValues(int[][] grid);

    /**
     * @return -1 if line complete
    0 if it can not compute missing value
    positive number, the missing number? or Set the value?
     */
    public int calculateMissingValue() {
        return switch (missingPoints.size()) {
            case 0 -> -1;
            case 1 -> MAX_SUM - sum;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Structure{" +
                "missingPoints=" + missingPoints +
                ", missingValues=" + missingValues +
                ", sum=" + sum +
                '}';
    }

    public List<Point> getMissingPoints() {
        return missingPoints;
    }

    public Set<Integer> getMissingValues() {
        return missingValues;
    }
}
