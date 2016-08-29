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

    public int oneDeckShipX(int sizeX) {
        Random oneDeckRandomX = new Random();
        int[] x = new int[SIZE_ONE_DECK_SHIP];
        for (int i = 0; i < SIZE_ONE_DECK_SHIP; i++) {
            x[i] = oneDeckRandomX.nextInt(sizeX - 1) + 1;
            return x[i];
        }
        return 0;
    }

    public int oneDeckShipY(int sizeY) {
        Random oneDeckRandomY = new Random();
        int[] y = new int[SIZE_ONE_DECK_SHIP];
        for (int i = 0; i < SIZE_ONE_DECK_SHIP; i++) {
            y[i] = oneDeckRandomY.nextInt(sizeY - 1) + 1;
            return y[i];
        }
        return 0;
    }

    public int twoDeckShipX(int sizeX) {
        Random twoDeckRandomX = new Random();
        int[] x = new int[2];
        for (int i = 0; i < SIZE_TWO_DECK_SHIP; i++) {
            x[i] = twoDeckRandomX.nextInt(sizeX - 1) + 1;
            return x[i];
        }
        return 0;
    }

    public int twoDeckShipY(int sizeY) {
        Random twoDeckRandomY = new Random();
        int[] x = new int[SIZE_TWO_DECK_SHIP];
        for (int i = 0; i < SIZE_TWO_DECK_SHIP; i++) {
            x[i] = twoDeckRandomY.nextInt(sizeY - 1) + 1;
            return x[i];
        }
        return 0;
    }
}
