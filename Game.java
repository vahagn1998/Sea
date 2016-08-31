package School.homework.SeaBattle;

import java.util.Random;

public class Game {
    Map map = new Map();
    OneDeckShip oneDeckShip = new OneDeckShip(map);
    TwoDeckShip twoDeckShip = new TwoDeckShip(map);
    Player player = new Player();

    // Игра
    public void game() {
        fillingField();
        cycleInstallPositionShip();
        cycleGame();
    }

    // Циклы установки кораблей
    public void cycleInstallPositionShip() {
        twoDeckShip.setSizeTwoDeckShip();
        twoDeckShip.cycleTwoDeckShip();
        oneDeckShip.setSizeOneDeckShip();
        oneDeckShip.cycleOneDeckShip();
    }

    // Установка и показ поля
    public void fillingField() {
        map.field();
        map.fieldFake();
        map.showMapFake();
    }

    // Удар по выбранной позиции игроком
    public void playerPosition() {
        int yPosition = player.yPosition(map.SIZE_Y);
        int xPosition = player.xPosition(map.SIZE_X);
        map.sunkShip(yPosition, xPosition);
    }

    // Закончена ли игра, или нет?
    public boolean isGameOver() {
        for (char[] cell : map.getCells()) {
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
            map.showMapFake();
        } while (!(isGameOver()));
        System.out.println("Вы потопили все корабли. Поздравляем.");
    }
}
