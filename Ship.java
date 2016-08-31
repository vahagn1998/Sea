package School.homework.SeaBattle;

import java.util.Random;

abstract public class Ship {
    private int[] positionShipX;
    private int[] positionShipY;

    public void setPositionShipX(int[] positionShipX) {
        this.positionShipX = positionShipX;
    }

    public void setPositionShipY(int[] positionShipY) {
        this.positionShipY = positionShipY;
    }

    public int[] getPositionShipX() {
        return positionShipX;
    }

    public int[] getPositionShipY() {
        return positionShipY;
    }

    public void setPositionShipX(int sizeShip) {
        positionShipX = new int[sizeShip];
    }

    public void setPositionShipY(int sizeShip) {
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
