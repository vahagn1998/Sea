package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.View.MapPlayer;

/**
 * Created by Администратор on 08.09.2016.
 */
public interface IShipPlayer {
    void setShip();

    void setShipAuto(MapPlayer mapPlayer);

    void checkShip(int yPosition, int xPosition, int i, int select);
}
