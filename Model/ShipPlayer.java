package School.homework.SeaBattle.Model;

abstract public class ShipPlayer implements IShipPlayer {
    private int[] positionsYOneDeckShips;
    private int[] positionsXOneDeckShips;
    private int[] positionsYTwoDeckShips;
    private int[] positionsXTwoDeckShips;
    private int[] secondPositionsTwoDeckShips;
    int chooseX;
    int chooseY;
    int[] yPositions;
    int[] xPositions;

    public void setPositionXTwoDeckShip(int positionXTwoDeckShip, int i, int sizeShip) {
        this.positionsXTwoDeckShips = new int[sizeShip];
        this.positionsXTwoDeckShips[i] = positionXTwoDeckShip;
    }

    public void setPositionYTwoDeckShip(int positionYTwoDeckShip, int i, int sizeShip) {
        this.positionsYTwoDeckShips = new int[sizeShip];
        this.positionsYTwoDeckShips[i] = positionYTwoDeckShip;
    }

    public void setSecondPositionTwoDeckShip(int secondPositionTwoDeckShip, int i, int sizeShip) {
        this.secondPositionsTwoDeckShips = new int[sizeShip];
        this.secondPositionsTwoDeckShips[i] = secondPositionTwoDeckShip;
    }

    public int getSecondPositionTwoDeckShip(int i) {
        return secondPositionsTwoDeckShips[i];
    }

    public int[] getPositionsXTwoDeckShips() {
        return positionsXTwoDeckShips;
    }

    public int[] getPositionsYTwoDeckShips() {
        return positionsYTwoDeckShips;
    }

    public int[] getPositionsXOneDeckShips() {
        return positionsXOneDeckShips;
    }

    public void setPositionXOneDeckShip(int positionXOneDeckShip, int i, int sizeShip) {
        this.positionsXOneDeckShips = new int[sizeShip];
        this.positionsXOneDeckShips[i] = positionXOneDeckShip;
    }

    public int[] getPositionsYOneDeckShips() {
        return positionsYOneDeckShips;
    }

    public void setPositionYOneDeckShip(int positionYOneDeckShip, int i, int sizeShip) {
        this.positionsYOneDeckShips = new int[sizeShip];
        this.positionsYOneDeckShips[i] = positionYOneDeckShip;
    }
}
