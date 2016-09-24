package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.View.Map;
import School.homework.SeaBattle.View.MapComputer;
import School.homework.SeaBattle.View.MapPlayer;

public class OneDeckShipComputer extends ShipComputer {
    Map mapComputer;
    public static final int SIZE_ONE_DECK_SHIP_COMPUTER = 5;
    char[][] cells;
    int[] oneDeckShipsPositionsX;
    int[] oneDeckShipsPositionsY;

    public OneDeckShipComputer(MapComputer mapComputer) {
        this.mapComputer = mapComputer;
        cells = mapComputer.getCells();
        super.setSizePositionShipX(SIZE_ONE_DECK_SHIP_COMPUTER);
        super.setSizePositionShipY(SIZE_ONE_DECK_SHIP_COMPUTER);
        oneDeckShipsPositionsX = super.getPositionsShipsX();
        oneDeckShipsPositionsY = super.getPositionsShipsY();
    }

    public OneDeckShipComputer(MapPlayer mapPlayer) {
        this.mapComputer = mapPlayer;
        cells = mapPlayer.getCells();
        super.setSizePositionShipX(SIZE_ONE_DECK_SHIP_COMPUTER);
        super.setSizePositionShipY(SIZE_ONE_DECK_SHIP_COMPUTER);
        oneDeckShipsPositionsX = super.getPositionsShipsX();
        oneDeckShipsPositionsY = super.getPositionsShipsY();
    }

    @Override
    public void setShip() {
        cyclePositionShip();
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_COMPUTER; i++) {
            checkOnOthersShip(oneDeckShipsPositionsY[i], oneDeckShipsPositionsX[i], 0);
        }
    }

    @Override
    public void cyclePositionShip() {
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_COMPUTER; i++) {
            oneDeckShipsPositionsX[i] = randomPositionShip(Map.SIZE_X, SIZE_ONE_DECK_SHIP_COMPUTER);
            oneDeckShipsPositionsY[i] = randomPositionShip(Map.SIZE_Y, SIZE_ONE_DECK_SHIP_COMPUTER);
            checkShip(i);
            mapComputer.setOneDeckShip(oneDeckShipsPositionsY[i], oneDeckShipsPositionsX[i]);
        }
    }

    @Override
    public void checkShip(int i) {
        while (returnResultCheckPositionShip(i)) {
            oneDeckShipsPositionsX[i] = randomPositionShip(Map.SIZE_X, SIZE_ONE_DECK_SHIP_COMPUTER);
            oneDeckShipsPositionsY[i] = randomPositionShip(Map.SIZE_Y, SIZE_ONE_DECK_SHIP_COMPUTER);
        }
    }

    @Override
    public boolean returnResultCheckPositionShip(int i) {
        boolean result = false;
        if (cells[oneDeckShipsPositionsY[i]][oneDeckShipsPositionsX[i]] == 'X') {
            result = true;
        }
        return result;
    }

    @Override
    public void checkOnOthersShip(int shipY, int shipX, int res) {
        while (true) {
            if (shipY == Map.SIZE_Y - 1 && shipX != Map.SIZE_X - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallShip();
                }
                break;
            } else if (shipX == Map.SIZE_X - 1 && shipY != Map.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                    reinstallShip();
                }
                break;
            } else if (shipX == Map.SIZE_X - 1 && shipY == Map.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                    reinstallShip();
                }
                break;
            } else if (shipX != Map.SIZE_X - 1 && shipY != Map.SIZE_Y - 1) {
                if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                    reinstallShip();
                }
                break;
            }
        }
    }

    @Override
    public void reinstallShip() {
        mapComputer.removeOneDeckShip(oneDeckShipsPositionsY, oneDeckShipsPositionsX, SIZE_ONE_DECK_SHIP_COMPUTER);
        setShip();

    }
}
