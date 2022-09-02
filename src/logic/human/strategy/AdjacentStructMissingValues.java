package logic.human.strategy;

import logic.human.domain.Point;
import logic.human.domain.StructureOverview;
import logic.human.singleton.GridSingleton;
import logic.human.strategy.IIdentifyValues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AdjacentStructMissingValues implements IIdentifyValues {
    @Override
    public int setMissingValues(StructureOverview generatedStructs) {
        int assignedValues = 0;
        var blocs = generatedStructs.getListBlocs();
        for (var bloc : blocs) {
            HashMap<Integer, Set<Point>> mappingValueToPoints = new HashMap<>();
            for (Point missingPoint : bloc.getMissingPoints()) {
                var missingValuesCurrRow = generatedStructs.getListRows().get(missingPoint.getX()).getMissingValues();
                var missingValuesCurrCol = generatedStructs.getListCols().get(missingPoint.getY()).getMissingValues();
                var missingValuesCurrBloc = bloc.getMissingValues();
                //check both adjacent rows & cols:
                //getPossibleValuesForCurrCell = missingValuesCurrRow & missingValuesCurrCol
                //loop through all points in Bloc to check there is no other point that can have this value
                //if at least one other point can have this value continue loop to next missingPoint, otherwise set value

                //For each of the missing values in currBloc, get the possible cells in the bloc that can contain this value
                //if there is only 1 cell, set the value
                Set<Integer> possibleValuesCurrCell = new HashSet<>();
                //get values that exist in both lists missingValuesCurrRow & missingValuesCurrCol -> put those in possibleValuesCurrCell
                missingValuesCurrRow.stream()
                        .filter(rowI -> missingValuesCurrCol.stream().anyMatch(colI -> colI.equals(rowI)))
                        .filter(rowI -> missingValuesCurrBloc.stream().anyMatch(colI -> colI.equals(rowI)))
                        .forEach(possibleValuesCurrCell::add);

                //add to hashmap of possibilities
                possibleValuesCurrCell.forEach(i -> {
                    Set<Point> setPoints;
                    if (mappingValueToPoints.containsKey(i)) {
                        setPoints = mappingValueToPoints.get(i);
                    } else {
                        setPoints = new HashSet<>();
                    }
                    setPoints.add(missingPoint);
                    mappingValueToPoints.put(i, setPoints);
                });
            }

            for (var key : mappingValueToPoints.keySet()) {
                var v = mappingValueToPoints.get(key);
                if (v.size() == 1) {
                    Point pointToSet = v.stream().findFirst().get();
                    GridSingleton.INSTANCE.getGrid()[pointToSet.getX()][pointToSet.getY()] = key;
                    assignedValues++;
                }
            }
        }
        return assignedValues;
    }
}
