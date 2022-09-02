package logic.human.factory;

import logic.human.domain.Structure;
import logic.human.domain.Structures;

import java.util.List;

public interface IStructureFactory {
    List<Structure> create(int[][] grid, Structures type);
}
