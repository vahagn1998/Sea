package School.homework.SeaBattle.Controller;

import java.util.Scanner;

public class Player implements IShootCoordinates {
    @Override
    public int xPosition(int sizeX) {
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

    @Override
    public int yPosition(int sizeY) {
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

    public int selectSecondDeck(){
        System.out.println();
        System.out.println("Как вы хотите чтобы вторая палуба была установлена? Если горизонтально - введите 0, а если вертикально - введите 1");
        Scanner scannerSelect = new Scanner(System.in);
        String sel = scannerSelect.nextLine();
        while(sel.trim().length() == 0 || Integer.parseInt(sel) < 0 || Integer.parseInt(sel) > 1){
            System.out.println("Такого варианта не существует, введите 0 (для горизонтального размещения) или 1 (для вертикального размещения).");
            sel = scannerSelect.nextLine();
        }
        int select = Integer.parseInt(sel);
        if(select == 0){
            System.out.println("Вторая палуба будет размещена горизонтально.");
        }else{
            System.out.println("Вторая палуба будет размещена вертикаольно.");
        }
        return select;
    }

    public String choosePlacementShip(){
        System.out.println("Выберите метод размещения кораблей.");
        System.out.println("Введите: auto - для автоматического размещения кораблей(компьютер за вас разместит корабли), manual - для самостоятельного размещения кораблей.");
        Scanner scannerChoosePlacement = new Scanner(System.in);
        String choosePlacement = scannerChoosePlacement.nextLine();
        while (choosePlacement == "auto" || choosePlacement == "manual" || choosePlacement.length() == 0){
            System.out.println("Вы ввели не правильно, прошу повторите.");
            System.out.println("Введите: auto - для автоматического размещения кораблей(компьютер за вас разместит корабли), manual - для самостоятельного размещения кораблей.");
            choosePlacement = scannerChoosePlacement.nextLine();
        }
        return choosePlacement;
    }
}
