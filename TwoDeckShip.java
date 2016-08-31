package School.homework.SeaBattle;

import java.util.Random;

public class TwoDeckShip extends Ship {
    Map map;
    public static final int SIZE_TWO_DECK_SHIP = 3;
    char[][] cells;
    int[] twoDeckShipX;
    int[] twoDeckShipY;
    int[] resRandomFull = new int[SIZE_TWO_DECK_SHIP];

    public TwoDeckShip(Map map) {
        this.map = map;
        cells = map.getCells();
    }

    public void setSizeTwoDeckShip(){
        super.setSizePositionShipX(SIZE_TWO_DECK_SHIP);
        super.setSizePositionShipY(SIZE_TWO_DECK_SHIP);
        twoDeckShipX = super.getPositionShipX();
        twoDeckShipY = super.getPositionShipY();
    }

    public void cycleTwoDeckShip() {
        cyclePositionTwoShip();
        for (int i = 0; i < SIZE_TWO_DECK_SHIP; i++) {
            checkOnOthersTwoDeckShip(twoDeckShipY[i], twoDeckShipX[i], resRandomFull[i]);
        }
    }

    public void cyclePositionTwoShip() {
        for (int i = 0; checkAndReturnValueCyclePositionTwoDeckShip(); i++) {
            Random rand = new Random();
            resRandomFull[i] = rand.nextInt(2);
            twoDeckShipX[i] = randomPositionShip(map.SIZE_X, SIZE_TWO_DECK_SHIP);
            twoDeckShipY[i] = randomPositionShip(map.SIZE_Y, SIZE_TWO_DECK_SHIP);
            checkTwoDeckShip(i);
            checkOnSecondDeckForTwoDeckShip(twoDeckShipY[i], twoDeckShipX[i], i);
            map.setTwoDeckShip(twoDeckShipY[i], twoDeckShipX[i], resRandomFull[i]);
        }
    }

    public void checkTwoDeckShip(int i) {
        while (returnResultCheckPositionTwoShip(i)) {
            twoDeckShipX[i] = randomPositionShip(map.SIZE_X, SIZE_TWO_DECK_SHIP);
            twoDeckShipY[i] = randomPositionShip(map.SIZE_Y, SIZE_TWO_DECK_SHIP);
        }
    }

    public boolean returnResultCheckPositionTwoShip(int i) {
        boolean result = false;
        if (cells[twoDeckShipY[i]][twoDeckShipX[i]] == 'X') {
            result = true;
        }
        if (twoDeckShipY[i] != map.SIZE_Y - 1) {
            if (cells[twoDeckShipY[i] + 1][twoDeckShipX[i]] == 'X') {
                result = true;
            }
        } else if (twoDeckShipX[i] != map.SIZE_X - 1) {
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
                    map.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
                    cyclePositionTwoShip();

                }
            } else {
                if (cells[y][x - 1] == 'X') {
                    map.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
                    cyclePositionTwoShip();
                }
            }
        } else {
            if (y == 1) {
                if (cells[y + 1][x] == 'X') {
                    map.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
                    cyclePositionTwoShip();
                }
            } else {
                if (cells[y - 1][x] == 'X') {
                    map.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, i, resRandomFull);
                    cyclePositionTwoShip();
                }
            }
        }
    }

    public boolean checkAndReturnValueCyclePositionTwoDeckShip() {
        int counter = 1;
        boolean checkStrength = true;
        for (char[] cell : cells) {
            for (char c : cell) {
                if (counter <= SIZE_TWO_DECK_SHIP * 2) {
                    if (c == 'X') {
                        if (counter == SIZE_TWO_DECK_SHIP * 2) {
                            checkStrength = false;
                        }
                        counter++;
                    }
                }
            }
        }
        return checkStrength;
    }

    public void checkOnOthersTwoDeckShip(int shipY, int shipX, int res) {
        while (true) {
            if (shipY == map.SIZE_Y - 1 && shipX != map.SIZE_X - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallTwoDeckShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallTwoDeckShip();
                        }
                    }
                }
                break;
            } else if (shipX == map.SIZE_X - 1 && shipY != map.SIZE_Y - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]  || 'X' == cells[shipY + 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY + 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    }
                }
                break;
            } else if (shipX == map.SIZE_X - 1 && shipY == map.SIZE_Y - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1]) {
                            reinstallTwoDeckShip();
                        }
                    }
                }
                break;
            } else if (shipX != map.SIZE_X - 1 && shipY != map.SIZE_Y - 1) {
                if (res == 0) {
                    if (shipX == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY - 1][shipX] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallTwoDeckShip();
                        }
                    }
                } else {
                    if (shipY == 1) {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY - 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallTwoDeckShip();
                        }
                    } else {
                        if ('X' == cells[shipY][shipX - 1] || 'X' == cells[shipY + 1][shipX] || 'X' == cells[shipY][shipX + 1]) {
                            reinstallTwoDeckShip();
                        }
                    }
                }
                break;
            }
        }
    }

    public void reinstallTwoDeckShip() {
        if (removeCash < 1) {
            map.removeTwoDeckShip(twoDeckShipY, twoDeckShipX, SIZE_TWO_DECK_SHIP, resRandomFull);
            cycleTwoDeckShip();
        }
        removeCash++;
    }
}
