package School.homework.SeaBattle;

import java.util.Scanner;

public class Player {
    public int xPosition(int sizeX) {
        System.out.println("Введите координату X");
        Scanner scannerX = new Scanner(System.in);
        String xS = scannerX.nextLine();
        while (xS.trim().length() == 0 || Integer.parseInt(xS) < 1 || Integer.parseInt(xS) >= sizeX) {
            System.out.print("Вы выстрелили за пределы карты ( Макс. значение " + (sizeX - 1) + ", Мин. значение 1 ), ");
            System.out.println("или же не ввели никакого значение(числа), прошу повторить попытку.\n");
            System.out.println("Введите координату X");
            xS = scannerX.nextLine();
        }
        int x = Integer.parseInt(xS);
        System.out.println("Вы ввели " + x + "\n");
        return x;
    }

    public int yPosition(int sizeY) {
        System.out.println("Введите координату Y");
        Scanner scannerY = new Scanner(System.in);
        String yS = scannerY.nextLine();
        while (yS.trim().length() == 0 || Integer.parseInt(yS) < 1 || Integer.parseInt(yS) >= sizeY) {
            System.out.print("Вы выстрелили за пределы карты ( Макс. значение " + (sizeY - 1) + ", Мин. значение 1 ), ");
            System.out.println("или же не ввели никакого значение(числа), прошу повторить попытку.\n");
            System.out.println("Введите координату Y");
            yS = scannerY.nextLine();
        }
        int y = Integer.parseInt(yS);
        System.out.println("Вы ввели " + y + "\n");
        return y;
    }
}
