package School.homework.SeaBattle.Controller;

import School.homework.SeaBattle.Model.OneDeckShipComputer;
import School.homework.SeaBattle.Model.OneDeckShipPlayer;
import School.homework.SeaBattle.Model.TwoDeckShipComputer;
import School.homework.SeaBattle.Model.TwoDeckShipPlayer;
import School.homework.SeaBattle.View.MapPlayer;

/**
 * Created by Администратор on 24.09.2016.
 */
public class ControllerGame {
    Player player;
    MapPlayer mapPlayer;
    OneDeckShipComputer oneDeckShipComputer;
    TwoDeckShipComputer twoDeckShipComputer;
    OneDeckShipPlayer oneDeckShipPlayer;
    TwoDeckShipPlayer twoDeckShipPlayer;

    public ControllerGame(Player player, MapPlayer mapPlayer, OneDeckShipComputer oneDeckShipComputer, TwoDeckShipComputer twoDeckShipComputer, OneDeckShipPlayer oneDeckShipPlayer, TwoDeckShipPlayer twoDeckShipPlayer) {
        this.player = player;
        this.mapPlayer = mapPlayer;
        this.oneDeckShipComputer = oneDeckShipComputer;
        this.twoDeckShipComputer = twoDeckShipComputer;
        this.oneDeckShipPlayer = oneDeckShipPlayer;
        this.twoDeckShipPlayer = twoDeckShipPlayer;
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
}
