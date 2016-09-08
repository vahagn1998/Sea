package School.homework.SeaBattle.Model;

abstract public class ShipPlayer implements IShipPlayer {
    private int[] positionYOneDeckShip;
    private int[] positionXOneDeckShip;
    private int[] positionYTwoDeckShip;
    private int[] positionXTwoDeckShip;
    private int[] secondPositionTwoDeckShip;
    int chooseX;
    int chooseY;
    int[] y;
    int[] x;

    public void setPositionXTwoDeckShip(int positionXTwoDeckShip, int i, int sizeShip) {
        this.positionXTwoDeckShip = new int[sizeShip];
        this.positionXTwoDeckShip[i] = positionXTwoDeckShip;
    }

    public void setPositionYTwoDeckShip(int positionYTwoDeckShip, int i, int sizeShip) {
        this.positionYTwoDeckShip = new int[sizeShip];
        this.positionYTwoDeckShip[i] = positionYTwoDeckShip;
    }

    public void setSecondPositionTwoDeckShip(int secondPositionTwoDeckShip, int i) {
        this.secondPositionTwoDeckShip[i] = secondPositionTwoDeckShip;
    }

    public int[] getSecondPositionTwoDeckShip() {
        return secondPositionTwoDeckShip;
    }

    public int[] getPositionXTwoDeckShip() {
        return positionXTwoDeckShip;
    }

    public int[] getPositionYTwoDeckShip() {
        return positionYTwoDeckShip;
    }

    public int[] getPositionXOneDeckShip() {
        return positionXOneDeckShip;
    }

    public void setPositionXOneDeckShip(int positionXOneDeckShip, int i, int sizeShip) {
        this.positionXOneDeckShip = new int[sizeShip];
        this.positionXOneDeckShip[i] = positionXOneDeckShip;
    }

    public int[] getPositionYOneDeckShip() {
        return positionYOneDeckShip;
    }

    public void setPositionYOneDeckShip(int positionYOneDeckShip, int i, int sizeShip) {
        this.positionYOneDeckShip = new int[sizeShip];
        this.positionYOneDeckShip[i] = positionYOneDeckShip;
    }
}
