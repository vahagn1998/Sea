package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.View.Map;
import School.homework.SeaBattle.View.MapComputer;
import School.homework.SeaBattle.View.MapPlayer;

import java.util.Random;

public class TwoDeckShipComputer extends ShipComputer {
    Map map;
    public static final int SIZE_TWO_DECK_SHIP_COMPUTER = 3;
    char[][] cells;
    int[] twoDeckShipsX;
    int[] twoDeckShipsY;
    int[] resRandomFull = new int[SIZE_TWO_DECK_SHIP_COMPUTER];

    public TwoDeckShipComputer(MapComputer mapComputer) {
        this.map = mapComputer;
        cells = map.getCells();
        super.setSizePositionShipX(SIZE_TWO_DECK_SHIP_COMPUTER);
        super.setSizePositionShipY(SIZE_TWO_DECK_SHIP_COMPUTER);
        twoDeckShipsX = super.getPositionsShipsX();
        twoDeckShipsY = super.getPositionsShipsY();
    }

    public TwoDeckShipComputer(MapPlayer mapPlayer) {
        this.map = mapPlayer;
        cells = map.getCells();
        super.setSizePositionShipX(SIZE_TWO_DECK_SHIP_COMPUTER);
        super.setSizePositionShipY(SIZE_TWO_DECK_SHIP_COMPUTER);
        twoDeckShipsX = super.getPositionsShipsX();
        twoDeckShipsY = super.getPositionsShipsY();
    }

    @Override
    public void setShip() {
        cyclePositionShip();
        for (int i = 0; i < SIZE_TWO_DECK_SHIP_COMPUTER; i++) {
            checkOnOthersShip(twoDeckShipsY[i], twoDeckShipsX[i], resRandomFull[i]);
        }
    }

    @Override
    public void cyclePositionShip() {
        for (int i = 0; checkAndReturnValueCyclePositionTwoDeckShip(); i++) {
            Random rand = new Random();
            resRandomFull[i] = rand.nextInt(2);
            twoDeckShipsX[i] = randomPositionShip(Map.SIZE_X, SIZE_TWO_DECK_SHIP_COMPUTER);
            twoDeckShipsY[i] = randomPositionShip(Map.SIZE_Y, SIZE_TWO_DECK_SHIP_COMPUTER);
            checkShip(i);
            checkOnSecondDeckForTwoDeckShip(twoDeckShipsY[i], twoDeckShipsX[i], i);
            map.setTwoDeckShip(twoDeckShipsY[i], twoDeckShipsX[i], resRandomFull[i]);
        }
    }

    @Override
    public void checkShip(int i) {
        while (returnResultCheckPositionShip(i)) {
            twoDeckShipsX[i] = randomPositionShip(Map.SIZE_X, SIZE_TWO_DECK_SHIP_COMPUTER);
            twoDeckShipsY[i] = randomPositionShip(Map.SIZE_Y, SIZE_TWO_DECK_SHIP_COMPUTER);
        }
    }

    @Override
    public boolean returnResultCheckPositionShip(int i) {
        boolean result = false;
        if (cells[twoDeckShipsY[i]][twoDeckShipsX[i]] == 'X') {
            result = true;
        }
        if (twoDeckShipsY[i] != Map.SIZE_Y - 1) {
            if (cells[twoDeckShipsY[i] + 1][twoDeckShipsX[i]] == 'X') {
                result = true;
            }
        } else if (twoDeckShipsX[i] != Map.SIZE_X - 1) {
            if (cells[twoDeckShipsY[i]][twoDeckShipsX[i] + 1] == 'X') {
                result = true;
            }
        } else {
            if (cells[twoDeckShipsY[i] - 1][twoDeckShipsX[i]] == 'X') {
                result = true;
            }
            if (cells[twoDeckShipsY[i]][twoDeckShipsX[i] - 1] == 'X') {
                result = true;
            }
        }
        return result;
    }

    public void checkOnSecondDeckForTwoDeckShip(int y, int x, int i) {
        if (resRandomFull[i] == 0) {
            if (x == 1) {
                if (cells[y][x + 1] == 'X') {
                    map.removeTwoDeckShip(twoDeckShipsY, twoDeckShipsX, i, resRandomFull);
                    cyclePositionShip();

                }
            } else {
                if (cells[y][x - 1] == 'X') {
                    map.removeTwoDeckShip(twoDeckShipsY, twoDeckShipsX, i, resRandomFull);
                    cyclePositionShip();
                }
            }
        } else {
            if (y == 1) {
                if (cells[y + 1][x] == 'X') {
                    map.removeTwoDeckShip(twoDeckShipsY, twoDeckShipsX, i, resRandomFull);
                    cyclePositionShip();
                }
            } else {
                if (cells[y - 1][x] == 'X') {
                    map.removeTwoDeckShip(twoDeckShipsY, twoDeckShipsX, i, resRandomFull);
                    cyclePositionShip();
                }
            }
        }
    }

    public boolean checkAndReturnValueCyclePositionTwoDeckShip() {
        int counter = 1;
        boolean checkStrength = true;
        for (char[] cell : cells) {
            for (char c : cell) {
                if (counter <= SIZE_TWO_DECK_SHIP_COMPUTER * 2) {
                    if (c == 'X') {
                        if (counter == SIZE_TWO_DECK_SHIP_COMPUTER * 2) {
                            checkStrength = false;
                        }
                        counter++;
                    }
                }
            }
        }
        return checkStrength;
    }

    @Override
    public void checkOnOthersShip(int shipY, int shipX, int res) {
        while (true) {
            if (shipY == Map.SIZE_Y - 1 && shipX != Map.SIZE_X - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallShip();
                        }
                    }
                }
                break;
            } else if (shipX == Map.SIZE_X - 1 && shipY != Map.SIZE_Y - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]  || 'X' == cells[shipY + 1][shipX]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                            reinstallShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY + 1][shipX]) {
                            reinstallShip();
                        }
                    }
                }
                break;
            } else if (shipX == Map.SIZE_X - 1 && shipY == Map.SIZE_Y - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX]) {
                            reinstallShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1]) {
                            reinstallShip();
                        }
                    }
                }
                break;
            } else if (shipX != Map.SIZE_X - 1 && shipY != Map.SIZE_Y - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallShip();
                        }
                    }
                }
                break;
            }
        }
    }

    @Override
    public void reinstallShip() {
        map.removeTwoDeckShip(twoDeckShipsY, twoDeckShipsX, SIZE_TWO_DECK_SHIP_COMPUTER, resRandomFull);
        setShip();
    }
}
