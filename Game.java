package School.homework.SeaBattle;

import School.homework.SeaBattle.Controller.Computer;
import School.homework.SeaBattle.Controller.Player;
import School.homework.SeaBattle.Model.OneDeckShipComputer;
import School.homework.SeaBattle.Model.OneDeckShipPlayer;
import School.homework.SeaBattle.Model.TwoDeckShipComputer;
import School.homework.SeaBattle.Model.TwoDeckShipPlayer;
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
    int variant;

    // Игра
    public void game() {
        fillingFieldComputer();
        fillingFieldPlayer();
        cycleInstallPositionShip();
        cycleGame();
    }

    // Циклы установки кораблей
    public void cycleInstallPositionShip() {
        // Размещение кораблей игрока
        String methodPlacementShip = player.choosePlacementShip();
        if(methodPlacementShip.equals("manual")){
            twoDeckShipPlayer.setShip();
            oneDeckShipPlayer.setShip();
        }
        if(methodPlacementShip.equals(("auto"))){
            twoDeckShipPlayer.setShipAuto(mapPlayer);
            oneDeckShipPlayer.setShipAuto(mapPlayer);
        }
        // Размещение кораблей компьютера
        twoDeckShipComputer.setShip();
        oneDeckShipComputer.setShip();
    }

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
        int yPositionPlayer = player.yPosition(mapComputer.SIZE_Y);
        int xPositionPlayer = player.xPosition(mapComputer.SIZE_X);
        mapComputer.shipShot(yPositionPlayer, xPositionPlayer, variant, computer, player);
    }

    //Удар по позициям игрока
    public void computerPositionShot(){
        variant = 2;
        int yPositionComputer = computer.yPosition(mapPlayer.SIZE_Y);
        int xPositionComputer = computer.xPosition(mapPlayer.SIZE_X);
        mapPlayer.shipShot(yPositionComputer, xPositionComputer, variant, computer, player);
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
            playerPositionShot();
            mapComputer.showMapFake();
            computerPositionShot();
            mapPlayer.showMapFake();
        } while (!( isGameOverComputer() || isGameOverPlayer() ));
    }
}
