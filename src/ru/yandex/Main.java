package ru.yandex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(sc);

        while (true) {
            printMenu();
            int choise = UserInputCheck.checkNumber(sc.nextLine());
            switch (choise) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    System.out.println("Введите цель по количеству шагов в день");
                    int goalByStepsPerDay = UserInputCheck.checkNumber(sc.nextLine());
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
        System.out.println("=".repeat(10) + "Меню" + "=".repeat(10));
        System.out.println("Выберите действие:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
    }
}