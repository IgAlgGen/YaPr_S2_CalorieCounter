package ru.yandex;

public class UserInputCheck {
    static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static int checkNumber(String input) {
        if (isNumber(input)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Введите число");
            return -1;
        }
    }

    static boolean isMonthCorrect(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введите номер месяца от 1 до 12 (включительно)");
            return true;
        }
        return false;
    }

    static boolean isDayCorrect(int day) {
        if (day < 1 || day > 30) {
            System.out.println("Введите номер дня от 1 до 30 (включительно)");
            return true;
        }
        return false;
    }

    static boolean isStepsCorrect(int steps) {
        if (steps < 0) {
            System.out.println("Количество шагов должно быть положительным числом");
            return true;
        }
        return false;
    }
}
