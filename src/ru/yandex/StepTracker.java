package ru.yandex;


import java.util.Scanner;

//В нём будет реализована логика по сохранению и изменению количества шагов. Также в нём будет выводиться статистика.
public class StepTracker {
    Scanner scanner;
    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scanner) {
        this.scanner = scanner;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setGoalByStepsPerDay(int goalByStepsPerDay) {
        if (!UserInputCheck.isStepsCorrect(goalByStepsPerDay))
            this.goalByStepsPerDay = goalByStepsPerDay;
    }

    void addNewNumberStepsPerDay() {
        // ввод и проверка номера месяца
        System.out.println("Введите номер месяца от 1 до 12 (включительно)");
        int monthNumber = UserInputCheck.checkNumber(scanner.nextLine());
        if (UserInputCheck.isMonthCorrect(monthNumber)) return;
        // ввод и проверка дня
        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNumber = UserInputCheck.checkNumber(scanner.nextLine());
        if (UserInputCheck.isDayCorrect(dayNumber)) return;
        // ввод и проверка количества шагов
        System.out.println("Введите количество шагов");
        int steps = UserInputCheck.checkNumber(scanner.nextLine());
        if (UserInputCheck.isStepsCorrect(steps)) return;
        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1];
        // сохранение полученных данных
        monthData.days[dayNumber - 1] = steps;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца от 1 до 12 (включительно)");
        int monthNumber = UserInputCheck.checkNumber(scanner.nextLine());
        if (UserInputCheck.isMonthCorrect(monthNumber)) return;
        // получение суммы шагов за месяц
        int sumSteps = sumStepsFromMonth(monthNumber);
        // вывод общей статистики по дням
        printDaysAndStepsFromMonth(monthNumber);
        // вывод суммы шагов за месяц
        System.out.printf("Сумма шагов за месяц: %d\n", sumSteps);
        // вывод максимального пройденного количества шагов за месяц
        System.out.printf("Максимальное количество шагов за месяц: %d\n", maxSteps(monthNumber));
        // вывод среднего пройденного количества шагов за месяц
        System.out.printf("Среднее количество шагов за месяц: %d\n", sumSteps / 30);
        // вывод пройденной за месяц дистанции в километрах
        System.out.printf("Пройденная за месяц дистанция в километрах: %d\n", converter.convertToKm(sumSteps));
        // вывод количества сожжённых килокалорий за месяц
        System.out.printf("Сожжённые за месяц килокалорий: %d\n", converter.convertStepsToKilocalories(sumSteps));
        // вывод лучшей серии
        System.out.printf("Лучшая серия: %d\n", bestSeries(goalByStepsPerDay));
    }

    void printDaysAndStepsFromMonth(int monthNumber) {
        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1];
        // вывод данных
        for (int i = 0; i < monthData.days.length; i++) {
            System.out.printf("День %d: %d\n", i + 1, monthData.days[i]);
        }
    }

    int sumStepsFromMonth(int monthNumber) {
        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1];
        // вывод данных
        int sum = 0;
        for (int i = 0; i < monthData.days.length; i++) {
            sum += monthData.days[i];
        }
        return sum;
    }

    int maxSteps(int monthNumber) {
        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1];
        // вывод данных
        int max = 0;
        for (int i = 0; i < monthData.days.length; i++) {
            if (monthData.days[i] > max) {
                max = monthData.days[i];
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < monthToData.length; i++) {
            for (int j = 0; j < monthToData[i].days.length; j++) {
                if (monthToData[i].days[j] >= goalByStepsPerDay) {
                    currentSeries++;
                } else {
                    currentSeries = 0;
                }
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            }
        }
        return finalSeries;
    }
}
