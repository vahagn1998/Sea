package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.View.MapComputer;

import java.util.Random;

public class TwoDeckShipComputer extends ShipComputer {
    MapComputer mapComputer;
    public static final int SIZE_TWO_DECK_SHIP_COMPUTER = 3;
    char[][] cells;
    int[] twoDeckShipX;
    int[] twoDeckShipY;
    int[] resRandomFull = new int[SIZE_TWO_DECK_SHIP_COMPUTER];

    public TwoDeckShipComputer(MapComputer mapComputer) {
        this.mapComputer = mapComputer;
        cells = mapComputer.getCells();
        super.setSizePositionShipX(SIZE_TWO_DECK_SHIP_COMPUTER);
        super.setSizePositionShipY(SIZE_TWO_DECK_SHIP_COMPUTER);
        twoDeckShipX = super.getPositionShipX();
        twoDeckShipY = super.getPositionShipY();
    }

    @Override
    public void setShip() {
        cyclePositionShip();
        for (int i = 0; i < SIZE_TWO_DECK_SHIP_COMPUTER; i++) {
            checkOnOthersShip(twoDeckShipY[i], twoDeckShipX[i], resRandomFull[i]);
        }
    }

    @Override
    public void cyclePositionShip() {
        for (int i = 0; checkAndReturnValueCyclePositionTwoDeckShip(); i++) {
            Random rand = new Random();
            resRandomFull[i] = rand.nextInt(2);
            twoDeckShipX[i] = randomPositionShip(mapComputer.SIZE_X, SIZE_TWO_DECK_SHIP_COMPUTER);
            twoDeckShipY[i] = randomPositionShip(mapComputer.SIZE_Y, SIZE_TWO_DECK_SHIP_COMPUTER);
            checkShip(i);
            checkOnSecondDeckForTwoDeckShip(twoDeckShipY[i], twoDeckShipX[i], i);
            mapComputer.setTwoDeckShip(twoDeckShipY[i], twoDeckShipX[i], resRandomFull[i]);
        }
    }

    @Override
    public void checkShip(int i) {
        while (returnResultCheckPositionShip(i)) {
            twoDeckShipX[i] = randomPositionShip(mapComputer.SIZE_X, SIZE_TWO_DECK_SHIP_COMPUTER);
            twoDeckShipY[i] = randomPositionShip(mapComputer.SIZE_Y, SIZE_TWO_DECK_SHIP_COMPUTER);
        }
    }

    @Override
    public boolean returnResultCheckPositionShip(int i) {
        boolean result = false;
        if (cells[twoDeckShipY[i]][twoDeckShipX[i]] == 'X') {
            result = true;
        }
        if (twoDeckShipY[i] != mapComputer.SIZE_Y - 1) {
            if (cells[twoDeckShipY[i] + 1][twoDeckShipX[i]] == 'X') {
                result = true;
            }
        } else if (twoDeckShipX[i] != mapComputer.SIZE_X - 1) {
            if (cells[twoDeckShipY[i]][twoDeckShipX[i] + 1] == 'X') {
                result = true;
            }
        } else {
            if (cells[twoDeckShipY[i] - 1][twoDeckShipX[i]] == 'X') {
                result = true;
            }
            if (cells[twoDeckShipY[i]][twoDeckShipX[i] - 1] == 'X') {
                result = true;
            }
        }
        return result;
    }

    public void checkOnSecondDeckForTwoDeckShip(int y, int x, int i) {
        if (resRandomFull[i] == 0) {
            if (x == 1) {
                if (cells[y][x + 1] == 'X') {
                    mapComputer.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
                    cyclePositionShip();

                }
            } else {
                if (cells[y][x - 1] == 'X') {
                    mapComputer.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
                    cyclePositionShip();
                }
            }
        } else {
            if (y == 1) {
                if (cells[y + 1][x] == 'X') {
                    mapComputer.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
                    cyclePositionShip();
                }
            } else {
                if (cells[y - 1][x] == 'X') {
                    mapComputer.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
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
            if (shipY == mapComputer.SIZE_Y - 1 && shipX != mapComputer.SIZE_X - 1) {
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
            } else if (shipX == mapComputer.SIZE_X - 1 && shipY != mapComputer.SIZE_Y - 1) {
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
            } else if (shipX == mapComputer.SIZE_X - 1 && shipY == mapComputer.SIZE_Y - 1) {
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
            } else if (shipX != mapComputer.SIZE_X - 1 && shipY != mapComputer.SIZE_Y - 1) {
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
        if (removeCash < 1) {
            mapComputer.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, SIZE_TWO_DECK_SHIP_COMPUTER, resRandomFull);
            setShip();
        }
        removeCash++;
    }
}
