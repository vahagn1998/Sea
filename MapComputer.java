package School.homework.SeaBattle;


public class MapComputer extends Map {
    char[][] cells = getCells();
    Object[][] cellsFake = getCellsFake();

    public void removeOneDeckShip(int[] y, int[] x, int size) {
        for (int j = 0; j < size; j++) {
            cells[y[j]][x[j]] = 'o';
        }
    }

    public void removeTwoDeckShip(int[] y, int[] x, int size, int[] res) {
        for (int j = 0; j < size; j++) {
            cells[y[j]][x[j]] = 'o';
            if (res[j] == 0) {
                if (x[j] == 1) {
                    cells[y[j]][x[j] + 1] = 'o';
                } else {
                    cells[y[j]][x[j] - 1] = 'o';
                }
            } else {
                if (y[j] == 1) {
                    cells[y[j] + 1][x[j]] = 'o';
                } else {
                    cells[y[j] - 1][x[j]] = 'o';
                }
            }
        }
    }

    public void fieldFake() {
        for (int i = 1; i < SIZE_Y; i++) {
            for (int j = 1; j < SIZE_X; j++) {
                cellsFake[i][j] = ('o');
            }
        }

        for (int i = 0; i < SIZE_X; i++) {
            if (i == 0) {
                cellsFake[0][i] = ("  ");
            } else {
                cellsFake[0][i] = (i);
            }
        }

        for (int i = 1; i < SIZE_Y; i++) {
            cellsFake[i][0] = (i + " ");
        }
    }
}
