package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.Controller.Computer;
import School.homework.SeaBattle.Controller.Player;
import School.homework.SeaBattle.View.Map;
import School.homework.SeaBattle.View.MapComputer;
import School.homework.SeaBattle.View.MapPlayer;

/**
 * Created by Администратор on 24.09.2016.
 */
public class ModelGame {
    MapComputer mapComputer;
    MapPlayer mapPlayer;
    Player player;
    Computer computer;

    public ModelGame(MapComputer mapComputer, MapPlayer mapPlayer, Player player, Computer computer) {
        this.mapComputer = mapComputer;
        this.mapPlayer = mapPlayer;
        this.player = player;
        this.computer = computer;
    }

    int variant;

    // Установка и показ поля компьютера
    public void fillingFieldComputer() {
        mapComputer.field();
        mapComputer.fieldFake();
        mapComputer.showMapFake();
        System.out.println();
    }

    // Установка и показ поля игрока
    public void fillingFieldPlayer() {
        mapPlayer.field();
        mapPlayer.showMapFake();
    }

    // Удар по позициям компьютера
    public void playerPositionShot() {
        variant = 1;
        int yPositionPlayer = player.yPosition(Map.SIZE_Y);
        int xPositionPlayer = player.xPosition(Map.SIZE_X);
        mapComputer.shipShot(yPositionPlayer, xPositionPlayer, variant, computer, player);
    }

    //Удар по позициям игрока
    public void computerPositionShot(){
        variant = 2;
        int yPositionComputer = computer.yPosition(Map.SIZE_Y);
        int xPositionComputer = computer.xPosition(Map.SIZE_X);
        mapPlayer.shipShot(yPositionComputer, xPositionComputer, variant, computer, player);
    }
}
