package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.View.Map;
import School.homework.SeaBattle.View.MapComputer;
import School.homework.SeaBattle.View.MapPlayer;

public class OneDeckShipComputer extends ShipComputer {
    Map mapComputer;
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

    public OneDeckShipComputer(MapPlayer mapPlayer) {
        this.mapComputer = mapPlayer;
        cells = mapPlayer.getCells();
        super.setSizePositionShipX(SIZE_ONE_DECK_SHIP_COMPUTER);
        super.setSizePositionShipY(SIZE_ONE_DECK_SHIP_COMPUTER);
        oneDeckShipX = super.getPositionShipX();
        oneDeckShipY = super.getPositionShipY();
    }

    @Override
    public void setShip() {
        cyclePositionShip();
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_COMPUTER; i++) {
            checkOnOthersShip(oneDeckShipY[i], oneDeckShipX[i], 0);
        }
    }

    @Override
    public void cyclePositionShip() {
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_COMPUTER; i++) {
            oneDeckShipX[i] = randomPositionShip(mapComputer.SIZE_X, SIZE_ONE_DECK_SHIP_COMPUTER);
            oneDeckShipY[i] = randomPositionShip(mapComputer.SIZE_Y, SIZE_ONE_DECK_SHIP_COMPUTER);
            checkShip(i);
            mapComputer.setOneDeckShip(oneDeckShipY[i], oneDeckShipX[i]);
        }
    }

    @Override
    public void checkShip(int i) {
        while (returnResultCheckPositionShip(i)) {
            oneDeckShipX[i] = randomPositionShip(mapComputer.SIZE_X, SIZE_ONE_DECK_SHIP_COMPUTER);
            oneDeckShipY[i] = randomPositionShip(mapComputer.SIZE_Y, SIZE_ONE_DECK_SHIP_COMPUTER);
        }
    }

    @Override
    public boolean returnResultCheckPositionShip(int i) {
        boolean result = false;
        if (cells[oneDeckShipY[i]][oneDeckShipX[i]] == 'X') {
            result = true;
        }
        return result;
    }

    @Override
    public void checkOnOthersShip(int shipY, int shipX, int res) {
        while (true) {
            if (shipY == mapComputer.SIZE_Y - 1 && shipX != mapComputer.SIZE_X - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallShip();
                }
                break;
            } else if (shipX == mapComputer.SIZE_X - 1 && shipY != mapComputer.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                    reinstallShip();
                }
                break;
            } else if (shipX == mapComputer.SIZE_X - 1 && shipY == mapComputer.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                    reinstallShip();
                }
                break;
            } else if (shipX != mapComputer.SIZE_X - 1 && shipY != mapComputer.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallShip();
                }
                break;
            }
        }
    }

    @Override
    public void reinstallShip() {
        if (removeCash < 1) {
            mapComputer.removeOneDeckShip(oneDeckShipY, oneDeckShipX, SIZE_ONE_DECK_SHIP_COMPUTER);
            setShip();
        }
        removeCash++;
    }
}
