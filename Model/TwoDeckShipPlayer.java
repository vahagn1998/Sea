package School.homework.SeaBattle.Model;

import School.homework.SeaBattle.Controller.Player;
import School.homework.SeaBattle.View.MapPlayer;

public class TwoDeckShipPlayer extends ShipPlayer {
    public static final int SIZE_TWO_DECK_SHIP_PLAYER = 3;
    MapPlayer mapPlayer;
    Player player;
    int select;
    char[][] cells;

    public TwoDeckShipPlayer(MapPlayer mapPlayer, Player player) {
        this.mapPlayer = mapPlayer;
        this.player = player;
        cells = mapPlayer.getCells();
    }

    @Override
    public void setShip() {
        System.out.println();
        System.out.println("Здравствуйте, перед тем как начать, вы должны установить " + SIZE_TWO_DECK_SHIP_PLAYER + " двухпалубных корабля(ей).");
        for (int i = 0; i < SIZE_TWO_DECK_SHIP_PLAYER; i++) {
            chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
            chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
            select = player.selectSecondDeck();
            super.setPositionYTwoDeckShip(chooseY, i, SIZE_TWO_DECK_SHIP_PLAYER);
            super.setPositionXTwoDeckShip(chooseX, i, SIZE_TWO_DECK_SHIP_PLAYER);
            super.setSecondPositionTwoDeckShip(select, i, SIZE_TWO_DECK_SHIP_PLAYER);
            y = getPositionYTwoDeckShip();
            x = getPositionXTwoDeckShip();
            select = getSecondPositionTwoDeckShip(i);
            checkShip(y[i], x[i], i, select);
            mapPlayer.setTwoDeckShip(y[i], x[i], select);
            mapPlayer.showMapFake();
        }
        System.out.println();
        System.out.println("Вы закончили установку двухпалубных кораблей.");
    }

    @Override
    public void checkShip(int yPosition, int xPosition, int i, int select) {
        while (true) {
            if (cells[yPosition][xPosition] == 'X') {
                System.out.println("На этой позиции уже существует корабль, или палуба корабля. Прошу, введите другие координаты.");
                chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                select = player.selectSecondDeck();
                super.setPositionYOneDeckShip(chooseY, i, SIZE_TWO_DECK_SHIP_PLAYER);
                super.setPositionXOneDeckShip(chooseX, i, SIZE_TWO_DECK_SHIP_PLAYER);
                super.setSecondPositionTwoDeckShip(select, i, SIZE_TWO_DECK_SHIP_PLAYER);
                y = getPositionYOneDeckShip();
                x = getPositionXOneDeckShip();
                select = getSecondPositionTwoDeckShip(i);
                checkShip(y[i], x[i], i, select);
            }
            if (yPosition != mapPlayer.SIZE_Y - 1 && xPosition != mapPlayer.SIZE_X - 1) {
                if (cells[yPosition + 1][xPosition] == 'X' || cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition + 1] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    select = player.selectSecondDeck();
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setSecondPositionTwoDeckShip(select, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    select = getSecondPositionTwoDeckShip(i);
                    checkShip(y[i], x[i], i, select);
                }
            }
            if (yPosition == mapPlayer.SIZE_Y - 1 && xPosition != mapPlayer.SIZE_X - 1) {
                if (cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition + 1] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    select = player.selectSecondDeck();
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setSecondPositionTwoDeckShip(select, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    select = getSecondPositionTwoDeckShip(i);
                    checkShip(y[i], x[i], i, select);
                }
            }
            if (yPosition != mapPlayer.SIZE_Y - 1 && xPosition == mapPlayer.SIZE_X - 1) {
                if (cells[yPosition + 1][xPosition] == 'X' || cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    select = player.selectSecondDeck();
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setSecondPositionTwoDeckShip(select, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    select = getSecondPositionTwoDeckShip(i);
                    checkShip(y[i], x[i], i, select);
                }
            }
            if (yPosition == mapPlayer.SIZE_Y - 1 && xPosition == mapPlayer.SIZE_X - 1) {
                if (cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    select = player.selectSecondDeck();
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    super.setSecondPositionTwoDeckShip(select, i, SIZE_TWO_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    select = getSecondPositionTwoDeckShip(i);
                    checkShip(y[i], x[i], i, select);
                }
            }
            break;
        }
    }
}
