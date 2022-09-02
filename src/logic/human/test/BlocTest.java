package logic.human.test;

import logic.human.domain.Bloc;
import logic.human.domain.Point;

public class BlocTest {
    private static final int[][] exBloc = {
            {1, 2, 3},
            {0, 5, 6},
            {7, 8, 9}
    };

    public static void main(String[] args) {
        var bloc = new Bloc(new Point(1, 1), exBloc);
        System.out.println(bloc.getPivot());
        System.out.println(bloc.getReferencePoint());
        System.out.println(bloc.calculateMissingValue());
    }
}
