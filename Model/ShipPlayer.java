package School.homework.SeaBattle.Model;

abstract public class ShipPlayer {
    private int[] positionYOneDeckShip;
    private int[] positionXOneDeckShip;
    private int[] positionYTwoDeckShip;
    private int[] positionXTwoDeckShip;
    private int[] secondPositionTwoDeckShip;

    public int[] getPositionXTwoDeckShip() {
        return positionXTwoDeckShip;
    }

    public void setPositionXTwoDeckShip(int positionXTwoDeckShip, int i) {
        this.positionXTwoDeckShip[i] = positionXTwoDeckShip;
    }

    public void setPositionYTwoDeckShip(int positionYTwoDeckShip, int i) {
        this.positionYTwoDeckShip[i] = positionYTwoDeckShip;
    }

    public void setSecondPositionTwoDeckShip(int secondPositionTwoDeckShip, int i) {
        this.secondPositionTwoDeckShip[i] = secondPositionTwoDeckShip;
    }

    public int[] getSecondPositionTwoDeckShip() {
        return secondPositionTwoDeckShip;
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
