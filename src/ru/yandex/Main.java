package ru.yandex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(sc);

        while (true) {
            printMenu();
            int choise = Integer.parseInt(sc.next());
            switch (choise) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    System.out.println("Введите цель по количеству шагов в день");
                    int goalByStepsPerDay = Integer.parseInt(sc.next());
                    stepTracker.setGoalByStepsPerDay(goalByStepsPerDay);
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }

    static void printMenu() {
        System.out.println("1. ввести количество шагов за определённый день");
        System.out.println("2. изменить цель по количеству шагов в день");
        System.out.println("3. напечатать статистику за определённый месяц");
        System.out.println("4. выйти из приложения");
    }
}