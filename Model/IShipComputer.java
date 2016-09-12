package School.homework.SeaBattle.Model;

/**
 * Created by Администратор on 08.09.2016.
 */
public interface IShipComputer {
    void setShip();

    void cyclePositionShip();

    void checkShip(int i);

    boolean returnResultCheckPositionShip(int i);

    void checkOnOthersShip(int shipY, int shipX, int res);

    void reinstallShip();

}
