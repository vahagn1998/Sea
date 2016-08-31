package School.homework.SeaBattle;

import java.util.Random;

public class Ship {
    public static final int SIZE_ONE_DECK_SHIP = 5;
    public static final int SIZE_TWO_DECK_SHIP = 3;

    private int[] oneDeckShipX = new int[SIZE_ONE_DECK_SHIP];
    private int[] oneDeckShipY = new int[SIZE_ONE_DECK_SHIP];

    private int[] twoDeckShipX = new int[SIZE_TWO_DECK_SHIP];
    private int[] twoDeckShipY = new int[SIZE_TWO_DECK_SHIP];

    public int[] getOneDeckShipX() {
        return oneDeckShipX;
    }

    public int[] getOneDeckShipY() {
        return oneDeckShipY;
    }

    public int[] getTwoDeckShipX() {
        return twoDeckShipX;
    }

    public int[] getTwoDeckShipY() {
        return twoDeckShipY;
    }

    public int randomPositionShip(int sizeX, int sizeShip) {
        Random randomX = new Random();
        int[] position = new int[sizeShip];
        for (int i = 0; i < sizeShip; i++) {
            position[i] = randomX.nextInt(sizeX - 1) + 1;
            return position[i];
        }
        return 0;
    }
}
