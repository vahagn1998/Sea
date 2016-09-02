package School.homework.SeaBattle;

import java.util.Scanner;

public class Player {
    public int xPositionPlayer(int sizeX) {
        System.out.println();
        System.out.println("Введите координату X, для стрельбы по позиции.");
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

    public int yPositionPlayer(int sizeY) {
        System.out.println();
        System.out.println("Введите координату Y, для стрельбы по позиции.");
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

    public int chooseYPosition(int sizeY){
        System.out.println();
        System.out.println("Введите координату Y, для выбора местоположения вашего коробля.");
        Scanner scannerY = new Scanner(System.in);
        String yS = scannerY.nextLine();
        while (yS.trim().length() == 0 || Integer.parseInt(yS) < 1 || Integer.parseInt(yS) >= sizeY) {
            System.out.print("Вы выбрали позицию за пределами карты ( Макс. значение " + (sizeY - 1) + ", Мин. значение 1 ), ");
            System.out.println("или же не ввели никакого значение(числа), прошу повторите выбор позиции.\n");
            System.out.println("Введите координату Y, для выбора местоположения коробля.");
            yS = scannerY.nextLine();
        }
        int y = Integer.parseInt(yS);
        System.out.println("Вы ввели " + y + "\n");
        return y;
    }

    public int chooseXPosition(int sizeX) {
        System.out.println();
        System.out.println("Введите координату X, для выбора местоположения вашего коробля.");
        Scanner scannerX = new Scanner(System.in);
        String xS = scannerX.nextLine();
        while (xS.trim().length() == 0 || Integer.parseInt(xS) < 1 || Integer.parseInt(xS) >= sizeX) {
            System.out.print("Вы выбрали позицию за пределами карты ( Макс. значение " + (sizeX - 1) + ", Мин. значение 1 ), ");
            System.out.println("или же не ввели никакого значение(числа), прошу повторите выбор позиции.\n");
            System.out.println("Введите координату X, для выбора местоположения коробля.");
            xS = scannerX.nextLine();
        }
        int x = Integer.parseInt(xS);
        System.out.println("Вы ввели " + x + "\n");
        return x;
    }
}
