package logic.human.strategy;

import logic.human.domain.Structure;
import logic.human.domain.StructureOverview;
import logic.human.singleton.GridSingleton;

public class SingleStructMissingValues implements IIdentifyValues {
    public int setMissingValues(StructureOverview generatedStructs) {
        int valuesChanged = 0;
        for (var r : generatedStructs.getListRows()) {
            valuesChanged += setSoleMissingValueFromStruct(r);
        }

        for (var c : generatedStructs.getListCols()) {
            valuesChanged += setSoleMissingValueFromStruct(c);
        }

        for (var b : generatedStructs.getListBlocs()) {
            valuesChanged += setSoleMissingValueFromStruct(b);
        }
        return valuesChanged;
    }

    public int setSoleMissingValueFromStruct(Structure structure) {
        int valuesChanged = 0;
        var missingValueInRow = structure.calculateMissingValue();
        if (missingValueInRow > 0) {
            var pointToChange = structure.getMissingPoints().get(0);
            GridSingleton.INSTANCE.getGrid()[pointToChange.getX()][pointToChange.getY()] = missingValueInRow;
            valuesChanged++;
        }
        return valuesChanged;
    }
}
