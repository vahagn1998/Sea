package School.homework.SeaBattle;


public class MapComputer extends Map {
    char[][] cells = getCells();

    public void setOneDeckShip(int y, int x) {
        cells[y][x] = 'X';
    }

    public void removeOneDeckShip(int[] y, int[] x, int size) {
        for (int j = 0; j < size; j++) {
            cells[y[j]][x[j]] = 'o';
        }
    }

    public int setTwoDeckShip(int y, int x, int r) {
        cells[y][x] = 'X';
        if (r == 0) {
            if (x == 1) {
                cells[y][x + 1] = 'X';
            } else {
                cells[y][x - 1] = 'X';
            }
        } else {
            if (y == 1) {
                cells[y + 1][x] = 'X';
            } else {
                cells[y - 1][x] = 'X';
            }
        }
        return r;
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
}
