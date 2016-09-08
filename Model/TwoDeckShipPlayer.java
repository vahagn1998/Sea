package School.homework.SeaBattle.Model;

public class TwoDeckShipPlayer extends ShipPlayer {
    public static final int SIZE_TWO_DECK_SHIP_PLAYER = 3;
    MapPlayer mapPlayer;
    Player player;
    int select;

    public TwoDeckShipPlayer(MapPlayer mapPlayer, Player player) {
        this.mapPlayer = mapPlayer;
        this.player = player;
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
            y = getPositionYTwoDeckShip();
            x = getPositionXTwoDeckShip();
            checkShip(y[i], x[i], i);
            mapPlayer.setTwoDeckShip(y[i], x[i], select);
            mapPlayer.showMapFake();
        }
    }

    @Override
    public void checkShip(int yPosition, int xPosition, int i) {

    }
}
