package School.homework.SeaBattle;

import School.homework.SeaBattle.Controller.Computer;
import School.homework.SeaBattle.Controller.ControllerGame;
import School.homework.SeaBattle.Controller.Player;
import School.homework.SeaBattle.Model.*;
import School.homework.SeaBattle.View.MapComputer;
import School.homework.SeaBattle.View.MapPlayer;

public class Game {
    MapComputer mapComputer = new MapComputer();
    MapPlayer mapPlayer = new MapPlayer();
    Player player = new Player();
    Computer computer = new Computer();
    OneDeckShipComputer oneDeckShipComputer = new OneDeckShipComputer(mapComputer);
    TwoDeckShipComputer twoDeckShipComputer = new TwoDeckShipComputer(mapComputer);
    OneDeckShipPlayer oneDeckShipPlayer = new OneDeckShipPlayer(mapPlayer, player);
    TwoDeckShipPlayer twoDeckShipPlayer = new TwoDeckShipPlayer(mapPlayer, player);
    ControllerGame controllerGame = new ControllerGame(player, mapPlayer, oneDeckShipComputer, twoDeckShipComputer, oneDeckShipPlayer, twoDeckShipPlayer);
    ModelGame modelGame = new ModelGame(mapComputer, mapPlayer, player, computer);

    // Игра
    public void game() {
        modelGame.fillingFieldComputer();
        modelGame.fillingFieldPlayer();
        controllerGame.cycleInstallPositionShip();
        cycleGame();
    }

    // Закончена ли игра, или нет?
    public boolean isGameOverComputer() {
        for (char[] cell : mapComputer.getCells()) {
            for (char c : cell) {
                if (c == 'X') {
                    return false;
                }
            }
        }
        System.out.println("Вы выиграли, поздравляем :) .");
        return true;
    }

    public boolean isGameOverPlayer() {
        for (char[] cell : mapPlayer.getCells()) {
            for (char c : cell) {
                if (c == 'X') {
                    return false;
                }
            }
        }
        System.out.println("Вы проиграли, не расстраивайтесь.");
        return true;
    }

    // Цикл игры
    public void cycleGame() {
        do {
            modelGame.playerPositionShot();
            mapComputer.showMapFake();
            modelGame.computerPositionShot();
            mapPlayer.showMapFake();
        } while (!( isGameOverComputer() || isGameOverPlayer() ));
    }
}
