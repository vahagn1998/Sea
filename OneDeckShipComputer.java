package School.homework.SeaBattle;

public class OneDeckShipComputer extends ShipComputer {
    MapComputer mapComputer;
    public static final int SIZE_ONE_DECK_SHIP_COMPUTER = 5;
    char[][] cells;
    int[] oneDeckShipX;
    int[] oneDeckShipY;

    public OneDeckShipComputer(MapComputer mapComputer) {
        this.mapComputer = mapComputer;
        cells = mapComputer.getCells();
        super.setSizePositionShipX(SIZE_ONE_DECK_SHIP_COMPUTER);
        super.setSizePositionShipY(SIZE_ONE_DECK_SHIP_COMPUTER);
        oneDeckShipX = super.getPositionShipX();
        oneDeckShipY = super.getPositionShipY();
    }

    public void setOneDeckShip() {
        cyclePositionOneShip();
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_COMPUTER; i++) {
            checkOnOthersOneDeckShip(oneDeckShipY[i], oneDeckShipX[i]);
        }
    }

    public void cyclePositionOneShip() {
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_COMPUTER; i++) {
            oneDeckShipX[i] = randomPositionShip(mapComputer.SIZE_X, SIZE_ONE_DECK_SHIP_COMPUTER);
            oneDeckShipY[i] = randomPositionShip(mapComputer.SIZE_Y, SIZE_ONE_DECK_SHIP_COMPUTER);
            checkOneDeckShip(i);
            mapComputer.setOneDeckShip(oneDeckShipY[i], oneDeckShipX[i]);
        }
    }

    public void checkOneDeckShip(int i) {
        while (returnResultCheckPositionOneShip(i)) {
            oneDeckShipX[i] = randomPositionShip(mapComputer.SIZE_X, SIZE_ONE_DECK_SHIP_COMPUTER);
            oneDeckShipY[i] = randomPositionShip(mapComputer.SIZE_Y, SIZE_ONE_DECK_SHIP_COMPUTER);
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
            if (shipY == mapComputer.SIZE_Y - 1 && shipX != mapComputer.SIZE_X - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallOneDeckShip();
                }
                break;
            } else if (shipX == mapComputer.SIZE_X - 1 && shipY != mapComputer.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                    reinstallOneDeckShip();
                }
                break;
            } else if (shipX == mapComputer.SIZE_X - 1 && shipY == mapComputer.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                    reinstallOneDeckShip();
                }
                break;
            } else if (shipX != mapComputer.SIZE_X - 1 && shipY != mapComputer.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallOneDeckShip();
                }
                break;
            }
        }
    }

    public void reinstallOneDeckShip() {
        if (removeCash < 1) {
            mapComputer.removeOneDeckShip(oneDeckShipY, oneDeckShipX, SIZE_ONE_DECK_SHIP_COMPUTER);
            setOneDeckShip();
        }
        removeCash++;
    }
}
