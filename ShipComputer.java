package School.homework.SeaBattle;

import java.util.Random;

abstract public class ShipComputer {
    int removeCash;
    private int[] positionShipX;
    private int[] positionShipY;

    public int[] getPositionShipX() {
        return positionShipX;
    }

    public int[] getPositionShipY() {
        return positionShipY;
    }

    public void setSizePositionShipX(int sizeShip) {
        positionShipX = new int[sizeShip];
    }

    public void setSizePositionShipY(int sizeShip) {
        positionShipY = new int[sizeShip];
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
