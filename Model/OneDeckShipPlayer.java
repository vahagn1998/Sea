package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.Controller.Player;
import School.homework.SeaBattle.View.Map;
import School.homework.SeaBattle.View.MapPlayer;

public class OneDeckShipPlayer extends ShipPlayer {
    public static final int SIZE_ONE_DECK_SHIP_PLAYER = 5;
    MapPlayer mapPlayer;
    Player player;
    char[][] cells;

    public OneDeckShipPlayer(MapPlayer mapPlayer, Player player) {
        this.mapPlayer = mapPlayer;
        this.player = player;
        cells = mapPlayer.getCells();
    }
    @Override
    public void setShip() {
        System.out.println();
        System.out.println("И ещё, вы должны установить " + SIZE_ONE_DECK_SHIP_PLAYER + " однопалубных кораблей.");
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_PLAYER; i++) {
            chooseY = player.chooseYPosition(Map.SIZE_Y);
            chooseX = player.chooseXPosition(Map.SIZE_X);
            super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
            super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
            y = getPositionYOneDeckShip();
            x = getPositionXOneDeckShip();
            checkShip(y[i], x[i], i, 0);
            mapPlayer.setOneDeckShip(y[i], x[i]);
            mapPlayer.showMapFake();
        }
        System.out.println();
        System.out.println("Вы закончили установку однопалуюных кораблей.");
    }

    @Override
    public void setShipAuto(MapPlayer mapPlayer) {
        OneDeckShipComputer autoPlacement = new OneDeckShipComputer(mapPlayer);
        autoPlacement.setShip();
    }

    @Override
    public void checkShip(int yPosition, int xPosition, int i, int select) {
        while (true) {
            if (cells[yPosition][xPosition] == 'X') {
                System.out.println("На этой позиции уже существует корабль, или палуба корабля. Прошу, введите другие координаты.");
                chooseY = player.chooseYPosition(Map.SIZE_Y);
                chooseX = player.chooseXPosition(Map.SIZE_X);
                super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                y = getPositionYOneDeckShip();
                x = getPositionXOneDeckShip();
                checkShip(y[i], x[i], i, 0);
            }
            if (yPosition != Map.SIZE_Y - 1 && xPosition != Map.SIZE_X - 1) {
                if (cells[yPosition + 1][xPosition] == 'X' || cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition + 1] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(Map.SIZE_Y);
                    chooseX = player.chooseXPosition(Map.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkShip(y[i], x[i], i, 0);
                }
            }
            if (yPosition == Map.SIZE_Y - 1 && xPosition != Map.SIZE_X - 1) {
                if (cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition + 1] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(Map.SIZE_Y);
                    chooseX = player.chooseXPosition(Map.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkShip(y[i], x[i], i, 0);
                }
            }
            if (yPosition != Map.SIZE_Y - 1 && xPosition == Map.SIZE_X - 1) {
                if (cells[yPosition + 1][xPosition] == 'X' || cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(Map.SIZE_Y);
                    chooseX = player.chooseXPosition(Map.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkShip(y[i], x[i], i, 0);
                }
            }
            if (yPosition == Map.SIZE_Y - 1 && xPosition == Map.SIZE_X - 1) {
                if (cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(Map.SIZE_Y);
                    chooseX = player.chooseXPosition(Map.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkShip(y[i], x[i], i, 0);
                }
            }
            break;
        }
    }
}
