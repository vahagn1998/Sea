package School.homework.SeaBattle.Model;

import java.util.Random;

abstract public class ShipComputer implements IShipComputer {
    private int[] positionsShipsX;
    private int[] positionsShipsY;

    public int[] getPositionsShipsX() {
        return positionsShipsX;
    }

    public int[] getPositionsShipsY() {
        return positionsShipsY;
    }

    public void setSizePositionShipX(int sizeShip) {
        positionsShipsX = new int[sizeShip];
    }

    public void setSizePositionShipY(int sizeShip) {
        positionsShipsY = new int[sizeShip];
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
