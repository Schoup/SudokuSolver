package logic.human;

import logic.human.domain.StructureOverview;
import logic.human.domain.Structures;
import logic.human.factory.StructureFactory;
import logic.human.singleton.GridSingleton;
import logic.human.strategy.AdjacentStructMissingValues;
import logic.human.strategy.IIdentifyValues;
import logic.human.strategy.SingleStructMissingValues;

import java.util.Arrays;

public class SudokuSolver {
    private StructureOverview generatedStructs;

    public void solve() {
        for (var row : GridSingleton.INSTANCE.getGrid()) {
            System.out.println(Arrays.toString(row));
        }

        long before = System.currentTimeMillis();
        IIdentifyValues singleStructStrategy = new SingleStructMissingValues();
        // Possible optimization: generateStructs first and loop until missingPoints/missingValues all have length of 0
        while (gridContainsBlanks()) {
            generateStructs();
            if (singleStructStrategy.setMissingValues(generatedStructs) > 0) {
                generateStructs();
            }
            AdjacentStructMissingValues adjacentStructStrategy = new AdjacentStructMissingValues();
            adjacentStructStrategy.setMissingValues(generatedStructs);
        }
        long after = System.currentTimeMillis();
        System.out.println("Time needed to solve sudoku: " + (after-before) + " milliseconds");
        for (var row : GridSingleton.INSTANCE.getGrid()) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean gridContainsBlanks() {
        return Arrays.stream(GridSingleton.INSTANCE.getGrid()).flatMapToInt(Arrays::stream).anyMatch(i -> i == 0);
    }

    public void generateStructs() {
        generatedStructs = new StructureOverview();
        StructureFactory factory = new StructureFactory();
        generatedStructs.setListRows(factory.create(GridSingleton.INSTANCE.getGrid(), Structures.ROW));
        generatedStructs.setListCols(factory.create(GridSingleton.INSTANCE.getGrid(), Structures.COLUMN));
        generatedStructs.setListBlocs(factory.create(GridSingleton.INSTANCE.getGrid(), Structures.BLOC));
    }
}
