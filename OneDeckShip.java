package School.homework.SeaBattle;

public class OneDeckShip extends Ship {
    Map map;
    public static final int SIZE_ONE_DECK_SHIP = 5;
    char[][] cells;
    int[] oneDeckShipX;
    int[] oneDeckShipY;

    public OneDeckShip(Map map) {
        this.map = map;
        cells = map.getCells();
        super.setSizePositionShipX(SIZE_ONE_DECK_SHIP);
        super.setSizePositionShipY(SIZE_ONE_DECK_SHIP);
        oneDeckShipX = super.getPositionShipX();
        oneDeckShipY = super.getPositionShipY();
    }

    public void cycleOneDeckShip() {
        cyclePositionOneShip();
        for (int i = 0; i < SIZE_ONE_DECK_SHIP; i++) {
            checkOnOthersOneDeckShip(oneDeckShipY[i], oneDeckShipX[i]);
        }
    }

    public void cyclePositionOneShip() {
        for (int i = 0; i < SIZE_ONE_DECK_SHIP; i++) {
            oneDeckShipX[i] = randomPositionShip(map.SIZE_X, SIZE_ONE_DECK_SHIP);
            oneDeckShipY[i] = randomPositionShip(map.SIZE_Y, SIZE_ONE_DECK_SHIP);
            checkOneDeckShip(i);
            map.setOneDeckShip(oneDeckShipY[i], oneDeckShipX[i]);
        }
    }

    public void checkOneDeckShip(int i) {
        while (returnResultCheckPositionOneShip(i)) {
            oneDeckShipX[i] = randomPositionShip(map.SIZE_X, SIZE_ONE_DECK_SHIP);
            oneDeckShipY[i] = randomPositionShip(map.SIZE_Y, SIZE_ONE_DECK_SHIP);
        }
    }

    public boolean returnResultCheckPositionOneShip(int i) {
        boolean result = false;
        if (cells[oneDeckShipY[i]][oneDeckShipX[i]] == 'X') {
            result = true;
        }
        return result;
    }

    public void checkOnOthersOneDeckShip(int shipY, int shipX) {
        while (true) {
            if (shipY == map.SIZE_Y - 1 && shipX != map.SIZE_X - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallOneDeckShip();
                }
                break;
            } else if (shipX == map.SIZE_X - 1 && shipY != map.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                    reinstallOneDeckShip();
                }
                break;
            } else if (shipX == map.SIZE_X - 1 && shipY == map.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                    reinstallOneDeckShip();
                }
                break;
            } else if (shipX != map.SIZE_X - 1 && shipY != map.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallOneDeckShip();
                }
                break;
            }
        }
    }

    public void reinstallOneDeckShip() {
        if (removeCash < 1) {
            map.removeOneDeckShip(oneDeckShipY, oneDeckShipX, SIZE_ONE_DECK_SHIP);
            cycleOneDeckShip();
        }
        removeCash++;
    }
}
