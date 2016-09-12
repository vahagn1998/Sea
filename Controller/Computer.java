package School.homework.SeaBattle.Controller;

import School.homework.SeaBattle.Model.IShootCoordinates;

import java.util.Random;

/**
 * Created by Администратор on 01.09.2016.
 */
public class Computer implements IShootCoordinates {
    @Override
    public int yPosition(int sizeY) {
        Random randomY = new Random();
        int y = randomY.nextInt(sizeY - 1) + 1;
        return y;
    }

    @Override
    public int xPosition(int sizeX) {
        Random randomX = new Random();
        int x = randomX.nextInt(sizeX - 1) + 1;
        return x;
    }
}
