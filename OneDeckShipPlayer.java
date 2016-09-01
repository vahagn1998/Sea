package School.homework.SeaBattle;

/**
 * Created by Администратор on 01.09.2016.
 */
public class OneDeckShipPlayer extends ShipPlayer {
    MapPlayer mapPlayer;
    Player player;
    public static final int SIZE_ONE_DECK_SHIP_PLAYER = 5;

    public OneDeckShipPlayer(MapPlayer mapPlayer, Player player) {
        this.mapPlayer = mapPlayer;
        this.player = player;
    }

    public void setOneDeckShip(){
        System.out.println();
        System.out.println("Здравствуйте, перед тем как начать, вы должны установить " + SIZE_ONE_DECK_SHIP_PLAYER + " однопалубных кораблей.");
        for (int i = 0; i < SIZE_ONE_DECK_SHIP_PLAYER; i++) {
            int chooseY = player.chooseYPosition(mapPlayer.SIZE_Y);
            int chooseX = player.chooseXPosition(mapPlayer.SIZE_X);
            super.setPositionYOneDeckShip(chooseY);
            super.setPositionXOneDeckShip(chooseX);
            int y = getPositionYOneDeckShip();
            int x = getPositionXOneDeckShip();
            mapPlayer.setOneDeckShip(y, x);
            mapPlayer.showMapFake();
        }
        System.out.println();
        System.out.println("Вы закончили установку однопалуюных кораблей.");
    }
}
