package School.homework.SeaBattle;

/**
 * Created by Администратор on 01.09.2016.
 */
abstract public class ShipPlayer {
    private int positionYTwoDeckShip;
    private int positionYOneDeckShip;
    private int positionXTwoDeckShip;
    private int positionXOneDeckShip;
    private int secondPositionTwoDeckShip;

    public int getPositionXTwoDeckShip() {
        return positionXTwoDeckShip;
    }

    public void setPositionXTwoDeckShip(int positionXTwoDeckShip) {
        this.positionXTwoDeckShip = positionXTwoDeckShip;
    }

    public int getPositionXOneDeckShip() {
        return positionXOneDeckShip;
    }

    public void setPositionXOneDeckShip(int positionXOneDeckShip) {
        this.positionXOneDeckShip = positionXOneDeckShip;
    }

    public int getSecondPositionTwoDeckShip() {
        return secondPositionTwoDeckShip;
    }

    public void setSecondPositionTwoDeckShip(int secondPositionTwoDeckShip) {
        this.secondPositionTwoDeckShip = secondPositionTwoDeckShip;
    }

    public int getPositionYTwoDeckShip() {
        return positionYTwoDeckShip;
    }

    public void setPositionYTwoDeckShip(int positionYTwoDeckShip) {
        this.positionYTwoDeckShip = positionYTwoDeckShip;
    }

    public int getPositionYOneDeckShip() {
        return positionYOneDeckShip;
    }

    public void setPositionYOneDeckShip(int positionYOneDeckShip) {
        this.positionYOneDeckShip = positionYOneDeckShip;
    }
}
