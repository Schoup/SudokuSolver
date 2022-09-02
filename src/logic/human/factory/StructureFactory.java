package logic.human.factory;

import logic.human.domain.Structures;
import logic.human.domain.*;
import logic.human.singleton.GridSingleton;

import java.util.LinkedList;
import java.util.List;

public class StructureFactory implements IStructureFactory {
    @Override
    public List<Structure> create(int[][] grid, Structures type) {
        var listStructs = new LinkedList<Structure>();
        switch (type) {
            case ROW -> {
                for (int i = 0; i < GridSingleton.INSTANCE.getRowSize(); i++) {
                    listStructs.add(new Row(i, grid));
                }
            }
            case COLUMN -> {
                for (int i = 0; i < GridSingleton.INSTANCE.getColSize(); i++) {
                    listStructs.add(new Column(i, grid));
                }
            }
            case BLOC -> {
                for (int x = 0; x < GridSingleton.INSTANCE.getRowSize(); x += 3) {
                    for (int y = 0; y < GridSingleton.INSTANCE.getColSize(); y += 3) {
                        //It's also possible to just add a constructor to Bloc ( int i, int[][] grid) where 1 <= i <= 9
                        listStructs.add(new Bloc(new Point(x, y), grid));
                    }
                }
            }
        }
        return listStructs;
    }
}
