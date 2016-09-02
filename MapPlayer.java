package School.homework.SeaBattle;

public class MapPlayer extends Map {
    char[][] cells = getCells();

    @Override
    public void showMapFake() {
        System.out.println("Ваше поле.");
        System.out.print(" ");
        for (int j = 1; j < SIZE_X; j++) {
            System.out.print(" " + j);
        }
        System.out.println();
        for (int i = 1; i < SIZE_Y; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < SIZE_X; j++) {
                System.out.print(cells[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
