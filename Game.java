package School.homework.SeaBattle;

public class Game {
    MapComputer mapComputer = new MapComputer();
    OneDeckShip oneDeckShip = new OneDeckShip(mapComputer);
    TwoDeckShip twoDeckShip = new TwoDeckShip(mapComputer);
    Player player = new Player();

    // Игра
    public void game() {
        fillingField();
        cycleInstallPositionShip();
        cycleGame();
    }

    // Циклы установки кораблей
    public void cycleInstallPositionShip() {
        twoDeckShip.cycleTwoDeckShip();
        oneDeckShip.cycleOneDeckShip();
    }

    // Установка и показ поля
    public void fillingField() {
        mapComputer.field();
        mapComputer.fieldFake();
        mapComputer.showMapFake();
    }

    // Удар по выбранной позиции игроком
    public void playerPosition() {
        int yPosition = player.yPosition(mapComputer.SIZE_Y);
        int xPosition = player.xPosition(mapComputer.SIZE_X);
        mapComputer.shipShot(yPosition, xPosition);
    }

    // Закончена ли игра, или нет?
    public boolean isGameOver() {
        for (char[] cell : mapComputer.getCells()) {
            for (char c : cell) {
                if (c == 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    // Цикл игры
    public void cycleGame() {
        do {
            playerPosition();
            mapComputer.showMapFake();
        } while (!(isGameOver()));
        System.out.println("Вы потопили все корабли. Поздравляем.");
    }
}
