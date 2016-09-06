package School.homework.SeaBattle.Model;

public class TwoDeckShipPlayer extends ShipPlayer {
    public static final int SIZE_TWO_DECK_SHIP_PLAYER = 3;
    MapPlayer mapPlayer;
    Player player;

    public TwoDeckShipPlayer(MapPlayer mapPlayer, Player player) {
        this.mapPlayer = mapPlayer;
        this.player = player;
    }
}
