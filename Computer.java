package School.homework.SeaBattle;

import java.util.Random;

/**
 * Created by Администратор on 01.09.2016.
 */
public class Computer {
    public int xPositionComputer(int sizeX){
        Random randomX = new Random();
        int x = randomX.nextInt(sizeX - 1) + 1;
        return x;
    }

    public int yPositionComputer(int sizeY){
        Random randomX = new Random();
        int y = randomX.nextInt(sizeY - 1) + 1;
        return y;
    }
}
