package School.homework.SeaBattle.Model;

public class OneDeckShipPlayer extends ShipPlayer {
    public static final int SIZE_ONE_DECK_SHIP_PLAYER = 5;
    MapPlayer mapPlayer;
    Player player;
    char[][] cells;
    int chooseX;
    int chooseY;
    int[] y;
    int[] x;

    public OneDeckShipPlayer(MapPlayer mapPlayer, Player player) {
        this.mapPlayer = mapPlayer;
        this.player = player;
        cells = mapPlayer.getCells();
    }

    public void setOneDeckShip() {
        System.out.println();
        System.out.println("Здравствуйте, перед тем как начать, вы должны установить " + SIZE_ONE_DECK_SHIP_PLAYER + " однопалубных кораблей.");
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_PLAYER; i++) {
            chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
            chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
            super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
            super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
            y = getPositionYOneDeckShip();
            x = getPositionXOneDeckShip();
            checkOneDeckShip(y[i], x[i], i);
            mapPlayer.setOneDeckShip(y[i], x[i]);
            mapPlayer.showMapFake();
        }
        System.out.println();
        System.out.println("Вы закончили установку однопалуюных кораблей.");
    }

    public void checkOneDeckShip(int yPosition, int xPosition, int i) {
        while (true) {
            if (cells[yPosition][xPosition] == 'X') {
                System.out.println("На этой позиции уже существует корабль, или палуба корабля. Прошу, введите другие координаты.");
                chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                y = getPositionYOneDeckShip();
                x = getPositionXOneDeckShip();
                checkOneDeckShip(y[i], x[i], i);
            }
            if (yPosition != mapPlayer.SIZE_Y && xPosition != mapPlayer.SIZE_X) {
                if (cells[yPosition + 1][xPosition] == 'X' || cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition + 1] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkOneDeckShip(y[i], x[i], i);
                }
            }
            if (yPosition == mapPlayer.SIZE_Y && xPosition != mapPlayer.SIZE_X) {
                if (cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition + 1] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkOneDeckShip(y[i], x[i], i);
                }
            }
            if (yPosition != mapPlayer.SIZE_Y && xPosition == mapPlayer.SIZE_X) {
                if (cells[yPosition + 1][xPosition] == 'X' || cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkOneDeckShip(y[i], x[i], i);
                }
            }
            if (yPosition == mapPlayer.SIZE_Y && xPosition == mapPlayer.SIZE_X) {
                if (cells[yPosition - 1][xPosition] == 'X' || cells[yPosition][xPosition - 1] == 'X') {
                    System.out.println("Вы не можете разместить корабль вплотную рядом с другим. Прошу, разместите корабль на другую позицию.");
                    chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
                    chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
                    super.setPositionYOneDeckShip(chooseY, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    super.setPositionXOneDeckShip(chooseX, i, SIZE_ONE_DECK_SHIP_PLAYER);
                    y = getPositionYOneDeckShip();
                    x = getPositionXOneDeckShip();
                    checkOneDeckShip(y[i], x[i], i);
                }
            }
            break;
        }
    }
}
